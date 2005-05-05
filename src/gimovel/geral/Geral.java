package gimovel.geral;

import java.util.Currency;
import java.util.Locale;

/**
 * Funções gerais
 */
public class Geral {
    /**
     * Retorna o símbolo da moeda local
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
