package com.dataEstructur.Game.juego;

import com.dataEstructur.Game.logicalArbol.Arbol;
import com.dataEstructur.Game.logicalArbol.Nodo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author elvis_agui
 */
public class JuegoLogical {

    private Arbol arbol;
    private boolean posError = false;
    private boolean duplicado = false;
    private final ValCarta valCarta = new ValCarta();
    
    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public boolean isError() {
        return posError;
    }

    public void setError(boolean error) {
        this.posError = error;
    }

    public boolean isDuplicado() {
        return duplicado;
    }

    public void setDuplicado(boolean duplicado) {
        this.duplicado = duplicado;
    }

    /**
     * Inicia el juego e inserta las cartas que vengan en el json de peticion
     * @param json 
     */
    public void startJuego(String json) {
        this.arbol = new Arbol();
        json = limpiadorJson(json);
        String[] cartas = json.split(",");
        for (int i = 0; i < cartas.length; i++) {
            String[] temp = cartas[i].split(":");
            int pos = 0;
            try {
                pos = Integer.parseInt(temp[0]);
            } catch (NumberFormatException e) {
            }
            if (pos == i) {
                insercionCarta(temp[1]);
            } else {
                posError = true;
            }

            if (arbol.isRepetido()) {
                duplicado = true;
            }

        }

    }

    /**
     * funcion encargada de insertar una unica carta
     * @param carta 
     */
    private void insercionCarta(String carta) {
        int valor = valCarta.valorNumCarta(carta);
        if (valor != -1) {
            arbol.insertar(valor);
            if (arbol.isRepetido()) {
                duplicado = true;
            }
            posError = false;
        } else {
            posError = true;

        }
    }

    /**
     * inserta la carta desde la peticion 
     * @param json
     * @return 
     */
    public int insertarCarta(String json) {
        json = limpiadorJson(json);
        String[] cartaInsert = json.split(":");
        if (cartaInsert[0].equals("insert")) {
            int valor = valCarta.valorNumCarta(cartaInsert[1]);
            if (valor != -1) {
                this.posError = false;
                this.arbol.insertar(valor);
                if (arbol.isRepetido()) {
                    return 406;
                } else {
                    return 200;
                }

            } else {
                posError = true;
                return 400;
            }

        } else {
            return 400;
        }

    }

    
    /**
     * elimina las cartas enviadas o si es la k tambien la eliminara
     * @param json
     * @return 
     */
    public int eliminarCarta(String json) {
        json = limpiadorJson(json);
        String[] cartaInicial = json.split(",");
        switch (cartaInicial.length) {
            case 2: {
                return eliminar2cartas(cartaInicial);
            }
            case 1: {
                return eliminacionK(cartaInicial);
            }
            default:
                return 400;
        }

    }
    
    /**
     * elimina 2 cartas si y solo si suman13
     * @param cartaInicial
     * @return 
     */
    private int eliminar2cartas(String[] cartaInicial){
        String[] carta2 = cartaInicial[0].split(":");
        String[] carta3 = cartaInicial[1].split(":");
        if (carta2[0].equals("delete_1") && carta3[0].equals("delete_2")) {
            if ((valCarta.valorRealdelaCarta(carta2[1]) + valCarta.valorRealdelaCarta(carta3[1])) == 13) {                Nodo nodo1 = arbol.buscarNodo(valCarta.valorNumCarta(carta2[1]), arbol.getRaiz());
            Nodo nodo2 = arbol.buscarNodo(valCarta.valorNumCarta(carta3[1]), arbol.getRaiz());
            if (nodo1 != null && nodo2 != null) {
                if (nodo1.getHijoDerecho() == null && nodo1.getHijoIzquierdo() == null) {
                    if (nodo2.getHijoDerecho() == null && nodo2.getHijoIzquierdo() == null) {
                        arbol.eliminarNodo(valCarta.valorNumCarta(carta2[1]));
                        arbol.eliminarNodo(valCarta.valorNumCarta(carta3[1]));
                        return 200;
                        } else {
                            return 409;
                            }
                } else {
                    return 409;
                }
            } else {
                return 404;
                }
        } else {
             return 406;
        }
        }else{
            return 400;
        }
        
    }

    /**
     * eliminar carta K
     * @param cartaInicial
     * @return 
     */
    public int eliminacionK(String[]  cartaInicial){
        String[] carta = cartaInicial[0].split(":");
        if (carta[0].equals("delete_1")) {
                int val1 = valCarta.valorRealdelaCarta(carta[1]);
                if (val1 == 13) {
                    Nodo nodo1 = arbol.buscarNodo(valCarta.valorNumCarta(carta[1]), arbol.getRaiz());
                    if (nodo1 != null) {
                        if (nodo1.getHijoDerecho() == null && nodo1.getHijoIzquierdo() == null) {
                            arbol.eliminarNodo(valCarta.valorNumCarta(carta[1]));
                            return 200;
                        } else {
                            return 409;
                        }
                    } else {
                        return 404;
                    }
                } else {
                    return 406;
                }
        }else{
            return 400;
        }
    }
    
    /**
     * obtiene un map de forma key:carta para ser usada en json de respuesta
     * @return 
     */
    public Map<String, String> getPostOrder() {
        HashMap<String, String> map = new HashMap<>();
        arbol.limpiarCartas();
        ArrayList<Integer> cartas = arbol.postOrden(arbol.getRaiz());
        for (int i = 0; i < cartas.size(); i++) {
            map.put(String.valueOf(i), valCarta.valCartaString(cartas.get(i)));

        }
        return map;
    }

    /**
     * se mapea las cartas con su key para ser usadas en el json de respuesta
     * @return 
     */
    public Map<String, String> getInOrder() {
        HashMap<String, String> map = new HashMap<>();
        arbol.limpiarCartas();
        ArrayList<Integer> cartas = arbol.inOrden(arbol.getRaiz());
        for (int i = 0; i < cartas.size(); i++) {
            map.put(String.valueOf(i), valCarta.valCartaString(cartas.get(i)));

        }
        return map;
    }

    /**
     * se mapea las cartas con su key para el json de resupuesta
     * @return 
     */
    public Map<String, String> getpreOrder() {
        HashMap<String, String> map = new HashMap<>();
        arbol.limpiarCartas();
        ArrayList<Integer> cartas = this.arbol.PreOrden(this.arbol.getRaiz());
        for (int i = 0; i < cartas.size(); i++) {
            map.put(String.valueOf(i), valCarta.valCartaString(cartas.get(i)));

        }
        return map;
    }

    
    /**
     * encargado de limpiar el json de los parentecis y volverlos a strin simple
     * @param json
     * @return 
     */
    public String limpiadorJson(String json) {
        String jsonlimp = json;
        jsonlimp = jsonlimp.replace("{", "");
        jsonlimp = jsonlimp.replace("}", "");
        jsonlimp = jsonlimp.replace(" ", "");
        jsonlimp = jsonlimp.replace("\"", "");
        jsonlimp = jsonlimp.replace("\n", "");
        return jsonlimp;
    }

    /**
     * obtiene los niveles del arbol y los mapea para la respuesta
     * @param nivel
     * @return 
     */
    public Map<String, String> getLevel(int nivel) {
        HashMap<String, String> map = new HashMap<>();
        if (nivel > 0) {
            arbol.limpiarCartas();
            ArrayList<Integer> cartas = arbol.obtenerNodoNivel(arbol.getRaiz(), nivel-1);
            for (int i = 0; i < cartas.size(); i++) {
                map.put(String.valueOf(i), valCarta.valCartaString(cartas.get(i)));
             }  
        }else{
            map.put("Status 400", "Naa mames hay que seguir con los criterio de nivel");
        }
        if (map.isEmpty()) {
            map.put("Status 400", "El nivel no existe");
        }
        
        return map;
    }
    
    public boolean getDuplicado() {
        return duplicado;
    }
    
}
