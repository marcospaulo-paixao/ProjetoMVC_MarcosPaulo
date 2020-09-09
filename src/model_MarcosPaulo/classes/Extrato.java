/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_MarcosPaulo.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author marcos
 */
public class Extrato {

    private int numeroConta = 0;
    private List<String> transacoes = null;

    public Extrato(int numeroConta) {
        this.numeroConta = numeroConta;
        transacoes = new ArrayList<>();
    }

    public Extrato(String linha) {
        String vet1[] = linha.split(";");
        transacoes = new ArrayList<>();
        for (int i = 0; i < vet1.length; i++) {
            if (i == 0) {
                numeroConta = Integer.parseInt(vet1[i]);
            } else {
                transacoes.add(vet1[i]);
            }
        }


    }

    /**
     * @return the transacoes
     */
    public String getTransacoes() {
        String saida = "";
        for (String transacao : transacoes) {
            saida += transacao + "\n";   
        }
        return saida;
    }

    /**
     * @param transacao the transacoes to set
     */
    public void setTransacao(String transacao) {
        this.transacoes.add(dataAtual() + " - " + transacao);
    }

    @Override
    public String toString() {
        String saida = numeroConta + ";";
        int i = 0;
        for (String transacao : transacoes) {
            if (i == 0) {
                saida += transacao;
            } else {
                saida += ";" + transacao;
            }
            i++;
        }
        return saida;
    }

    public String dataAtual() {
        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(hoje);
    }

    public int getNumeroConta() {
        return numeroConta;
    }
}
