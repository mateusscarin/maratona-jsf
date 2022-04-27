package br.com.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicacaoTeste3Bean implements Serializable {

    private String nome;
    private String sobrenome;
    private Date data;

    public void init() throws ParseException {
//        if(!FacesContext.getCurrentInstance().isPostback()){
        System.out.println("criou comunicacao 3");
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(data);   
//        }
    }

    public String save() {
        System.out.println("Salvando no banco de dados");
        return "resultado?faces-redirect=true$apm;includeViewParams=true";
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
