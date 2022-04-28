package br.com.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class ComunicacaoTeste9Bean implements Serializable {

    private String value;
    
    public void init(){
        value = Faces.getRequestCookie("nome");
    }

    public String getValue() {
        
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
