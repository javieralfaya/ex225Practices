package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import model.User;
import ejb.UserEjb;

@FacesValidator("userExistVlaidator")
public class UserExistVlaidator implements Validator {
	
	@Inject
	private UserEjb aUserEjb;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		User aUser = new User();
		aUser.setUsername((String) arg2);
		
		aUser = aUserEjb.findUser(aUser);
		
		if (aUser!=null){
			FacesMessage msg = new FacesMessage(" Usuario ya existe.",
					"No puede ser:" + aUser.getUsername());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(msg);
		}
		
		
	}

}
