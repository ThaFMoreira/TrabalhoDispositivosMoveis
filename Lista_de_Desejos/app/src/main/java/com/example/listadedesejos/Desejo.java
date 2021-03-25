package com.example.listadedesejos;

import java.io.Serializable;

public class Desejo implements Serializable {
    private int id;
    private String produto;
    private String categoria;
    private String lojas;
    private double precoMin;
    private double precomax;

    public Desejo(int id, String produto, String categoria, String lojas, double precoMin, double precomax) {
        this.id = id;
        this.produto = produto;
        this.categoria = categoria;
        this.lojas = lojas;
        this.precoMin = precoMin;
        this.precomax = precomax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLojas() {
        return lojas;
    }

    public void setLojas(String lojas) {
        this.lojas = lojas;
    }

    public double getPrecoMin() {
        return precoMin;
    }

    public void setPrecoMin(double precoMin) {
        this.precoMin = precoMin;
    }

    public double getPrecomax() {
        return precomax;
    }

    public void setPrecomax(double precomax) {
        this.precomax = precomax;
    }
}
