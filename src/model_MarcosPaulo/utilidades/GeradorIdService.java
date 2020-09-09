/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_MarcosPaulo.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author marcos
 */
public class GeradorIdService {

    /**
     * #Atributos
     */
    private int id = 0;
    private String nomeDoArquivo = "db/idGerado.txt";
    private static GeradorIdService instancia;

    /**
     * #Métodos
     */
    /**
     * @default @throws FileNotFoundException
     * @throws IOException
     */
    private GeradorIdService()  {
        
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static GeradorIdService getInstancia() throws IOException {
        if(instancia == null){
            instancia = new GeradorIdService();
        }
        instancia.setId();
        return instancia;
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void setId() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        id = Integer.parseInt(linha);
        br.close();
    }
    /**
     *
     * @return id
     */
    public int getID() {
        return ++id;
    }

    /**
     *
     * @throws IOException
     */
    public void finalize() throws IOException {
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo, false);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = id + "";
        bw.write(saida);
        //fecha o arquivo
        bw.close();
    }
}
