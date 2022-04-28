package br.com.maratonajsf.bean.comunicacao;

import br.com.maratonajsf.model.Estudante;
import br.com.maratonajsf.util.ApplicationMapUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicacaoTeste11Bean implements Serializable {

    private List<Estudante> listaEstudantes = Estudante.estudanteList();
    
    public String editar(Estudante estudanteLista){
        listaEstudantes.remove(estudanteLista);
        ApplicationMapUtil.setValueInApplicationMap("estudante", estudanteLista);
        return "comunicacao12?faces-redirect=true";
    }

    public List<Estudante> getListaEstudantes() {
        return listaEstudantes;
    }

    public void setListaEstudantes(List<Estudante> listaEstudantes) {
        this.listaEstudantes = listaEstudantes;
    }

    
}
