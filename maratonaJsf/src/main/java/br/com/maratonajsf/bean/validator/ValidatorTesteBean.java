package br.com.maratonajsf.bean.validator;

import br.com.maratonajsf.model.Estudante;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ValidatorTesteBean implements Serializable{
    
    private Estudante estudante = new Estudante();
    
    public void save(){
        System.out.println("Salvando");
        System.out.println(estudante.getEmail());
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
    
}
