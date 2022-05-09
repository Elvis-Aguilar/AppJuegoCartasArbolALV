package com.dataEstructur.Game.controlador;

import com.dataEstructur.Game.juego.GeneradorG;
import com.dataEstructur.Game.juego.JuegoLogical;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elvis_agui
 */
@RestController
@RequestMapping("Game")
public class Controlador {

    private JuegoLogical juego;

    @PostMapping(path = "/start")
    public ResponseEntity<String> startJuego(@RequestBody String json) {
        juego = new JuegoLogical();
        juego.startJuego(json);
        if (!juego.isError() && !juego.getDuplicado()) {
            return ResponseEntity.status(HttpStatus.OK).body("Exelente!! el juego a iniciado correctamente sigue jugando :D");
        } else if (juego.isError()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ups! tu json de entrada no es valida, verifica los indices");
        } else if (juego.getDuplicado()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ups! una de las cartas esta duplicada verifica las cartas");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ESTATUS 400 ALGUN ERROR AL INICIAR EL JUEGO! NO ME BAJEN PUNTOS :v");
        }

    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addCarta(@RequestBody String json) {
        if (this.juego != null) {
            int statusRespuesta = juego.insertarCarta(json);
            switch (statusRespuesta) {
                case 200:
                    return ResponseEntity.status(HttpStatus.OK).body("Bien! la carta ha sido insertada correctamente :D");
                case 406:
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Upss!! Error La carta esta duplicada");
                case 400:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ho! esta Carta es invalida");
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ESTATUS 400 ALGUN ERROR AL INSERTAR LA CARTA");
            }

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DEBES INICIAR AL JUEGO, GAME/START :v");
        }

    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deletCartas(@RequestBody String json) {
        if (this.juego != null) {
            int respuesta = juego.eliminarCarta(json);
            switch (respuesta) {
                case 200:
                    return ResponseEntity.status(HttpStatus.OK).body("Bien echo las cartas han sido eliminadas correctamente");
                case 409:
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("La carta no se puede eliminar ya que cuenta con hijos");
                case 404:
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartas no existen en el arbol");
                case 406:
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("El todal de las cartas a eliminar no sumas 13");
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mala sintaxis seguir la del enunciado :V");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DEBES INICIAR AL JUEGO, GAME/START :v");
        }

    }

    @GetMapping(path = "/avltree")
    public Map<String, String> Orden(@RequestParam String transversal) {
        if (this.juego != null) {
            switch (transversal) {
                case "preOrder":
                    return juego.getpreOrder();
                case "inOrder":
                    return juego.getInOrder();
                case "postOrder":
                    return juego.getPostOrder();
                default:
                    return juego.getInOrder();
            }
        } else {
            return new HashMap<>(); 
        }

    }

    @GetMapping(path = "/get-level")
    public Map<String, String> getLevel(@RequestParam int level) {
        return juego.getLevel(level);

    }
    
    @GetMapping(path = "/status-avltree")
    public void nivel(){
        GeneradorG generador = new GeneradorG();
        generador.dibujarGrafico(this.juego.getArbol().getRaiz());
    }

}
