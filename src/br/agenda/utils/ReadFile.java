package br.agenda.utils;

import br.agenda.entidades.Banco;
import br.agenda.entidades.Contato;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Essa class ler um arquivo de texto, linha por linha com os dados em menoria,
 * o mesmo tenta criar um objeto agenda para cada linha lida.
 * 
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class ReadFile {

    private final Banco banco;
    private final WriteFile writefile;
    private static ReadFile readFile;
    private Contato contato;
    private ArrayList<Contato> contatos;
    
    /**
     * Garante que não podera ser criado um Objeto diretamente.
     * 
     * @param banco
     * @param writefile 
     */
    private ReadFile(Banco banco, WriteFile writefile) {
        this.banco = banco;
        this.writefile = writefile;
        this.contatos = new ArrayList<>();
        this.read();
    }
    
    /**
     * Cria um unico Objeto e garante que será criado apenas um objeto dessa classe.
     * Usando Design Patterns Singleton.
     * 
     * @param banco recebe um objeto banco
     * @param writefile recebe o objeto WriteFile
     * @return 
     */
    public static ReadFile getInstance(Banco banco, WriteFile writefile) {
        if (readFile == null) {
            readFile = new ReadFile(banco, writefile);
            return readFile;
        }
        return readFile;
    }
    
    /**
     * Responsavel por ler o arquivo.
     */
    private void read() {
        try (BufferedReader reader = Files.newBufferedReader(this.banco.getPath(), this.banco.getUtf8())) {
            Integer count = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (this.prepare(line) != null) {
                    contatos.add(count, this.prepare(line));
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error ao ler/encontra o arquivo banco de dados\n" + e.getMessage());
            System.out.println("Reconstruindo banco de dados!");
            System.out.println();
            writefile.create();
            this.read();
        }
    }
    
    /**
     * Responsavel por criar um objeto contato para cada linha que atenda
     * a condição de um objeto contato.
     * 
     * @param line rece a linha atual lida doa rquivo.
     * @return 
     */
    private Contato prepare(String line) {
        String array[] = line.split(";");
        if (array.length == 3) {
            this.contato = new Contato(array[0], array[1], array[2]);
        }

        return this.contato;
    }
    
    /**
     * retornar todos os contatos encontrados
     * 
     * @return 
     */
    public ArrayList<Contato> getContatos() {
        return this.contatos;
    }
    
    /**
     * insere um contato na lista
     * 
     * @param contatos 
     */
    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
}
