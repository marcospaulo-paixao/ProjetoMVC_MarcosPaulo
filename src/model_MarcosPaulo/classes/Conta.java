package model_MarcosPaulo.classes;

import java.text.DecimalFormat;
import model_MarcosPaulo.utilidades.TipoDeConta;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public abstract class Conta {

    /*
      Atributos
     */
    private int numero = 0;
    protected double saldo = 0.0;
    protected TipoDeConta tipoDeConta = null;
    private int clienteId = 0;
    private Extrato extrato = null;

    /*
      Métodos
     */
    /**
     * @param numero
     * @param clienteId
     */
    public Conta(int numero, int clienteId) {
        this.numero = numero;
        this.clienteId = clienteId;
        saldo = 0.0;
    }

    /**
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero
     * @return
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    /**
     * @return
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param valor
     * @throws Exception
     */
    public void depositar(double valor) throws Exception {
        if (valor < 2) {
            throw new Exception("Valor para depósito inválido");
        }
        this.extrato.setTransacao("DEPÓSITO:..................................................."+formatMoney(valor));
        this.saldo += valor;
    }

    /**
     * @param conta
     * @param valor
     * @throws Exception
     */
    public void transferir(Conta conta, double valor) throws Exception {
        if (valor < 0) throw new Exception("Valor inválido!");
        if (saldo < valor) throw new Exception("Saldo insuficiente!");
        this.extrato.setTransacao("TRANSFERENCIA:   "+"CONTA:..."+conta.getNumero()+" - VALOR:..." + formatMoney(valor));
        this.saldo -= valor;
        conta.depositar(valor);
    }

    /**
     *
     * @param toString
     */
    public void setToString(String toString) {
        String vet[] = toString.split(";");
        numero = Integer.parseInt(vet[0]);
        saldo = Double.parseDouble(vet[1]);
        tipoDeConta = TipoDeConta.valueOf(
                TipoDeConta.getChave(Integer.parseInt(vet[2])));
        clienteId = Integer.parseInt(vet[3]);
    }

    /**
     * @param valor
     * @return
     * @throws Exception
     */
    public void saque(double valor) throws Exception {
        if (saldo < valor) {
            throw new Exception("Saldo insuficiente!");
        }
        this.extrato.setTransacao("SAQUE:........................................................" + formatMoney(valor));
        saldo -= valor;        
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return numero + ";" + saldo + ";" + tipoDeConta.getValor() + ";" + clienteId;
    }

    /**
     * @return the extrato
     */
    public Extrato getExtrato() {
        return extrato;
    }

    /**
     * @param extrato the extrato to set
     */
    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }
    
        public String formatMoney(double valorBigDecimal) {
        return new DecimalFormat("'R$ ' #,###,##0.00").format(valorBigDecimal);
    }

}
