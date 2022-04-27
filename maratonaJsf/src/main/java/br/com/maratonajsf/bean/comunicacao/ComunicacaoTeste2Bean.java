package br.com.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.Param;

@Named
@ViewScoped
public class ComunicacaoTeste2Bean implements Serializable {

    @Inject
    @Param(name = "nome")
    private String nome;
    
    @Inject
    @Param(name = "sobrenome")
    private String sobrenome;

    @PostConstruct
    public void init() {
//        Map<String, String> paramsMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        nome = paramsMap.get("nome");
//        sobrenome = paramsMap.get("sobrenome");
        System.out.println(nome);
        System.out.println(sobrenome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

}
