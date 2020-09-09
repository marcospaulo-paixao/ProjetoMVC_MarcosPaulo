package model_MarcosPaulo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model_MarcosPaulo.classes.Extrato;
import model_MarcosPaulo.interfaces.CRUDExtrato;


/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ExtratoRepository implements CRUDExtrato {

    private String nomeDoArquivo = "";

    public ExtratoRepository(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<Extrato> findAll() throws Exception {
        try {
            List<Extrato> list = new ArrayList<>();
            var fr = new FileReader(nomeDoArquivo);
            var br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                list.add(new Extrato(linha));
            }
            br.close();
            return list;
        } catch (IOException erro) {
            throw erro;
        }
    }

    /**
     *
     * @param numeroConta
     * @return
     * @throws Exception
     */
    @Override
    public Extrato findByNumeroConta(int numeroConta) throws Exception {
        try {
            for (Extrato extrato : findAll()) {
                if (extrato.getNumeroConta() == numeroConta) {
                    return extrato;
                }
            }
            throw new Exception("Extrato não encontrato");
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param extrato
     * @throws Exception
     */
    @Override
    public void save(Extrato extrato) throws Exception {
        try {
            var fw = new FileWriter(nomeDoArquivo, true);
            var bw = new BufferedWriter(fw);
            bw.write(extrato.toString() + "\n");
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param extrato
     * @throws Exception
     */
    @Override
    public void update(Extrato extrato) throws Exception {
        try {
            List<Extrato> list = findAll();
            var fw = new FileWriter(nomeDoArquivo);
            var bw = new BufferedWriter(fw);
            for (Extrato extrato1 : list) {
                if (extrato1.getNumeroConta() == extrato.getNumeroConta()) {
                    bw.write(extrato.toString() + "\n");
                } else {
                    bw.write(extrato1.toString() + "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param numeroConta
     * @throws Exception
     */
    @Override
    public void delete(int numeroConta) throws Exception {
        try {

            List<Extrato> list = findAll();
            var fw = new FileWriter(nomeDoArquivo);
            var bw = new BufferedWriter(fw);
            for (Extrato extrato : list) {
                if (extrato.getNumeroConta() != extrato.getNumeroConta()) {
                    bw.write(extrato.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

}
