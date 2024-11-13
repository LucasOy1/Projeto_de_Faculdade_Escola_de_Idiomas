package CodigoProjeto;

import java.time.LocalDateTime;

public class Aula {
    private String nomeAula;
    private LocalDateTime dataHora;

    public Aula(String nomeAula, LocalDateTime dataHora) {
        this.nomeAula = nomeAula;
        this.dataHora = dataHora;
    }
    
    //Getter e setters
    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    public String toString() {
        return "Aula: " + nomeAula + " - Data e Hora: " + dataHora;
    }
}
