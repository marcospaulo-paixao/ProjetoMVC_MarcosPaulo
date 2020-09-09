package model_MarcosPaulo.interfaces;

import java.util.List;

import model_MarcosPaulo.classes.Cliente;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public interface CRUDCliente {

    /**
     * @return
     * @throws java.lang.Exception
     */
    List<Cliente> findAll() throws Exception;

    /**
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    Cliente findById(int id) throws Exception;

    /**
     * @param nome
     * @return
     * @throws java.lang.Exception
     */
    List<Cliente> findAllByNome(String nome) throws Exception;

    /**
     * @param nome
     * @return
     * @throws java.lang.Exception
     */
    Cliente findByNome(String nome) throws Exception;

    /**
     * @param email
     * @return
     * @throws java.lang.Exception
     */
    List<Cliente> findByEmail(String email) throws Exception;

    /**
     * @param cliente
     * @throws java.lang.Exception
     */
    void save(Cliente cliente) throws Exception;

    /**
     * @param id
     * @throws java.lang.Exception
     */
    void delete(int id) throws Exception;

    /**
     * @param cliente
     * @throws java.lang.Exception
     */
    void update(Cliente cliente) throws Exception;
}
