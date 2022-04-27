package br.com.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicacaoTeste1Bean implements Serializable{

    private String nome;
    private String sobrenome;
    
    public void imprimirAtributos(){
        String initParamenter = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("images.location");
        System.out.println(initParamenter);
    }

    public String save(){
        System.out.println(nome);
        System.out.println(sobrenome);
        return "comunicacao2?faces-redirect=true&nome="+nome+"&sobrenome="+sobrenome;
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
