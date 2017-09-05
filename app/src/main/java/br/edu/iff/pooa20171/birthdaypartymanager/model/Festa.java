package br.edu.iff.pooa20171.birthdaypartymanager.model;

import java.io.Serializable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Festa extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String descricao;
    private String tema;
    private String local;
    private String cidade;
    private String estado;
    private String data;
    private String horario;
    private String traje;


    public Festa() {

    }

    public Festa(int id, String descricao, String tema, String local, String cidade, String estado, String data, String horario, String traje) {
        this.setId(id);
        this.setDescricao(descricao);
        this.setTema(tema);
        this.setLocal(local);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setData(data);
        this.setHorario(horario);
        this.setTraje(traje);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTraje() {
        return traje;
    }

    public void setTraje(String traje) {
        this.traje = traje;
    }

}
