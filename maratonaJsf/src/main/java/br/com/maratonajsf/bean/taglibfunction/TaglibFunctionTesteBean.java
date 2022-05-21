package br.com.maratonajsf.bean.taglibfunction;

import java.io.Serializable;
import static java.util.Arrays.asList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TaglibFunctionTesteBean implements Serializable{
    
    private List<String> names = asList("Mateus", "Enilson", "Pablo", "João", "Gustavo", "Gabriel");

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
    
}
