package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("commentsValidator")
public class CustomValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent componenet,
			Object value) throws ValidatorException {

		if (value.equals("comentario")) {
			FacesMessage msg = new FacesMessage(" Comentario a fallado.",
					"No puede ser comentario");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(msg);

		}

	}
}
