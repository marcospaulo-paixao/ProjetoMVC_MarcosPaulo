package model_MarcosPaulo.classes;

import model_MarcosPaulo.utilidades.TipoDeConta;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ContaEspecial extends Conta {

    /*
      Atributos
     */
    private double limite = 0.0;

    /*
      Métodos
     */
    /**
     * @param clienteId
     * @param limite
     */
    public ContaEspecial( int clienteId, double limite) throws Exception {
        super(0, clienteId);
        super.tipoDeConta =TipoDeConta.ESPECIAL;
        validaLimite(limite);
        this.limite = limite;
    }
    
    /**
     * @default
     */
    public ContaEspecial() {
        super(0, 0);
        limite = 0.0;
    }
    
    /**
     * @param conta
     * @param limite
     */
    public ContaEspecial(ContaComum conta,double limite) throws Exception {
        super(conta.getNumero() , conta.getClienteId());
        validaLimite(limite);
        this.limite = limite;
    }
    /**
     * @param contaEspecial
     * @copy
     */
    public ContaEspecial(ContaEspecial contaEspecial) {
        super(contaEspecial.getNumero(),contaEspecial.getClienteId());
        limite = contaEspecial.limite;
    }

    /**
     * @return limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite
     */
    public void setLimite(double limite) throws Exception {
        validaLimite(limite);
        this.limite = limite;
    }

    @Override
    public void setToString(String toString) {
        super.setToString(toString);
        String vet[] = toString.split(";");
        limite = Double.parseDouble(vet[4]);
    }

    /**
     * @param valor
     * @return
     * @throws Exception
     */
    @Override
    public void saque(double valor) throws Exception {
        if((valor > (super.getSaldo() + this.limite))) throw new Exception("Saldo insuficiente");
        super.getExtrato().setTransacao("SAQUE:........................................................" + formatMoney(valor));
        super.saldo -= valor; 
    }
    /**
     * 
     * @param conta
     * @param valor
     * @throws Exception 
     */
    @Override
    public void transferir(Conta conta, double valor) throws Exception {
        if (valor < 0) throw new Exception("Valor inválido!");
        if((valor > (super.getSaldo() + this.limite))) throw new Exception("Saldo insuficiente");
        this.getExtrato().setTransacao("TRANSFERENCIA:   "+"CONTA:..."+conta.getNumero()+" - VALOR:..." + formatMoney(valor));
        this.saldo -= valor;
        conta.depositar(valor);
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ";" + limite;
    }
    public static void validaLimite(double limite)throws Exception{
        if(limite<=0)throw new Exception("Limite não pode ser menor ou igual a zero");
    }
}
