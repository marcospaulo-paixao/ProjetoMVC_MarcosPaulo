package model_MarcosPaulo.interfaces;

import java.util.List;

import model_MarcosPaulo.classes.ContaComum;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public interface CRUDContaComum {

    /**
     * @return @throws Exception
     */
    List<ContaComum> findAll() throws Exception;

    /**
     * @param numero
     * @return @throws Exception
     */
    ContaComum findByNumero(int numero) throws Exception;

    /**
     * @param clienteId
     * @return @throws Exception
     */
    ContaComum findByClienteId(int clienteId) throws Exception;

    /**
     * @param conta
     * @throws Exception
     */
    void save(ContaComum conta) throws Exception;

    /**
     * @param idConta
     * @throws Exception
     */
    void delete(int idConta) throws Exception;

    /**
     * @param conta
     * @throws Exception
     */
    void update(ContaComum conta) throws Exception;
}
