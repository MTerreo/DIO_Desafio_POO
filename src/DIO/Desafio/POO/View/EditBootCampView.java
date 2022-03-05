package DIO.Desafio.POO.View;

import DIO.Desafio.POO.Domain.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class EditBootCampView {
    private BootCamp bootCamp;

    public EditBootCampView(BootCamp bootCamp, int origem) {
        if (origem == 1) {
            this.bootCamp = new BootCamp(bootCamp);
        } else {
            this.bootCamp = new BootCamp(bootCamp.getNomeBootCamp(), bootCamp.getDescricaoBootCamp());
        }
    }

    public  BootCamp edit() {
        boolean confirma = false;
        boolean fim = true;
        String salva;

        do {
            salva = showMenu();
            new BootCampView(bootCamp).fullView(System.out);
            if (salva.equalsIgnoreCase("S")||salva.equalsIgnoreCase("X")) {
                fim = false;
                if (salva.equalsIgnoreCase("S")) confirma = true;
            }
        } while(fim);

        if (confirma) {
            return bootCamp;
        } else {
            return null;
        }
    }

    private String showMenu() {
        String[] options = new String[8];
        StringBuilder sb = new StringBuilder("#".repeat(35)).append(" Menu para editar um BootCamp ").append("#".repeat(35));
        System.out.println("Selecione o campo do bootcamp que deseja editar: ");
        sb.append("%n").append("  N : Nome                 ");
        options[0] = "N";
        sb.append("  D : Descrição                 ");
        options[1] = "D";
        sb.append("  C : Conteudo %n");
        options[2] = "C";
        sb.append("  A : Alunos               ");
        options[3] = "A";
        sb.append("  I : Data Início               ");
        options[4] = "C";
        sb.append("  T : Tempo  %n");
        options[5] = "T";

        sb.append("  # ").append("# ".repeat(48)).append("%n");
        sb.append("  X : Sair sem salvar o BootCamp              ");
        options[6] = "X";
        sb.append("  S : Salvar o BootCamp e sair  %n");
        options[7] = "S";

        sb.append("#".repeat(100)).append("%n");

        String opcao = ConsoleUtils.getUserOption(sb.toString(), options).toUpperCase(Locale.getDefault());
        switch (opcao) {
            case "N":
                editNome();
                break;
            case "D":
                editDescricao();
                break;
            case "C":
                editConteudos();
                break;
            case "A":
                editAlunos();
                break;
            case "I":
                editDataInicio();
                break;
            case "T":
                editTempo();
                break;
            case "X":
                System.out.println("Ok, saindo sem salvar!");
                return "X";
            case "S":
                System.out.println("Ok, salvando e saindo!");
                return "S";
            default:
                System.out.println("Opção Inválida!!!");
        }
        return "";
    }

    private void editNome() {
        String novoNome = ConsoleUtils.getUserInput("Entre com o novo nome do BootCamp");

        if (!novoNome.isBlank()) {
            bootCamp.setNomeBootCamp(novoNome);
        }else{
            System.out.println("Tente novamente");
        }
    }


    private void editDescricao() {
        String novaDescricao = ConsoleUtils.getUserInput("Entre com a nova descrição do BootCamp");
        if (!novaDescricao.isBlank()) {
            bootCamp.setDescricaoBootCamp(novaDescricao);
        }else{
            System.out.println("Tente novamente");
        }
    }

    private void editConteudos() {
        do {
            new BootCampView(bootCamp).fullView(System.out);
        } while (showMenuConteudos());
    }

    private void editAlunos(){

    }
    private void editDataInicio(){

    }
    private void editTempo() {

    }

    private boolean showMenuConteudos() {
        String[] options = new String[5];
        StringBuilder sb = new StringBuilder("#".repeat(35)).append(" Menu para editar Conteudos ").append("#".repeat(35));

        sb.append("%n").append("  C : Adicionar Curso %n");
        options[0] = "C";
        sb.append("  M : Adicionar Mentoria %n");
        options[3] = "M";
        if (bootCamp.getCursosBootCamp().size() != 0) {
            sb.append("  d : Remover  Curso %n");
            options[1] = "d";
        }
        if (bootCamp.getMentoriasBootCamp().size() != 0) {
            sb.append("  n : Remover  Mentoria %n");
            options[4] = "n";
        }
        sb.append("  # ").append("# ".repeat(48)).append("%n");
        sb.append("  X : Sair dos Cursos %n");
        options[2] = "X";
        sb.append("#".repeat(100)).append("%n");

        String opcao = ConsoleUtils.getUserOption(sb.toString(), options).toUpperCase(Locale.getDefault());
        switch (opcao) {
            case "C":
                addCurso();
                break;
            case "M":
                addMentoria();
                break;
            case "d":
                delCurso();
                break;
            case "n":
                delMentoria();
                break;
            case "X":
                System.out.println("Ok, saindo do Menu dos Conteudos!!");
                return false;
            default:
                System.out.println("Opção Inválida!!!");
        }
        return true;
    }
    private void addCurso() {
        String titulo = ConsoleUtils.getUserInput("Qual o nome do Curso?");

        String descricao = ConsoleUtils.getUserInput("Qual a descrição do Curso?");

        int cargaHoraria = ConsoleUtils.getUserInt("Qual a carga horária?");

        Curso curso = new Curso(titulo, descricao, cargaHoraria);
        bootCamp.setCursosBootCamp(curso);
    }
    private void addMentoria() {
        String titulo = ConsoleUtils.getUserInput("Qual o nome da Mentoria?");
        String descricao = ConsoleUtils.getUserInput("Qual a descrição da Mentoria?");
        Date data = ConsoleUtils.getUserDate("Qual a data da mentoria?");
        Mentoria mentoria = new Mentoria(titulo, descricao, data);
        bootCamp.setMentoriasBootCamp(mentoria);
    }

    private void delCurso() {
        StringBuilder sb = new StringBuilder("Qual curso você quer excluir?\n");
        String[] options = new String[bootCamp.getCursosBootCamp().size()];
        for (int i = 0; i < options.length; i++) {
            options[i] = String.valueOf(i);
            sb.append(String.format("%d - %s %n", i, bootCamp.getCursosBootCamp().get(i).getTitulo()));
        }
        String opcao = ConsoleUtils.getUserOption(sb.toString(), options);
        System.out.println("Será escluido o curso " + opcao);

        for (int i = 0; i < options.length; i++) {
            if (opcao.equalsIgnoreCase(options[i])) {
                bootCamp.delCurso(i);
                break;
            }
        }
    }

    private void delMentoria() {
        StringBuilder sb = new StringBuilder("Qual Mentoria você quer excluir?\n");
        String[] options = new String[bootCamp.getMentoriasBootCamp().size()];
        for (int i = 0; i < options.length; i++) {
            options[i] = String.valueOf(i);
            sb.append(String.format("%d - %s %n", i, bootCamp.getMentoriasBootCamp().get(i).getTitulo()));
        }
        String opcao = ConsoleUtils.getUserOption(sb.toString(), options);
        System.out.println("Será escluido a Mentoria " + opcao);

        for (int i = 0; i < options.length; i++) {
            if (opcao.equalsIgnoreCase(options[i])) {
                bootCamp.delMentoria(i);
                break;
            }
        }
    }
}