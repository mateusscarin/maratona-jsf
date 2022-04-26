package br.com.maratonajsf.bean.application;

import br.com.maratonajsf.bean.dependent.TesteDependentBean;
import br.com.maratonajsf.bean.session.TesteSessionBean;
import java.io.Serializable;
import static java.util.Arrays.asList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {

    private List<String> categoriaList;
    private final TesteDependentBean dependentBean;
    private final TesteSessionBean sessionBean;

    @Inject
    public TesteApplicationBean(TesteDependentBean dependentBean, TesteSessionBean sessionBean) {
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("Etrou no PostContruct  do ApplicationScoped");
        categoriaList = asList("Gustavo", "Jão", "Mateus");
        dependentBean.getCategoriasList().addAll(asList("Enilso", "Pablo"));
        sessionBean.selecionarPersonagem();
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public TesteSessionBean getSessionBean() {
        return sessionBean;
    }
    
    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }
}
