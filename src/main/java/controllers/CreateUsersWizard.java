package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Role;
import model.User;
import qualifiers.CreateUserEventQualifier;
import qualifiers.ProducerRolesList;
import qualifiers.UserProducerAnnotation;
import ejb.UserEjb;
import events.CreateUserEvent;


@ConversationScoped
@Named("userWizard")
public class CreateUsersWizard implements Serializable {
	

	private static final long serialVersionUID = -6923605787614846958L;



	public CreateUsersWizard(){
		
	}
	
	private String userRole;
	
	@Inject
	@CreateUserEventQualifier
	Event<CreateUserEvent> aEvent;
	
	@Inject
	private Conversation aConversation;
	
	@Inject 
	private UserEjb aUserEjb;
	
	@Inject
	@UserProducerAnnotation
	private User aUser;
	
	@Inject
	@ProducerRolesList
	private List<Role> aRoleList;
	
	
	
	public String startConversation(){
		
		if (aConversation.isTransient()){
			aConversation.begin();
			
		}
		
		return "/protected/createUserWizard/step1";
		
	}
	
	
	public String startConversationRichFaces(){
		
		if (aConversation.isTransient()){
			aConversation.begin();
			
		}
		
		return "/protected/createUserWizard/richfaces/step1rf";
		
	}
	
    public String step2RichFaces(){
		
		return "/protected/createUserWizard/richfaces/step2rf";
		
	}
	
	
	public String step2(){
		
		return "/protected/createUserWizard/step2";
		
	}
	
   public String finalStep(){
		
		return "/protected/createUserWizard/finalStep";
		
	}
   
   public String finalStepRf(){
		
		return "/protected/createUserWizard/richfaces/finalStepRF";
		
	}
	
	public String endConversation(){
		
		if (!aConversation.isTransient()){
			aConversation.end();
			
		}
		
		List<Role> aListRoles = new ArrayList<Role>();
		List<User> aListUser = new ArrayList<User>();
		aListUser.add(aUser);
		Role aRole = new Role();
		aRole.setRolename(getUserRole());
		aRole.setUsers(aListUser);
		aUser.setRoles(aListRoles);
		
		aUserEjb.createUser(aUser);
		
		CreateUserEvent aFireEvent = new CreateUserEvent();
		
		aEvent.fire(aFireEvent);
		
		return "/protected/createUserWizard/richfaces/startUserCreate?faces-redirect=true";
		
		
	}

	public User getaUser() {
		return aUser;
	}

	public void setaUser(User aUser) {
		this.aUser = aUser;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public void validateUser(FacesContext context, UIComponent component,
			Object arg2) {

		User aUser = new User();
		aUser.setUsername((String) arg2);
		aUser = aUserEjb.findUser(aUser);
		if (aUser != null) {
			UIInput inputComponent = (UIInput) component;
			inputComponent.setValid(false);
			context.addMessage(component.getClientId(context),
					new FacesMessage("Usuario ya existente"));

		} else {
			return;
		}

	}
	
	

}
