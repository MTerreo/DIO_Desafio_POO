package DIO.Desafio.POO.Domain;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {
    static Scanner scanner = new Scanner(System.in);

    private static final String INVALID_OPTION_MSG = "Opção invalida. Por favor, entre com a opção de novo:";

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String getUserInput(String question) {
        return getUserOption(question);
    }

    public static String getUserOption(String message, String... options) {
        System.out.printf(message.concat("%n# : "));
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine().trim();
        if (options.length > 0) {
            while (!isValid(option, options)) {
                System.out.printf("%s%n# : ", INVALID_OPTION_MSG);
                option = scanner.nextLine().trim();
            }
        }
        return option;
    }

    public static double getUserDouble(String message) {   //Maurico - adiconada validação
        System.out.printf(message.concat("%n# : "));

        double valor = 0d;
        Scanner scan = new Scanner(System.in);
        boolean fim = true;
        while(fim){
            try {
                System.out.println("Entre como o valor:");
                valor = scan.nextDouble();
                fim = false;
            }catch (InputMismatchException e) {
                System.out.printf("%s%n# : ", INVALID_OPTION_MSG);
                scan.nextLine();
            }
            if (valor <= 0) {
                System.out.printf("%s%n# : ", INVALID_OPTION_MSG);
                fim = true;
            }
        }

        return valor;
    }

    public static int getUserInt(String message) {
        System.out.printf(message.concat("%n# : "));
        int valor = scanner.nextInt();
        while (valor <= 0) {
            System.out.printf("%s%n# : ", INVALID_OPTION_MSG);
            valor = scanner.nextInt();
        }
        return valor;
    }

    public static Date getUserDate(String message) {
        System.out.printf(message.concat("%n# : "));
        Date date = Calendar.getInstance().getTime();
        System.out.println("Entre como o ano (AAAA):");
        int ano = scanner.nextInt();
        System.out.println("Entre como o mes (MM):");
        int mes = scanner.nextInt();
        System.out.println("Entre como o dia (DD):");
        int dia = scanner.nextInt();
        System.out.println("Entre como a hora (HH):");
        int hora = scanner.nextInt();
        System.out.println("Entre como o minuto (MM):");
        int minuto = scanner.nextInt();
        date.setYear(ano-1900);
        date.setMonth(mes-1);
        date.setDate(dia);
        date.setHours(hora);
        date.setMinutes(minuto);
        date.setSeconds(0);

        return date;
    }

    private static boolean isValid(String option, String... options) {
        for (String v : options) {
            if (v != null && v.equalsIgnoreCase(option)) {
                return true;
            }
        }
        return false;
    }
}
