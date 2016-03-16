package br.agenda.entidades;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe reponsavel por prover nome, caminho e tipo de codificação do arquivo.
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class Banco {
    
    private final Path path;
    private final String fileName;
    private final String ds = (String) System.getProperties().get("file.separator");
    private final String currentPath = System.getProperty("user.dir");
    private final Charset utf8 = StandardCharsets.UTF_8;
    
    private static Banco bancoFile;
    
    /**
     * Garante que não podera ser criado um Objeto diretamente.
     * 
     * @param nome recebe o nome do banco de dados
     */
    private Banco(String nome) {
        this.fileName = nome;
        this.path = Paths.get(this.currentPath + this.ds + this.fileName);
    }
    
    /**
     * Cria um unico Objeto e garante que será criado apenas um objeto dessa classe.
     * Usando Design Patterns Singleton.
     * 
     * @param nome recebe o nome do banco de dados
     * @return Um unico objeto dessa classe.
     */
    public static Banco getInstance(String nome){
        if(bancoFile == null){
            bancoFile = new Banco(nome);
            return bancoFile;
        }
        return bancoFile;
    }
    
    /**
     * Retorna caminho completo com nome do arquivo.
     * @return 
     */
    public Path getPath() {
        return path;
    }
    
    /**
     * Retorna nome do arquivo.
     * @return 
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * Retornar tipo de separador de diretórios. ex: Windows \ Linux /
     * @return 
     */
    public String getDs() {
        return ds;
    }
    
    /**
     * Retornar o diretórios onde o arquivo se encontra.
     * @return 
     */
    public String getCurrentPath() {
        return currentPath;
    }
    
    /**
     * Retrona tipo de codificação charset UTF-8
     * @return 
     */
    public Charset getUtf8() {
        return utf8;
    }
}
