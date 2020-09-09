package model_MarcosPaulo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import model_MarcosPaulo.classes.Cliente;
import model_MarcosPaulo.interfaces.CRUDCliente;

/**
 * PROJETO MVC
 *
 * @author Marcos Paulo Paixão { 03/08/20 }
 */
public class ClienteRepository implements CRUDCliente {

    /*
      Atributos
     */
    private String nomeDoArquivo = "";

    /*
      Métodos
     */
    /**
     * @param nomeDoArquivo
     */
    public ClienteRepository(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    /**
     * @return @throws Exception
     */
    @Override
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> list = new ArrayList<>();
            var fr = new FileReader(nomeDoArquivo);
            var br = new BufferedReader(fr);
            String linha = "";

            while ((linha = br.readLine()) != null) {
                list.add(new Cliente(linha));
            }

            br.close();
            return list;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @return @throws Exception
     */
    @Override
    public Cliente findById(int id) throws Exception {
        try {
            Cliente cli = null;

            for (Cliente cliente : findAll()) {
                if (cliente.getId() == id) {
                    cli = cliente;
                }
            }
            if (cli == null) {
                throw new Exception("Cliente não encontrado!");
            }
            return cli;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @return @throws Exception
     */
    @Override
    public List<Cliente> findAllByNome(String nome) throws Exception {
        try {
            List<Cliente> list = new ArrayList<>();
            for (Cliente cliente : findAll()) {
                if ((cliente.getNome().toLowerCase()).contains((nome.toLowerCase()))) {
                    list.add(cliente);
                }
            }
            if (list.isEmpty()) {
                throw new Exception("Cliente não encontrado, verifique o nome.");
            }
            return list;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @return @throws Exception
     */
    @Override
    public Cliente findByNome(String nome) throws Exception {
        try {
            Cliente cliente = null;
            for (Cliente c : findAll()) {
                if ((c.getNome().toLowerCase()).equals(nome.toLowerCase())) {
                    cliente = c;
                }
            }
            if (cliente == null) {
                throw new Exception("Cliente não encontrado, verifique o nome.");
            }
            return cliente;
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @return @throws Exception
     */
    @Override
    public List<Cliente> findByEmail(String email) throws Exception {
        try {
            List<Cliente> list = new ArrayList<>();
            for (Cliente cliente : findAll()) {
                if ((cliente.getEmail().toLowerCase()).contains((email.toLowerCase()))) {
                    list.add(cliente);
                }
            }
            if (list.isEmpty()) {
                throw new Exception("Cliente não encontrado, verifique o nome.");
            }
            return list;
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
            var fr = new FileWriter(nomeDoArquivo, true);
            var br = new BufferedWriter(fr);
            br.write(cliente.toString() + "\n");
            br.close();
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
            List<Cliente> list = findAll();
            var fr = new FileWriter(nomeDoArquivo);
            var br = new BufferedWriter(fr);
            for (Cliente cliente : list) {
                if (cliente.getId() != id) {
                    br.write(cliente.toString() + "\n");
                }
            }
            br.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    /**
     * @throws Exception
     */
    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            List<Cliente> list = findAll();
            var fr = new FileWriter(nomeDoArquivo);
            var br = new BufferedWriter(fr);
            for (Cliente cli : list) {
                if (cli.getId() != cliente.getId()) {
                    br.write(cli.toString() + "\n");
                } else {
                    br.write(cliente.toString() + "\n");
                }
            }
            br.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

}
