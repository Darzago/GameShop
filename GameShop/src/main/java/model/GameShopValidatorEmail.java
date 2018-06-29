package model;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class GameShopValidatorEmail implements Validator
{
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
	{
		String strValue = (String) value;
		if (strValue.indexOf('@')<1 || strValue.indexOf('@')>strValue.length()-3)
			throw new ValidatorException(new FacesMessage("Der angegebene String ist keine EMail-Adresse", "Es fehlt ein @ in der Email-Adresse"));

	}

}
