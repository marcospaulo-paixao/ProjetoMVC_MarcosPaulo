package model_MarcosPaulo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import controller_MarcosPaulo.ExtratoController;
import model_MarcosPaulo.classes.ContaComum;
import model_MarcosPaulo.classes.Extrato;
import model_MarcosPaulo.interfaces.CRUDContaComum;
import model_MarcosPaulo.interfaces.CRUDExtrato;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ContaComumRepository implements CRUDContaComum {

    /*
      Atributos
     */
    private String nomeDoArquivo = "";
    private CRUDExtrato extratoDAO = null;


    /*
      Métodos
     */
    /**
     * @param nomeDoArquivo
     */
    public ContaComumRepository(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
        extratoDAO = new ExtratoController("db/extrato.txt");
    }

    /**
     * @return @throws Exception
     */
    @Override
    public List<ContaComum> findAll() throws Exception {
        try {
            List<ContaComum> list = new ArrayList<>();
            var fr = new FileReader(nomeDoArquivo);
            var br = new BufferedReader(fr);
            String linha = "";

            while ((linha = br.readLine()) != null) {
                var cm = new ContaComum();
                cm.setToString(linha);
                cm.setExtrato(extratoDAO.findByNumeroConta(cm.getNumero()));
                list.add(cm);
            }
            
            br.close();
            return list;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param numero
     * @return
     * @throws Exception
     */
    @Override
    public ContaComum findByNumero(int numero) throws Exception {
        try {
            for (ContaComum contaComum : findAll()) {
                if (contaComum.getNumero() == numero) {
                    return contaComum;
                }
            }          
            return null;
            //throw new Exception("Conta não encontrado!");
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param clienteId
     * @return
     * @throws Exception
     */
    @Override
    public ContaComum findByClienteId(int clienteId) throws Exception {
        try {
            ContaComum contCom = null;

            for (ContaComum contCom1 : findAll()) {
                if (contCom1.getClienteId() == clienteId) {
                    contCom = contCom1;
                }
            }
            if (contCom == null) {
                throw new Exception("Conta não encontrado!");
            }
            return contCom;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param conta
     * @throws Exception
     */
    @Override
    public void save(ContaComum conta) throws Exception {
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
     * @param idConta
     * @throws Exception
     */
    @Override
    public void delete(int idConta) throws Exception {
        try {
            List<ContaComum> list = findAll();
            var fw = new FileWriter(nomeDoArquivo);
            var bw = new BufferedWriter(fw);
            for (ContaComum contCom : list) {
                if (contCom.getNumero() != idConta) {
                    bw.write(contCom.toString() + "\n");
                }
            }
            extratoDAO.delete(idConta);
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param conta
     * @throws Exception
     */
    @Override
    public void update(ContaComum conta) throws Exception {
        try {
            List<ContaComum> list = findAll();
            var fw = new FileWriter(nomeDoArquivo);
            var bw = new BufferedWriter(fw);
            for (ContaComum contCom : list) {
                if (contCom.getNumero() != conta.getNumero()) {
                    bw.write(contCom.toString() + "\n");
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
