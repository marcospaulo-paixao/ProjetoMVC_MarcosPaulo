package controller_MarcosPaulo;

import java.util.List;

import model_MarcosPaulo.classes.Cliente;
import model_MarcosPaulo.interfaces.CRUDCliente;
import model_MarcosPaulo.dao.ClienteRepository;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ClienteController implements CRUDCliente {

    /*
      Atributos
     */
    private CRUDCliente clienteDao = null;

    /*
      Métodos
     */

    /**
     * @param nomeDoArquivo
     */
    public ClienteController(String nomeDoArquivo) {
        this.clienteDao = new ClienteRepository(nomeDoArquivo);
    }

    /**
     * @return @throws Exception
     */
    @Override
    public List<Cliente> findAll() throws Exception {
        try {
            return this.clienteDao.findAll();
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Cliente findById(int id) throws Exception {
        try {
            return this.clienteDao.findById(id);
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param nome
     * @return
     * @throws Exception
     */
    @Override
    public List<Cliente> findAllByNome(String nome) throws Exception {
        try {
            return this.clienteDao.findAllByNome(nome);
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param nome
     * @return
     * @throws Exception
     */
    @Override
    public Cliente findByNome(String nome) throws Exception {
        try {
            return this.clienteDao.findByNome(nome);
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param email
     * @return
     * @throws Exception
     */
    @Override
    public List<Cliente> findByEmail(String email) throws Exception {
        try {
            return this.clienteDao.findByEmail(email);
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param cliente
     * @throws Exception
     */
    @Override
    public void save(Cliente cliente) throws Exception {
        try {
            this.clienteDao.save(cliente);
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(int id) throws Exception {
        try {
            this.clienteDao.delete(id);
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @param cliente
     * @throws Exception
     */
    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.clienteDao.update(cliente);
        } catch (Exception erro) {
            throw erro;
        }
    }

}
