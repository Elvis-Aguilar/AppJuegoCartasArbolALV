package com.dataEstructur.Game.logicalArbol;

import java.util.ArrayList;

/**
 *
 * @author elvis_agui
 */
public class Arbol {

    private Nodo raiz;
    private boolean repetido = false;
    private ArrayList<Integer> cartasTem = new ArrayList<>();

   
    public Arbol() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public boolean isRepetido() {
        return repetido;
    }

    public void setRepetido(boolean repetido) {
        this.repetido = repetido;
    }

    
    /**
     * eliminar nodo del arbol con un dato de parametro
     * @param dato 
     */
    public void eliminarNodo(int dato) {
        Nodo auxiliar = raiz;
        Nodo raizTem = raiz;
        boolean esHijoizq = true;

        while (auxiliar.getDato() != dato) {
            raizTem = auxiliar;
            if (dato < auxiliar.getDato()) {
                esHijoizq = true;
                auxiliar = auxiliar.getHijoIzquierdo();
            } else {
                esHijoizq = false;
                auxiliar = auxiliar.getHijoDerecho();
            }
            if (auxiliar == null) {
                break;
            }
        }
        
        if (auxiliar.getHijoIzquierdo() == null && auxiliar.getHijoDerecho() == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoizq) {
                raizTem.setHijoIzquierdo(null);
            } else {
                raizTem.setHijoDerecho(null);
            }
        }

    }

    
    /**
     * funcion que obtiene el factor de equilibrio del nodo 
     * @param nodo
     * @return 
     */
    public int getFactorEquilibrio(Nodo nodo) {
        if (nodo == null) {
            return -1;
        } else {
            return nodo.getFactorEquilibrio();
        }
    }

    /**
     * ratacion simple a la dercha
     * @param nodo
     * @return 
     */
    public Nodo RotSimpleDerecha(Nodo nodo) {
        Nodo auxiliar = nodo.getHijoIzquierdo();
        nodo.setHijoIzquierdo(auxiliar.getHijoDerecho());
        auxiliar.setHijoDerecho(nodo);
        int factorEquilibrio1 = getFactorEquilibrio(nodo.getHijoIzquierdo());
        int factorEquilibrio2 = getFactorEquilibrio(nodo.getHijoDerecho());
        nodo.setFactorEquilibrio(Math.max(factorEquilibrio1, factorEquilibrio2) + 1);
        auxiliar.setFactorEquilibrio(Math.max(getFactorEquilibrio(auxiliar.getHijoIzquierdo()), getFactorEquilibrio(auxiliar.getHijoDerecho())));
        return auxiliar;
    }

    /**
     * implementacion de la rotacion simple a la izquierda 
     * @param nodo
     * @return 
     */
    public Nodo rotSimpleIzquierda(Nodo nodo) {
        Nodo auxiliar = nodo.getHijoDerecho();
        nodo.setHijoDerecho(auxiliar.getHijoIzquierdo());
        auxiliar.setHijoIzquierdo(nodo);
        int factorEquilibrio1 = getFactorEquilibrio(nodo.getHijoIzquierdo());
        int factorEquilibrio2 = getFactorEquilibrio(nodo.getHijoDerecho());
        nodo.setFactorEquilibrio(Math.max(factorEquilibrio1, factorEquilibrio2) + 1);
        auxiliar.setFactorEquilibrio(Math.max(getFactorEquilibrio(auxiliar.getHijoIzquierdo()), getFactorEquilibrio(auxiliar.getHijoDerecho())) + 1);
        return auxiliar;
    }

    /**
     * rotacion doble izquierda
     * @param nodo
     * @return 
     */
    public Nodo rotacionDobleIzquierda(Nodo nodo) {
        Nodo auxiliar;
        nodo.setHijoIzquierdo(rotSimpleIzquierda(nodo.getHijoIzquierdo()));
        auxiliar = RotSimpleDerecha(nodo);
        return auxiliar;
    }

    /**
     * rotacion doble dercha
     * @param nodo
     * @return 
     */
    public Nodo rotacionDobleDerecha(Nodo nodo) {
        Nodo auxiliar;
        nodo.setHijoDerecho(RotSimpleDerecha(nodo.getHijoDerecho()));
        auxiliar = rotSimpleIzquierda(nodo);
        return auxiliar;
    }

    /**
     * inserta un nuevo nodo al arbol usando recursividad para indicar el subarbol
     * @param nuevo
     * @param arbolTemporal
     * @return 
     */
    public Nodo insertarAlArbol(Nodo nuevo, Nodo arbolTemporal) {
        repetido = false;
        Nodo raizaTemp = arbolTemporal;
        if (nuevo.getDato() < arbolTemporal.getDato()) {
            if (arbolTemporal.getHijoIzquierdo() == null) {
                arbolTemporal.setHijoIzquierdo(nuevo);
            } else {
                arbolTemporal.setHijoIzquierdo(insertarAlArbol(nuevo, arbolTemporal.getHijoIzquierdo()));
                if ((getFactorEquilibrio(arbolTemporal.getHijoIzquierdo()) - getFactorEquilibrio(arbolTemporal.getHijoDerecho())) == 2) {
                    if (nuevo.getDato() < arbolTemporal.getHijoIzquierdo().getDato()) {
                        raizaTemp = RotSimpleDerecha(arbolTemporal);
                    } else {
                        raizaTemp = rotacionDobleIzquierda(arbolTemporal);
                    }
                }
            }
        } else if (nuevo.getDato() > arbolTemporal.getDato()) {
            if (arbolTemporal.getHijoDerecho() == null) {
                arbolTemporal.setHijoDerecho(nuevo);
            } else {
                arbolTemporal.setHijoDerecho(insertarAlArbol(nuevo, arbolTemporal.getHijoDerecho()));
                if ((getFactorEquilibrio(arbolTemporal.getHijoDerecho()) - getFactorEquilibrio(arbolTemporal.getHijoIzquierdo())) == 2) {
                    if (nuevo.getDato() > arbolTemporal.getHijoDerecho().getDato()) {
                        raizaTemp = rotSimpleIzquierda(arbolTemporal);
                    } else {
                        raizaTemp = rotacionDobleDerecha(arbolTemporal);
                    }
                }
            }
        } else {
            repetido = true;
        }

        if (arbolTemporal.getHijoIzquierdo() == null && arbolTemporal.getHijoDerecho() != null) {
            arbolTemporal.setFactorEquilibrio(arbolTemporal.getHijoDerecho().getFactorEquilibrio()+ 1);
        } else if (arbolTemporal.getHijoDerecho() == null && arbolTemporal.getHijoIzquierdo() != null) {
            arbolTemporal.setFactorEquilibrio(arbolTemporal.getHijoIzquierdo().getFactorEquilibrio() + 1);
        } else {
            arbolTemporal.setFactorEquilibrio(Math.max(getFactorEquilibrio(arbolTemporal.getHijoIzquierdo()), getFactorEquilibrio(arbolTemporal.getHijoDerecho())) + 1);

        }

        return raizaTemp;
    }
    
    
    

    /**
     * inserta un nodo al arbol, en base a un dato
     * @param dato 
     */
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAlArbol(nuevo, raiz);
        }

    }
    
    /**
     * metodo encargado de buscar el metodo donde se encuentra el dato y nodo
     * retornando si es nodo padre o nodo hijo
     * @param dato
     * @param nodo
     * @return 
     */
    public Nodo buscarNodo(int dato, Nodo nodo) {
        if (nodo != null) {
            if (raiz == null) {
                return null;
            } else if (null != nodo && nodo.getDato() == dato) {
                return nodo;
            } else if (nodo != null && nodo.getDato() < dato) {
                return buscarNodo(dato, nodo.getHijoDerecho());
            } else {
                return buscarNodo(dato, nodo.getHijoIzquierdo());
            }
        } else {
            return null;
        }

    }


    /**
     * agrega a la lista los valores del nivel solicitado
     * @param nodo
     * @param nivel
     * @return 
     */
    public ArrayList<Integer> obtenerNodoNivel(Nodo nodo, int nivel) {
        if (nodo != null) {
            if (nivel == 0) {
                cartasTem.add(nodo.getDato());
                System.out.println(nodo.getDato());
            }
            obtenerNodoNivel(nodo.getHijoIzquierdo(), nivel - 1);
            obtenerNodoNivel(nodo.getHijoDerecho(), nivel - 1);
        }

        return cartasTem;
    }

    public void limpiarCartas() {
        this.cartasTem = new ArrayList<>();
        this.cartasTem.clear();
    }

    /**
     * realiza un recorido en inorden (iquierdo raiz derecho)
     * @param nodo
     * @return 
     */
    public ArrayList<Integer> inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.getHijoIzquierdo());
            cartasTem.add(nodo.getDato());
            inOrden(nodo.getHijoDerecho());
        }
        return cartasTem;
    }

    /**
     * raiz izquierdo derecho
     * @param nodo
     * @return 
     */
    public ArrayList<Integer> PreOrden(Nodo nodo) {
        if (nodo != null) {
            cartasTem.add(nodo.getDato());
            PreOrden(nodo.getHijoIzquierdo());
            PreOrden(nodo.getHijoDerecho());
        }

        return cartasTem;
    }

    /**
     * izquirdo derecho raiz
     * @param nodo
     * @return 
     */
    public ArrayList<Integer> postOrden(Nodo nodo) {
        String json = "";
        if (nodo != null) {
            postOrden(nodo.getHijoIzquierdo());
            postOrden(nodo.getHijoDerecho());
            cartasTem.add(nodo.getDato());
            json += nodo.getDato() + ", ";
        }

        return cartasTem;
    }

    public ArrayList<Integer> getCartas() {
        return cartasTem;
    }

    public void setCartas(ArrayList<Integer> cartas) {
        this.cartasTem = cartas;
    }

    
    
}
