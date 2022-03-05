package DIO.Desafio.POO.Domain;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class BootCamp {
    private String nomeBootCamp;
    private String descricaoBootCamp;
    private List<Curso> cursosBootCamp = new LinkedList<>();
    private List<Mentoria> mentoriasBootCamp = new LinkedList<>();
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dataFinal = dataInicio.plusDays(45);
    private List<Dev> devsInscritos = new LinkedList<>();


    public BootCamp(String nomeBootCamp, String descricaoBootCamp) {
        this.nomeBootCamp = nomeBootCamp;
        this.descricaoBootCamp = descricaoBootCamp;
    }

    public BootCamp(BootCamp origem) {
        this.nomeBootCamp = origem.nomeBootCamp;
        this.descricaoBootCamp = origem.descricaoBootCamp;
        this.cursosBootCamp = new ArrayList<>(origem.cursosBootCamp);
        this.mentoriasBootCamp = new ArrayList<>(origem.mentoriasBootCamp);
        this.devsInscritos = new LinkedList<>(origem.devsInscritos);
    }

    public String getNomeBootCamp() { return nomeBootCamp; }
    public void setNomeBootCamp(String nomeBootCamp) { this.nomeBootCamp = nomeBootCamp; }

    public String getDescricaoBootCamp() { return descricaoBootCamp; }
    public void setDescricaoBootCamp(String descricaoBootCamp) { this.descricaoBootCamp = descricaoBootCamp; }

    public List<Curso> getCursosBootCamp() { return cursosBootCamp; }
    public void setCursosBootCamp(Curso curso) { this.cursosBootCamp.add(curso); }
    public void delCurso(int indice) { this.cursosBootCamp.remove(indice); }

    public List<Mentoria> getMentoriasBootCamp() { return mentoriasBootCamp; }
    public void setMentoriasBootCamp(Mentoria mentoria) { this.mentoriasBootCamp.add(mentoria); }
    public void delMentoria(int indice) { this.mentoriasBootCamp.remove(indice); }

    public LocalDate getDataInicial() { return dataInicio; }
    public LocalDate getDataFinal() { return dataFinal; }

    public List<Dev> getDevsInscritos() { return devsInscritos; }
    public void setDevsInscritos(Dev devsInscritos) { this.devsInscritos.add(devsInscritos); }
    public void delDevsInscritos(int indice) { this.devsInscritos.remove(indice); }

    @Override
    public String toString() {
        return "BootCamp{" +
                "nome='" + nomeBootCamp + '\'' +
                ", descricao='" + descricaoBootCamp + '\'' +
                ", dataInicial=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", devsInscritos=" + devsInscritos +
                ", conteudos=" + cursosBootCamp +
                ", conteudos=" + mentoriasBootCamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BootCamp bootCamp = (BootCamp) o;
        return nomeBootCamp != null ? nomeBootCamp.equals(bootCamp.nomeBootCamp) : bootCamp.nomeBootCamp.equals(null);
    }

    @Override
    public int hashCode() {
        return nomeBootCamp != null ? nomeBootCamp.hashCode() : 0;
    }
}
