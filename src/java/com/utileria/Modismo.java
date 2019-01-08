/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utileria;

/**
 *
 * @author rafaelm
 */
public class Modismo {

    private int idPalabra;
    private String palabra;
    private String definicion;
    private String region;

    public Modismo() {
    }

    public Modismo(int idPalabra, String palabra, String definicion, String region) {
        this.idPalabra = idPalabra;
        this.palabra = palabra;
        this.definicion = definicion;
        this.region = region;
    }

    public String getDefinicion() {
        return definicion;
    }

    public int getIdPalabra() {
        return idPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getRegion() {
        return region;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public void setIdPalabra(int idPalabra) {
        this.idPalabra = idPalabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setRegion(String region) {
        this.region = region;
    }



}
