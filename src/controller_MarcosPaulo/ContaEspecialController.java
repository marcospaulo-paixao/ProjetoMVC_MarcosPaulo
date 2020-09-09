package controller_MarcosPaulo;

import model_MarcosPaulo.dao.ContaEspecialRepository;
import java.util.List;
import model_MarcosPaulo.classes.ContaEspecial;
import model_MarcosPaulo.interfaces.CRUDContaEspecial;
import model_MarcosPaulo.interfaces.CRUDExtrato;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ContaEspecialController implements CRUDContaEspecial {

    /*
      Atributos
     */
    private CRUDContaEspecial contaEspecialDAO = null;


    /*
      Métodos
     */
    /**
     *
     * @param nomeDoArquivo
     */
    public ContaEspecialController(String nomeDoArquivo) {
        this.contaEspecialDAO = new ContaEspecialRepository(nomeDoArquivo);

    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<ContaEspecial> findAll() throws Exception {
         try {
            return this.contaEspecialDAO.findAll();
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
            return this.contaEspecialDAO.findByNumero(numero);
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
            return this.contaEspecialDAO.findByClienteId(clienteId);
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
            this.contaEspecialDAO.save(conta);
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
            this.contaEspecialDAO.delete(idConta);
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
            this.contaEspecialDAO.update(conta);
        } catch (Exception erro) {
            throw erro;
        }
    }

}
