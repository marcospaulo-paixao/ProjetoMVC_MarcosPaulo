package model_MarcosPaulo.utilidades;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public enum TipoDeConta {

    /**
     * #Atributos
     */
    COMUM(1), ESPECIAL(2);

    int valor;

    /**
     * #Metodos
     */
    /**
     * @param valor
     */
    TipoDeConta(int valor) {
        this.valor = valor;
    }

    /**
     * @return valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return valor
     */
    public static String getChave(int valor) {
        return ((valor == 1) ? "COMUM" : "ESPECIAL");
    }

}
