package br.agenda.entidades;

import java.util.Objects;

/**
 * Entidade Contato, prover um nome, email e tell.
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class Contato {
    private String nome;
    private String email;
    private String tell;
    
    /**
     * Contrutor vasio, garante que possa ser criado um objeto sem dados iniciais.
     */
    public Contato(){
        
    }
    
    /**
     * Construtor básico, permite criar um objeto com apenas um nome e email
     * @param nome
     * @param email 
     */
    public Contato(String nome, String email){
        super();
        this.nome = nome;
        this.email = email;
        this.tell = null;
    }
    
    /**
     * Construtor completo, criar um contato com todos os dados
     * @param nome
     * @param email
     * @param tell 
     */
    public Contato(String nome, String email, String tell){
        super();
        this.nome = nome;
        this.email = email;
        this.tell = tell;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tell, other.tell)) {
            return false;
        }
        return true;
    }
    
    /**
     * Sobrescrita do metodo toString, refatorado para meu objetivo.
     * @return 
     */
    @Override
    public String toString(){
        return this.getNome()+";"+this.getEmail()+";"+this.getTell();
    }
}
