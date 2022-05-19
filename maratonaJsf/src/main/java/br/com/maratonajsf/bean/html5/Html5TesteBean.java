package br.com.maratonajsf.bean.html5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class Html5TesteBean implements Serializable{

    private String email;
    private Map<String, String> attributes = new HashMap<>();
    
    public void init(){
        attributes.put("type", "email");
        attributes.put("placeholder", "Informe seu email");
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
    
}
