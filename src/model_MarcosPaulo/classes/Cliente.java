package model_MarcosPaulo.classes;

import model_MarcosPaulo.utilidades.TipoDeConta;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class Cliente {

    /*
      Atributos
     */
    private int id = 0;
    private String nome = "";
    private String email = "";
    private int numeroConta = 0;
    private TipoDeConta tipoDeConta = null;

    /*
      Métodos
     */

    /**
     * @defautl
     */
    public Cliente() {
    }

    /**
     * @param cliente
     * @copy
     */
    public Cliente(Cliente cliente) {
        this.id = cliente.id;
        this.nome = cliente.nome;
        this.email = cliente.email;
        this.numeroConta = cliente.numeroConta;
        this.tipoDeConta = cliente.tipoDeConta;
    }

    /**
     * @param nome
     * @param email
     */
    public Cliente(String nome, String email) throws Exception {
        this.id = 0;
        verificaNome(nome);
        verificaEmail(email);
        this.nome = nome;
        this.email = email;
    }

    /**
     * @param toString
     */
    public Cliente(String toString) {
        String vet[] = toString.split(";");
        id = Integer.parseInt(vet[0]);
        nome = vet[1];
        email = vet[2];
        numeroConta = Integer.parseInt(vet[3]);
        tipoDeConta = TipoDeConta.valueOf(
                TipoDeConta.getChave(Integer.parseInt(vet[4])));
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) throws Exception {
        verificaNome(nome);
        this.nome = nome;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) throws Exception {
        verificaEmail(email);
        this.email = email;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return id + ";" + nome + ";" + email + ";" + numeroConta + ";" + tipoDeConta.getValor();
    }

    /**
     * @return the numeroConta
     */
    public int getNumeroConta() {
        return numeroConta;
    }

    /**
     * @param numeroConta the numeroConta to set
     */
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    /**
     * @return
     */
    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    /**
     * @param tipoDeConta
     */
    public void setTipoDeConta(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }
    
    /**
     * 
     * @param text
     * @throws Exception 
     */
    public static void verificaNome(String text)throws Exception{
        if(text.length() < 3)throw new Exception("Nome inválido");
    }
    /**
     * 
     * @param text
     * @throws Exception 
     */
    public static void verificaEmail(String text) throws Exception {
        boolean valida = true;
        if (!text.contains("@") || !text.contains(".com")) {
            valida = false;
        } else {
            char[] chars = new char[text.length()];

            for (int i = 0; i < text.length(); i++) {
                chars[i] = text.charAt(i);
            }

            for (int i = 0; i < chars.length && valida; i++) {
                if (chars[0] == '@') {
                    valida = false;
                } else {
                    if (chars[i] == '@' && chars[i + 1] == '.') {
                        valida = false;
                    }
                }
            }
        }
        if(valida == false)throw new Exception("Email inválido");
    }
}
