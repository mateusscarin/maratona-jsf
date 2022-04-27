package br.com.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicacaoTeste3Bean implements Serializable{

    private String nome;
    private String sobrenome;

    public void init() {
        System.out.println("criou comunicacao 3");
        System.out.println(nome);
        System.out.println(sobrenome);
    }

    public String save(){
        System.out.println("Salvando no banco de dados");
        return "resultado?faces-redirect=true$apm;includeViewParams=true";
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
