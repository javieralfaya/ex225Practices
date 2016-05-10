package ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import qualifiers.ProducerRolesList;
import model.Role;

@Stateless
public class RolesEjb implements Serializable, RolesEjbInterface {


	private static final long serialVersionUID = 4870312884244288836L;
	
	@PersistenceContext
	private EntityManager em;

	public RolesEjb() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see ejb.RolesEjbInterface#getListRoles()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Produces
	@Named("listRoles")
	@ProducerRolesList
	public List<Role> getListRoles(){
		
		List<Role> aRoleList = new ArrayList<Role>();
		
		aRoleList = em.createNamedQuery("Role.findAll").getResultList();
		return aRoleList;
		
		
	}

}
