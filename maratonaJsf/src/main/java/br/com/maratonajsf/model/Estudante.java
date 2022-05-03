package br.com.maratonajsf.model;

import br.com.maratonajsf.model.enums.Turno;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;

@Named
public class Estudante implements Serializable {

    private Integer id;
    private String nome = "Mateus";
    private String sobrenome = "Shelby";
    private double nota1 = 20;
    private double nota2;
    private double nota3 = 10;
    private Turno turno = Turno.MATUTINO;
    private String email;

    public Estudante() {
    }

    public Estudante(Integer id, String nome, String sobrenome, double nota1) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nota1 = nota1;
    }

    public static List<Estudante> estudanteList() {
        return new ArrayList<>(asList(new Estudante(1, "Michael", "Ruim", 6),
                new Estudante(2, "Tomas", "Excelente", 10),
                new Estudante(3, "Arthur", "Doido", 9.5)));
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

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudante other = (Estudante) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
