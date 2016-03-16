package br.agenda.utils;

import br.agenda.entidades.Banco;
import br.agenda.entidades.Contato;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class resposavel por criar e/ou modificar um arquivo.
 * 
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class WriteFile {

    private final Banco banco;
    private final Calendar c = Calendar.getInstance();
    private static WriteFile writeFile;
    
    /**
     * Garante que não podera ser criado um Objeto diretamente.
     * 
     * @param banco 
     */
    private WriteFile(Banco banco) {
        this.banco = banco;
    }
    
    /**
     * Cria um unico Objeto e garante que será criado apenas um objeto dessa classe.
     * Usando Design Patterns Singleton.
     * 
     * @param banco
     * @return 
     */
    public static WriteFile getInstance(Banco banco) {
        if (writeFile == null) {
            writeFile = new WriteFile(banco);
            return writeFile;
        }
        return writeFile;
    }
    
    /**
     * Cria um arquivo caso não exista.
     * 
     * ! Precisa ser melhorado para interfaces grafica.
     */
    public void create() {
        if (!Files.exists(this.banco.getPath())) {

            try (BufferedWriter w = Files.newBufferedWriter(this.banco.getPath(), this.banco.getUtf8())) {
                w.write("#Sistema de Agenda v-1.0");
                w.newLine();
                w.write("#Arquivo de Banco Padrão.");
                w.newLine();
                w.write("#" + c.getTime());
                w.newLine();
            } catch (IOException ex) {
                Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("O banco de dados já existe dezeja reconstruilo?");
            System.out.print("Isso irá apagar todos os dados! tem certeza? Y/n : ");
            Scanner entrada = new Scanner(System.in);
            String op = entrada.nextLine();
            if (op.equals("y") || op.equals("Y") || op.equals("")) {
                try {
                    Files.delete(this.banco.getPath());
                    this.create();
                } catch (IOException ex) {
                    Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error ao criar o arquivo de configuração" + ex.getMessage());
                }
            }
        }
    }
    
    /**
     * Salva os contatos no arquivo.
     * este metodo recebe uma lista de contatos e escreve no arquivo.
     * 
     * @param dados lista de contatos.
     */
    public void salve(ArrayList<Contato> dados) {

        try (BufferedWriter w = Files.newBufferedWriter(this.banco.getPath(), this.banco.getUtf8())) {
            w.write("#Sistema de Agenda v-1.0");
            w.newLine();
            w.write("#Arquivo de Banco Padrão.");
            w.newLine();
            w.write("#" + c.getTime());
            w.newLine();

            for (Contato dado : dados) {
                w.write(dado.toString());
                w.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
