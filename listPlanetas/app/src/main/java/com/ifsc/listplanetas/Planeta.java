package com.ifsc.listplanetas;

import android.graphics.Bitmap;

public class Planeta {

    private String nome;
    private Integer foto; //classe R

    public Planeta(String nome, Integer foto) {
        this.nome = nome;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
