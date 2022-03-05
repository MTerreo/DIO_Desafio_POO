package DIO.Desafio.POO.View;

import DIO.Desafio.POO.Domain.BootCamp;
import DIO.Desafio.POO.Domain.Curso;
import DIO.Desafio.POO.Domain.Dev;
import DIO.Desafio.POO.Domain.Mentoria;
import java.io.PrintStream;

public class BootCampView {

    private BootCamp bootCamp;

    public  BootCampView(BootCamp bootCamp) {
        this.bootCamp = bootCamp;
    }

    public void fullView(PrintStream out) {
        if (bootCamp == null) {
            out.printf("%n%s%n%n", "Nenhum bootcamp encontrado!");
        }else{
            headerView(out);
            cursosView(out);
            mentoriasView(out);
            devsView(out);   // passar para o menu Dev
        }
    }

    public void headerView(PrintStream out) {
        out.printf("%nNome:      %s%n", bootCamp.getNomeBootCamp());
        out.printf("Descrição: %s%n", bootCamp.getDescricaoBootCamp());

    }

    public void cursosView(PrintStream out) {
        out.printf("%s%n", "Lista de Cursos: ");
        if (bootCamp.getCursosBootCamp() == null || bootCamp.getCursosBootCamp().isEmpty()) {
            out.printf("%s%n", "Nenhum curso encontrado!");
        } else {
            for (Curso curso : bootCamp.getCursosBootCamp()) {
                out.printf("Título: %s  |  Descrição: %s  |  Carga horária: %s | XP: %s%n",
                        curso.getTitulo(), curso.getDescricao(), curso.getCargaHoraria(), curso.calcularXp());
            }
        }
    }

    public void mentoriasView(PrintStream out) {
        out.printf("%s%n", "Lista de Mentorias: ");
        if (bootCamp.getMentoriasBootCamp() == null || bootCamp.getMentoriasBootCamp().isEmpty()) {
            out.printf("%s%n", "Nenhuma mentoria encontrada!");
        } else {
            for (Mentoria mentoria : bootCamp.getMentoriasBootCamp()) {
                out.printf("Título: %s  |  Descrição: %s  |  Data: %s |  XP: %s%n",
                        mentoria.getTitulo(), mentoria.getDescricao(), mentoria.getData(), mentoria.calcularXp());
            }
        }
    }

    public void devsView(PrintStream out) {
        out.printf("%s%n", "Lista de Devs matriculados: ");
        if (bootCamp.getDevsInscritos() == null || bootCamp.getCursosBootCamp().isEmpty()) {
            out.printf("%s%n", "Nenhum dev matriculado!");
        } else {
            for (Dev devs : bootCamp.getDevsInscritos()) {
                out.printf("Nome: %s%n", devs.getNome());
            }
        }
    }
}
