package br.com.maratonajsf.bean.ajax;

import java.io.Serializable;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AjaxTesteBean implements Serializable {

    private String nome;
    private String sobrenome;
    private String email;
    private Map<String, List<String>> animePersonagensMap;
    private List<String> personagens;
    private String animeSelecionado;
    private String personagemSelecionado;

    public void init() {
        System.out.println("entrou");
        animePersonagensMap = new TreeMap<>();
        animePersonagensMap.put("Hellsing", asList("Alucard", "Seras", "Alexander"));
        animePersonagensMap.put("Attack on Titan", asList("Eren", "Mikasa", "Arimin"));
        animePersonagensMap.put("Berserk", asList("Guts", "Casca", "Griffith"));
    }

    public void toUpperCase() {
        this.nome = this.nome.toUpperCase();
        this.sobrenome = this.sobrenome.toUpperCase();
        System.out.println(nome);
        System.out.println(sobrenome);
    }

    public void toUpperCaseNome() {
        this.nome = this.nome.toUpperCase();
    }

    public void onSelectAnime() {
        if (animeSelecionado == null) {
            personagens = null;
            return;
        }
        personagens = animePersonagensMap.get(animeSelecionado);
        System.out.println(personagens);
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

    public Map<String, List<String>> getAnimePersonagensMap() {
        return animePersonagensMap;
    }

    public void setAnimePersonagensMap(Map<String, List<String>> animePersonagensMap) {
        this.animePersonagensMap = animePersonagensMap;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public String getAnimeSelecionado() {
        return animeSelecionado;
    }

    public void setAnimeSelecionado(String animeSelecionado) {
        this.animeSelecionado = animeSelecionado;
    }

    public String getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(String personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
