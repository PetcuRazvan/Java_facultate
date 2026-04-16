package functional;

import model.Comanda;

@FunctionalInterface
public interface FiltruComanda {

    boolean accepta(Comanda e);
}
