package DIO.Desafio.POO.Domain;

import DIO.Desafio.POO.Controller.CatalogoBootCamp;
import DIO.Desafio.POO.View.CatalogoBootCampView;

import java.util.*;
import java.util.List;

public class Dev {
    private String nomeDev;
    private List<Curso> cursosInscritos = new LinkedList<>();
    private List<Curso> cursosConcluidos = new LinkedList<>();

    public Dev(String nomeDev) {
        this.nomeDev = nomeDev;
    }

    public Dev(Dev aluno) {
        this.nomeDev = aluno.nomeDev;
        this.cursosInscritos = new ArrayList<>(aluno.cursosInscritos);
        this.cursosConcluidos = new ArrayList<>(aluno.cursosConcluidos);
    }

    public void inscreverBootcamp(CatalogoBootCamp catalogoBootCamp){
        this.cursosInscritos.addAll(catalogoBootCamp.getBootCamp(nomeDev).getCursosBootCamp());
        this.cursosConcluidos.addAll(catalogoBootCamp.getBootCamp(nomeDev).getCursosBootCamp());
    }

    public void progredir() {
        Optional<Curso> conteudo = this.cursosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.cursosConcluidos.add(conteudo.get());
            this.cursosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.cursosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nomeDev;
    }

    public void setNome(String nome) {
        this.nomeDev = nome;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public List<Curso> getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(List<Curso> cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nomeDev, dev.nomeDev) && Objects.equals(cursosInscritos, dev.cursosInscritos) && Objects.equals(cursosConcluidos, dev.cursosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDev, cursosInscritos, cursosConcluidos);
    }
}
