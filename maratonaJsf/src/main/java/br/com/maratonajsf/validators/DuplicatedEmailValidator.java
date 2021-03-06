package br.com.maratonajsf.validators;

import br.com.maratonajsf.bean.login.LoginBean;
import static java.util.Arrays.asList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@FacesValidator
public class DuplicatedEmailValidator implements Validator{

    private List<String> emailsBD = asList("mateus@gmail.com", "mateus.scarin@gestaotec.com", "scarin@fatec.com");
    
    @Inject
    private LoginBean loginBean;
    
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println(loginBean.getLanguage());
        String email = (String) o;
        if(emailsBD.contains(email)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O email já foi cadastrado", "");
            throw new ValidatorException(message);
        }
    }
}
