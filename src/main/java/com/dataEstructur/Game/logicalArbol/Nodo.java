package com.dataEstructur.Game.logicalArbol;

/**
 *
 * @author elvis_agui
 */
public class Nodo {

    private int dato;
    private int factorEquilibrio;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    public Nodo(int dato, int factorEquilibrio, Nodo hijoIzquierdo, Nodo hijoDerecho) {
        this.dato = dato;
        this.factorEquilibrio = factorEquilibrio;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    public Nodo() {
    }

    public Nodo(int dato) {
        this.dato = dato;
        this.factorEquilibrio = 0;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

}
