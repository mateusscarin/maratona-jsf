package br.com.maratonajsf.bean.session;

import br.com.maratonajsf.model.Estudante;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class TesteSessionBean implements Serializable {

    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private Estudante estudante;

    @PostConstruct
    public void init() {
        System.out.println("Entrou dentro PostConstruct do SessionBean");
        personagens = asList("Tobey", "Michael", "John");
        logar();
    }

    public void logar() {
//  Fez consulta, verificou se está ok
        estudante = new Estudante();
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String persongem = personagens.get(index);
        personagemSelecionado.add(persongem);
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

}
