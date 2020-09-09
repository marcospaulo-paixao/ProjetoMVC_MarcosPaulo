package model_MarcosPaulo.utilidades;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import model_MarcosPaulo.classes.Conta;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class JLabelSaldoService {

    /*
      Atributos
     */
    private static JLabelSaldoService instance = null;
    private JLabel labelSaldo = null;
    private Conta conta = null;

    /*
      Métodos
     */
    /**
     * @default
     */
    private JLabelSaldoService() {
    }

    /**
     *
     * @param labelSaldo
     * @param conta
     * @return
     */
    public static JLabelSaldoService getInstance() {
        if (instance == null) {
            instance = new JLabelSaldoService();
        }
        return instance;
    }



    /**
     * 
     */
    public void updateLabelSaldo() {
    if(conta.getSaldo() < 0) labelSaldo.setBackground(Color.red);
    else labelSaldo.setBackground(Color.black);
     labelSaldo.setText("SALDO:...." + formatMoney(this.conta.getSaldo()) + "");
    }

    
    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }       
    
    private String formatMoney(double valorBigDecimal) {
        return new DecimalFormat("'R$ ' #,###,##0.00").format(valorBigDecimal);
    }

    /**
     * @param labelSaldo the labelSaldo to set
     */
    public void setLabelSaldo(JLabel labelSaldo) {
        this.labelSaldo = labelSaldo;
    }


}
