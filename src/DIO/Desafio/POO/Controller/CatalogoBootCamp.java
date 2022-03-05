package DIO.Desafio.POO.Controller;

import DIO.Desafio.POO.Domain.BootCamp;

import java.util.*;

public class CatalogoBootCamp {
    private List<BootCamp> bootCamps = new ArrayList<>();

    public void add(BootCamp bootCamp) {
        if (bootCamp == null) throw  new IllegalArgumentException();
        bootCamps.add(bootCamp);
    }

    public void del(String nomeBootCamp) {
        BootCamp bootCamp = getBootCamp(nomeBootCamp);
        if (bootCamp != null) {
            bootCamps.remove(bootCamp);
        }
    }

    public BootCamp getBootCamp(String nomeBootCamp) {
        if (nomeBootCamp == null || nomeBootCamp.isBlank()) throw new IllegalArgumentException();
        for (BootCamp bootCamp : bootCamps){
            if (bootCamp.getNomeBootCamp().equalsIgnoreCase(nomeBootCamp)) {
                return  bootCamp;
            }
        }
        return null;
    }

    public BootCamp getDescricao(String descricaoBootCamp) {
        if (descricaoBootCamp == null || descricaoBootCamp.isBlank()) throw new IllegalArgumentException();
        for (BootCamp bootCamp : bootCamps){
            if (bootCamp.getNomeBootCamp().equalsIgnoreCase(descricaoBootCamp)) {
                return  bootCamp;
            }
        }
        return null;
    }

    public BootCamp getBootCamp(int numeroBootCamp) {
        if (numeroBootCamp <= 0 || numeroBootCamp > bootCamps.size()) throw new IllegalArgumentException();
        return bootCamps.get(numeroBootCamp-1);
    }

    public int getTotal() { return bootCamps.size(); }
}
