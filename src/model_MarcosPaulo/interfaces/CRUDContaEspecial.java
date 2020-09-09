package model_MarcosPaulo.interfaces;

import java.util.List;
import model_MarcosPaulo.classes.ContaEspecial;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public interface CRUDContaEspecial {

    /**
     * @return @throws Exception
     */
    List<ContaEspecial> findAll() throws Exception;

    /**
     * @param numero
     * @return @throws Exception
     */
    ContaEspecial findByNumero(int numero) throws Exception;

    /**
     * @param clienteId
     * @return @throws Exception
     */
    ContaEspecial findByClienteId(int clienteId) throws Exception;

    /**
     * @param conta
     * @throws Exception
     */
    void save(ContaEspecial conta) throws Exception;

    /**
     * @param idConta
     * @throws Exception
     */
    void delete(int idConta) throws Exception;

    /**
     * @param conta
     * @throws Exception
     */
    void update(ContaEspecial conta) throws Exception;
}
