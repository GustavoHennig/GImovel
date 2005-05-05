package gimovel.geral;

import java.util.Currency;
import java.util.Locale;

/**
 * Fun��es gerais
 */
public class Geral {
    /**
     * Retorna o s�mbolo da moeda local
     */
    public static String SimboloMoedaLocal() {

        return Currency.getInstance(Locale.getDefault()).getSymbol();
    }

    public static String SimboloMoedaLocalEspFim() {
        return Currency.getInstance(Locale.getDefault()).getSymbol() + " ";
    }


    public Geral() {
    }
}
