package model_MarcosPaulo.classes;

import model_MarcosPaulo.utilidades.TipoDeConta;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ContaComum extends Conta {

    /*
      Métodos
     */
    /**
     * @default
     */
    public ContaComum() {
        super(0, 0);
    }

    /**
     * @param clienteId
     */
    public ContaComum(int clienteId) {
        super(0, clienteId);
        super.tipoDeConta = TipoDeConta.COMUM;
    }

    /**
     * @param conta
     */
    public ContaComum(ContaEspecial conta) {
        super(conta.getNumero() , conta.getClienteId());        
    }

}
