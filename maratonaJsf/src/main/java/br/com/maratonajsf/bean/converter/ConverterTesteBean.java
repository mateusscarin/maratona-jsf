package br.com.maratonajsf.bean.converter;

import br.com.maratonajsf.model.Estudante;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConverterTesteBean implements Serializable{
    
    private List<Estudante> listEstudante = Estudante.estudanteList();
    private Estudante estudante;
    
    public void save(){
        System.out.println("Salvando");
        System.out.println(estudante);
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<Estudante> getListEstudante() {
        return listEstudante;
    }

    public void setListEstudante(List<Estudante> listEstudante) {
        this.listEstudante = listEstudante;
    }

}
