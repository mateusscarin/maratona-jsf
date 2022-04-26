package br.com.maratonajsf.bean.view;

import br.com.maratonajsf.bean.dependent.TesteDependentBean;
import br.com.maratonajsf.bean.session.TesteSessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {

    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private final TesteDependentBean dependentBean;
    private final TesteSessionBean sessionBean;
    
    @Inject
    public TesteViewBean(TesteDependentBean dependentBean, TesteSessionBean sessionBean){
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("Entrou dentro PostConstruct do ViewBean");
        personagens = asList("Tobey", "Michael", "John");
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String persongem = personagens.get(index);
        personagemSelecionado.add(persongem);
        dependentBean.getPersonagemSelecionado().add(persongem);
    }

    public TesteSessionBean getSessionBean() {
        return sessionBean;
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
