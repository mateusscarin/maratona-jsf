package br.com.maratonajsf.bean.comunicacao;

import br.com.maratonajsf.model.Estudante;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicacaoTeste10Bean implements Serializable {

    private String password;
    private List<Estudante> listaEstudantes = Estudante.estudanteList();
    
    public void remover(Estudante estudanteLista){
        listaEstudantes.remove(estudanteLista);
    }
    
    public void salvar(){
        System.out.println(password);
    } 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Estudante> getListaEstudantes() {
        return listaEstudantes;
    }

    public void setListaEstudantes(List<Estudante> listaEstudantes) {
        this.listaEstudantes = listaEstudantes;
    }

    
}
