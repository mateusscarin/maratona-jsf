package br.com.maratonajsf.bean.dependent;

import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class TesteDependentBean implements Serializable {

    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private List<String> categoriasList = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Entrou dentro PostConstruct do @Dependent");
        personagens = asList("Tobey", "Michael", "John");
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String persongem = personagens.get(index);
        personagemSelecionado.add(persongem);
    }

    public List<String> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<String> categoriasList) {
        this.categoriasList = categoriasList;
    }
        
    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

}
