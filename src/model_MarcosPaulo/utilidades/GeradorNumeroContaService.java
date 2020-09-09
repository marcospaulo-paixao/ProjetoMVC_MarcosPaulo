/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_MarcosPaulo.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author marcos
 */
public class GeradorNumeroContaService {

    /**
     * #Atributos
     */
    private int numero = 0;
    private String nomeDoArquivo = "db/numeroConta.txt";
    private static GeradorNumeroContaService instancia;

    /**
     * #Métodos
     */
    /**
     * @throws IOException
     * @default @throws FileNotFoundException
     */
    private GeradorNumeroContaService() {

    }

    public static GeradorNumeroContaService getInstancia() throws IOException {
        if (instancia == null) {
            instancia = new GeradorNumeroContaService();
        }
        instancia.setID();
        return instancia;
    }

    public void setID() throws IOException {
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        numero = Integer.parseInt(linha);
        br.close();
    }

    /**
     * @return numero
     */
    public int getnumero() {
        return ++numero;
    }

    /**
     * @throws IOException
     */
    public void finalize() throws IOException {
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo, false);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = numero + "";
        bw.write(saida);
        //fecha o arquivo
        bw.close();
    }
}
