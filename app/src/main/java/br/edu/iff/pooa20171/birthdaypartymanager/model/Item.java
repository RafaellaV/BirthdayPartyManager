package br.edu.iff.pooa20171.birthdaypartymanager.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Item extends RealmObject implements Serializable {

        @PrimaryKey
        private int id;
        private String nome;
        private String quantidade;
        private String valor;


    public Item() {

    }

    public Item(int id, String nome, String quantidade, String valor) {
        this.setId(id);
        this.setNome(nome);
        this.setQuantidade(quantidade);
        this.setValor(valor);


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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
