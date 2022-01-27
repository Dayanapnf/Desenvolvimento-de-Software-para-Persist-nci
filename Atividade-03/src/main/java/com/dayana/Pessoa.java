package com.dayana;

public class Pessoa implements java.io.Serializable {

    private int id;
    private String nome;
    private String email;
    private int fone;

    public Pessoa() {
        super();
    }

    public Pessoa(int id, String nome, String email, int fone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    public int getFone() {
        return fone;
    }

    public int getId() {
        return id;
    }

    public String getNome(String nome) {
        return nome;
    }

    public String getEmail(String email) {
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa Id = " + id + "\nNome = " + nome + "\nEmail = " + email + "\nTelefone = " + fone;
    }

}
