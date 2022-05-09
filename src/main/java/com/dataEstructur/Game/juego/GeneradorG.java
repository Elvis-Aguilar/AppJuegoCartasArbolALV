
package com.dataEstructur.Game.juego;

import com.dataEstructur.Game.logicalArbol.Nodo;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author elvis_agui
 */
public class GeneradorG {
    
     //grafica 
    public String obtenerCodigografica(Nodo raiz){
        String texto = "digraph G\n"
        +"{\n"
        +"      node[shape = circle]\n"
        +"      node[style = filled]\n"
        +"      node[fillcolor = \"#EEEEE\"]\n"
        +"      node[color = \"#EEEEE\"]\n"
        +"      edge[color = \"#31CEF0\"]\n";

        if (raiz != null) {
            texto += raiz.textoGrafica();
        }
        texto += "\n}";
        return texto;


    }



    public void guardarArchivo(String ruta ,String  contenido){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta);
            pw= new PrintWriter(fichero);
            pw.write(contenido);
            pw.close();
        } catch (Exception e) {
            //TODO: handle exception
            
        }finally{
            if (pw!=null) {
                pw.close();
            }
        }


    }


    public void dibujarGrafico(Nodo raiz){
        try {
            
            guardarArchivo("archivo.dot", obtenerCodigografica(raiz));
            ProcessBuilder proceso;
            proceso =  new ProcessBuilder("dot","-Tpng","-o","arbol.png","archivo.dot");
            proceso.redirectErrorStream(true);
            proceso.start();

        } catch (Exception e) {
            //TODO: handle exception
            
        }
    }
    
    
}
