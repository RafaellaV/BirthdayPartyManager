package br.edu.iff.pooa20171.birthdaypartymanager.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Convidado extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private String email;
    private String numAcompanhantes;


    public Convidado() {

    }

    public Convidado(int id, String nome, String email, String numAcompanhantes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numAcompanhantes = numAcompanhantes;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNumAcompanhantes() {
        return numAcompanhantes;
    }

    public void setNumAcompanhantes(String numAcompanhantes) {
        this.numAcompanhantes = numAcompanhantes;
    }

}

