package br.com.maratonajsf.bean.application;

import java.io.Serializable;
import static java.util.Arrays.asList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable{
    private List<String> categoriaList;
    
    @PostConstruct
    public void init(){
        System.out.println("Etrou no PostContruct  do ApplicationScoped");
        categoriaList = asList("Gustavo", "Jão", "Gabriel");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }

        
    
}
