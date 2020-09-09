package model_MarcosPaulo.interfaces;

import java.util.List;
import model_MarcosPaulo.classes.Extrato;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public interface CRUDExtrato {
    /**
     * 
     * @return
     * @throws Exception 
     */
    List<Extrato> findAll() throws Exception;
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    Extrato findByNumeroConta(int numeroConta) throws Exception;
    
    /**
     * 
     * @param extrato
     * @throws Exception 
     */
    void save(Extrato extrato) throws Exception;
    
    /**
     * 
     * @param ex
     * @throws Exception 
     */
    void update(Extrato extrato) throws Exception;

    /**
     * 
     * @param numeroConta
     * @throws Exception 
     */
    void delete(int numeroConta) throws Exception;
}
