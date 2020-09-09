package model_MarcosPaulo.dao;

import controller_MarcosPaulo.ExtratoController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model_MarcosPaulo.classes.ContaEspecial;
import model_MarcosPaulo.classes.Extrato;
import model_MarcosPaulo.interfaces.CRUDContaEspecial;
import model_MarcosPaulo.interfaces.CRUDExtrato;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ContaEspecialRepository implements CRUDContaEspecial {

    /*
      Atributos
     */
    private String nomeDoArquivo = "";
    private CRUDExtrato extratoDAO = null;

    /*
      Métodos
     */
    /**
     *
     * @param nomeDoArquivo
     */
    public ContaEspecialRepository(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
        extratoDAO = new ExtratoController("db/extrato.txt");
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<ContaEspecial> findAll() throws Exception {
        try {
            List<ContaEspecial> list = new ArrayList<>();
            var fr = new FileReader(nomeDoArquivo);
            var br = new BufferedReader(fr);
            String linha = "";

            while ((linha = br.readLine()) != null) {
                ContaEspecial ce = new ContaEspecial();
                ce.setToString(linha);
                ce.setExtrato(extratoDAO.findByNumeroConta(ce.getNumero()));
                list.add(ce);
            }

            br.close();
            return list;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param numero
     * @return
     * @throws Exception
     */
    @Override
    public ContaEspecial findByNumero(int numero) throws Exception {
        try {

            for (ContaEspecial contaEspecial : findAll()) {
                if (contaEspecial.getNumero() == numero) {
                    return contaEspecial;
                }
            }
            return null;
            //throw new Exception("Conta não encontrado!");
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param clienteId
     * @return
     * @throws Exception
     */
    @Override
    public ContaEspecial findByClienteId(int clienteId) throws Exception {
        try {

            for (ContaEspecial contEsp1 : findAll()) {
                if (contEsp1.getClienteId() == clienteId) {
                    return contEsp1;
                }
            }
            throw new Exception("Conta não encontrado!");            
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param conta
     * @throws Exception
     */
    @Override
    public void save(ContaEspecial conta) throws Exception {
        try {
            
            var fr = new FileWriter(nomeDoArquivo, true);
            var br = new BufferedWriter(fr);
            extratoDAO.save(new Extrato(conta.getNumero()));
            br.write(conta.toString() + "\n");
            br.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param idConta
     * @throws Exception
     */
    @Override
    public void delete(int idConta) throws Exception {
        try {
            List<ContaEspecial> list = findAll();
            var fw = new FileWriter(nomeDoArquivo);
            var bw = new BufferedWriter(fw);
            for (ContaEspecial contEsp : list) {
                if (contEsp.getNumero() != idConta) {
                    bw.write(contEsp.toString() + "\n");
                }
            }
            extratoDAO.delete(idConta);
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     *
     * @param conta
     * @throws Exception
     */
    @Override
    public void update(ContaEspecial conta) throws Exception {
        try {
            List<ContaEspecial> list = findAll();
            var fw = new FileWriter(nomeDoArquivo);
            var bw = new BufferedWriter(fw);
            for (ContaEspecial contEsp : list) {
                if (contEsp.getNumero() != conta.getNumero()) {
                    bw.write(contEsp.toString() + "\n");
                } else {
                    extratoDAO.update(conta.getExtrato());
                    bw.write(conta.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

}
