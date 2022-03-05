package DIO.Desafio.POO.Domain;

import java.time.LocalDate;
import java.util.Date;

public class Mentoria extends Conteudo{
    private Date data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria(String titulo, String descricao, Date data) {
        super(titulo, descricao);
        this.data = data;
    }

    public Date getData() { return data; }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", XP=" + calcularXp() +
                ", data=" + data +
                '}';
    }
}
