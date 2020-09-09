package controller_MarcosPaulo;

import model_MarcosPaulo.dao.ExtratoRepository;
import java.util.List;
import model_MarcosPaulo.classes.Extrato;
import model_MarcosPaulo.interfaces.CRUDExtrato;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ExtratoController implements CRUDExtrato {

    private CRUDExtrato extratoDAO = null;

    /**
     *
     * @param nomeDoArquivo
     */
    public ExtratoController(String nomeDoArquivo) {
        this.extratoDAO = new ExtratoRepository(nomeDoArquivo);
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<Extrato> findAll() throws Exception {
        try {
            return extratoDAO.findAll();
        } catch (Exception erro) {
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
            return extratoDAO.findByNumeroConta(numeroConta);
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
             extratoDAO.save(extrato);
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
           extratoDAO.update(extrato);
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
           extratoDAO.delete(numeroConta);
        } catch (Exception erro) {
            throw erro;
        }
    }

}
