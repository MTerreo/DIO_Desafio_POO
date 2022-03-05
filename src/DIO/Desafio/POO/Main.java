package DIO.Desafio.POO;

import DIO.Desafio.POO.Controller.CatalogoBootCamp;
import DIO.Desafio.POO.Domain.BootCamp;
import DIO.Desafio.POO.Domain.Curso;
import DIO.Desafio.POO.Domain.Dev;
import DIO.Desafio.POO.Domain.Mentoria;
import DIO.Desafio.POO.View.CatalogoBootCampView;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CatalogoBootCamp bootcampGold = new CatalogoBootCamp();
        bootcampGold.add(new BootCamp("Master BootCamp 01", "BootCamp para Devs"));
        bootcampGold.add(new BootCamp("Junior BootCamp 01", "BootCamp para iniciantes"));

        Curso curso1 = new Curso("Dominando IDEs Java", "Iniciando com IDEs e Java", 4);
        Curso curso2 = new Curso("Estruturas de Dados em Java", "Introdução a estruturas de dados", 2);
        Curso curso3 = new Curso("Estruturas de Árvores", "Estruturas de dados em Java", 4);
        Curso curso4 = new Curso("Trabalhando com Collections Java", "Collections em Java", 6);
        Curso curso5 = new Curso("Debugging Java", "Usando o debbug da IDE", 6);

        Mentoria mentoria1 = new Mentoria("Abstraindo um Bootcamp", "Usando Orientação a Objetos em Java",
                new Date(122, Calendar.MARCH,12,18,0));

        bootcampGold.getBootCamp("Junior BootCamp 01").getCursosBootCamp().add(0,curso1);
        bootcampGold.getBootCamp("Junior BootCamp 01").getCursosBootCamp().add(1,curso2);
        bootcampGold.getBootCamp("Junior BootCamp 01").getCursosBootCamp().add(2,curso5);

        bootcampGold.getBootCamp("Junior BootCamp 01").getMentoriasBootCamp().add(0,mentoria1);

        bootcampGold.getBootCamp("Master BootCamp 01").getCursosBootCamp().add(0,curso3);
        bootcampGold.getBootCamp("Master BootCamp 01").getCursosBootCamp().add(1,curso4);
        bootcampGold.getBootCamp("Master BootCamp 01").getCursosBootCamp().add(2,curso5);

        bootcampGold.getBootCamp("Master BootCamp 01").getMentoriasBootCamp().add(0,mentoria1);

        Dev aluno1 = new Dev("Pedro");
        Dev aluno2 = new Dev("Ana");
        bootcampGold.getBootCamp("Master BootCamp 01").getDevsInscritos().add(0,aluno1);
        bootcampGold.getBootCamp("Master BootCamp 01").getDevsInscritos().add(1,aluno2);

        CatalogoBootCampView catalogoBootCampView = new CatalogoBootCampView(bootcampGold);
        catalogoBootCampView.view();
    }
}
