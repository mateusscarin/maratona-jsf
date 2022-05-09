package br.com.maratonajsf.bean.validation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ValidationTesteBean implements Serializable{
    private String password;
    
    public void salvar(){
        System.out.println(password);        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
