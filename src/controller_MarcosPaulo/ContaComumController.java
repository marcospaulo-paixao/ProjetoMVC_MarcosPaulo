package controller_MarcosPaulo;

import java.util.List;
import model_MarcosPaulo.dao.ContaComumRepository;
import model_MarcosPaulo.classes.ContaComum;
import model_MarcosPaulo.interfaces.CRUDContaComum;
import model_MarcosPaulo.interfaces.CRUDExtrato;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ContaComumController implements CRUDContaComum {

    /*
      Atributos
     */
    private CRUDContaComum contaComumDAO = null;
    

    /*
      Métodos
     */
    /**
     *
     * @param nomeDoArquivo
     */
    public ContaComumController(String nomeDoArquivo) {
        this.contaComumDAO = new ContaComumRepository(nomeDoArquivo);        
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<ContaComum> findAll() throws Exception {
        try {
            return this.contaComumDAO.findAll();
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
    public ContaComum findByNumero(int numero) throws Exception {
        try {
            return this.contaComumDAO.findByNumero(numero);
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
    public ContaComum findByClienteId(int clienteId) throws Exception {
        try {
            return this.contaComumDAO.findByClienteId(clienteId);
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
    public void save(ContaComum conta) throws Exception {
        try {
            this.contaComumDAO.save(conta);
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
            this.contaComumDAO.delete(idConta);
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
    public void update(ContaComum conta) throws Exception {
        try {
            this.contaComumDAO.update(conta);
        } catch (Exception erro) {
            throw erro;
        }
    }    
}
