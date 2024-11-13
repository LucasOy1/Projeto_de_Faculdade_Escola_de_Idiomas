package CodigoProjeto;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String idioma;
    private List<Aula> aulas;

    public Curso(String idioma) {
        this.idioma = idioma;
        this.aulas = new ArrayList<>();
    }

    //Getters e Setters
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }
    
    public String toString() {
        return "Curso de Idioma: " + idioma;
    }
}
