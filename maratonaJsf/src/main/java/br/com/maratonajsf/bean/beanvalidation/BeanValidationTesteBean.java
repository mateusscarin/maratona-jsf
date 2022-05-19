package br.com.maratonajsf.bean.beanvalidation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@ViewScoped
public class BeanValidationTesteBean implements Serializable{
    
    @Size(min = 3, max = 10, message="O nome tem que ter entre 3 e 10 caracteres")
    @NotNull(message="o Nome é obrigatório")
    private String nome;
    
    @Pattern(regexp = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", message="Digite um email válido")
    private String email;
    
    @DecimalMax(value = "30.50", message="O valor decimal não pode ser maior que 30.50")
    @DecimalMin(value = "5.00", message="O valor decimal não pode ser menor que 5.00")
    private double decimal;
    
    @Digits(integer = 3, fraction = 2,message = "O valor não pode ser maior que 999 e casa decimal maior que 2 dígitos")
    private double numero;
    
    public void salvar(){
        System.out.println(nome.isEmpty());
        System.out.println(nome);
        System.out.println(email);
        System.out.println(decimal);
        System.out.println(numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    
}
