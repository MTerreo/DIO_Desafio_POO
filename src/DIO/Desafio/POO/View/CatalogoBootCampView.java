package DIO.Desafio.POO.View;

import DIO.Desafio.POO.Controller.CatalogoBootCamp;
import DIO.Desafio.POO.Domain.BootCamp;
import DIO.Desafio.POO.Domain.ConsoleUtils;

import java.util.Locale;

public class CatalogoBootCampView {
    private CatalogoBootCamp controller;
    private BootCamp ative;
    private int indiceAtual;

    public CatalogoBootCampView(CatalogoBootCamp controller) {  //construtor
        this.controller = controller;
        if (controller.getTotal() > 0) {
            indiceAtual = 1;
            ative = controller.getBootCamp(indiceAtual);
        } else {
            indiceAtual = 0;
            ative = null;
        }
    }

    private boolean bootCampMenu() {
        String[] options = new String[8];
        StringBuilder sb = new StringBuilder("#".repeat(33)).append(" Menu para controle dos BootCamps ").append("#".repeat(33));

        sb.append("%n").append("  + : Adicionar           ");
        options[0] = "+";
        sb.append("  E : Editar                 ");
        options[1] = "E";
        sb.append("  - : Remover  %n");
        options[2] = "-";

        sb.append("  P : Próximo             ");
        options[3] = "P";
        sb.append("  A : Anterior               ");
        options[4] = "A";
        sb.append("  L : Localizar  %n");
        options[5] = "L";

        sb.append("  = ").append("= ".repeat(48)).append("%n");
        sb.append("  X : Sair                    |                        ");
        options[6] = "X";
        sb.append("  D : Menu Devs  %n");
        options[7] = "D";
        sb.append("#".repeat(100)).append("%n");

        String opcao = ConsoleUtils.getUserOption(sb.toString(), options).toUpperCase(Locale.getDefault());

        switch (opcao) {
            case "+":
                add();
                break;
            case "-":
                del();
                break;
            case "P":
                next();
                break;
             case "A":
                previous();
                break;
             case "L":
                find();
                break;
            case "E":    //chama o menu de edição
                edit();
                break;
            case "X":
                System.out.println("Obrigado!!");
                return false;
            case "D":
                devs();  //chama o menu de devs
                break;
            default:
                System.out.println("Opção inválida!!!");
        }

        return true;
    }

    private void add() {
        //Capturar o nome de um novo Bootcamp.
        String name = ConsoleUtils.getUserInput("Entre com o nome da novo Bootcamp?");
        if (!name.isBlank()) {
            //Verifica no CatalogoBootCamp se exist outro bootcamp com o mesmo nome.
            BootCamp other = controller.getBootCamp(name);
            //Se encontrar, mostra mensagem.
            if (other != null) {
                String opcao = ConsoleUtils.getUserOption("Bootcamp já existente! %nVocê deseja visualizar?%nS - Sim   N - Não", "S", "N");
                //Se confirmar, solicita ao CatalogoBootCamp apagar o Bootcamp.
                if (opcao.equalsIgnoreCase("S")) {
                    ative = other;
                }
            } else {
                //Se não encontrar continua -> Capturar dados do novo bootcamp
                String descricao = ConsoleUtils.getUserInput("Entre com a descrição do novo Bootcamp?");

                //Cria um novo bootcamp.
                System.out.println("\n");
                System.out.println("Cria bootcamp novo");

                BootCamp novo = new EditBootCampView(new BootCamp(name, descricao),2).edit();
                if (novo.getNomeBootCamp() != null) {
                    controller.add(novo);     //Passa o bootcamp para o Catalogo adicionar.
                    ative = novo;             //Torna o novo bootcamp ativo.
                    indiceAtual = 0;
                }
            }
        }
    }

    private void del() {
        //Se não estiver com um bootcamp ativo, mostra mensagem.
        //Se estiver com um bootcamp ativo, confirma a operação.
        String opcao = ConsoleUtils.getUserOption("Você deseja realmente APAGAR o bootcamp " + ative.getNomeBootCamp() + "?\nS - Sim   N - Não", "S", "N");
        //Se confirmar, solicita ao Catalogo apagar a receita.
        if (opcao.equalsIgnoreCase("S")) {
            controller.del(ative.getNomeBootCamp());
            ative = null;
            if (controller.getTotal() > 0) {
                indiceAtual = 0;
                next();
            }
        }
    }

    private void next() {
        //Se estiver com uma receita ativa, ativa a próxima receita.
        //Se NÃO estiver com uma receita ativa, ativa a primeira receita.
        if (ative != null) indiceAtual++;
        try {
            ative = controller.getBootCamp(indiceAtual);
        } catch (IllegalArgumentException e) {
            ative = null;
        }
        if (ative == null) {
            indiceAtual = 1;
            ative = controller.getBootCamp(indiceAtual);
        }
    }

    private void previous() {
        //Se estiver com um bootcamp ativo, ativar o anterior, Se NÃO estiver com um bootcamp ativo, ativar o última bootcamp.
        if (ative != null) indiceAtual--;
        try {
            ative = controller.getBootCamp(indiceAtual);
        } catch (IllegalArgumentException e) {
            ative = null;
        }
        if (ative == null) {
            indiceAtual = controller.getTotal();
            ative = controller.getBootCamp(indiceAtual);
        }
    }

    private void find() {
        //Capturar o nome do bootcamp.
        String name = ConsoleUtils.getUserInput("Qual o nome do bootcamp que deseja localizar?");
        //Procura no Catalogo a bootcamp com o mesmo nome.
        ative = controller.getBootCamp(name);
        indiceAtual = 0;
    }

    private void edit() {
        //Se não estiver com um bootcamp ativo, mostra mensagem, senão abre a tela de edição.
        System.out.println("BootCamp que vai ser editado:");
        new BootCampView(ative).fullView(System.out);
        BootCamp novo = new EditBootCampView(ative, 1).edit();

        if (novo != null) {
            controller.del(ative.getNomeBootCamp());
            controller.add(novo);
            ative = novo;    //Torna a novo bootcamp ativo.
            indiceAtual = 0;
        }
    }

    private void devs() {
        System.out.println("Em implementação.....");
    }

    public void view() {
        do {  //Exibe o layout montado e o menu de opções.
            new BootCampView(ative).fullView(System.out);
        } while (bootCampMenu());
    }
}
