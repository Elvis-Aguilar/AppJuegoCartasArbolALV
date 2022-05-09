package com.dataEstructur.Game.juego;

/**
 *
 * @author elvis_agui
 */
public class ValCarta {

    /**
     * funcion para encontrar el valor numerico de la carta segun la cadena que
     * reciva
     *
     * @param carta
     * @return
     */
    public int valorNumCarta(String carta) {
        int valor = 0;
        switch (carta) {
            case "A♣":
                valor = 1;
                break;
            case "2♣":
                valor = 2;
                break;

            case "3♣":
                valor = 3;
                break;

            case "4♣":
                valor = 4;
                break;

            case "5♣":
                valor = 5;
                break;

            case "6♣":
                valor = 6;
                break;

            case "7♣":
                valor = 7;
                break;

            case "8♣":
                valor = 8;
                break;

            case "9♣":
                valor = 9;
                break;

            case "10♣":
                valor = 10;
                break;

            case "J♣":
                valor = 11;
                break;

            case "Q♣":
                valor = 12;
                break;

            case "K♣":
                valor = 13;
                break;
            case "A♦":
                valor = 21;
                break;
            case "2♦":
                valor = 22;
                break;

            case "3♦":
                valor = 23;
                break;

            case "4♦":
                valor = 24;
                break;

            case "5♦":
                valor = 25;
                break;

            case "6♦":
                valor = 26;
                break;

            case "7♦":
                valor = 27;
                break;

            case "8♦":
                valor = 28;
                break;

            case "9♦":
                valor = 29;
                break;

            case "10♦":
                valor = 30;
                break;

            case "J♦":
                valor = 31;
                break;

            case "Q♦":
                valor = 32;
                break;

            case "K♦":
                valor = 33;
                break;
            // corazon
            case "A♥":
                valor = 41;
                break;
            case "2♥":
                valor = 42;
                break;

            case "3♥":
                valor = 43;
                break;

            case "4♥":
                valor = 44;
                break;

            case "5♥":
                valor = 45;
                break;

            case "6♥":
                valor = 46;
                break;

            case "7♥":
                valor = 47;
                break;

            case "8♥":
                valor = 48;
                break;

            case "9♥":
                valor = 49;
                break;

            case "10♥":
                valor = 50;
                break;

            case "J♥":
                valor = 51;
                break;

            case "Q♥":
                valor = 52;
                break;

            case "K♥":
                valor = 53;
                break;

            // pica
            case "A♠":
                valor = 61;
                break;
            case "2♠":
                valor = 62;
                break;

            case "3♠":
                valor = 63;
                break;

            case "4♠":
                valor = 64;
                break;

            case "5♠":
                valor = 65;
                break;

            case "6♠":
                valor = 66;
                break;

            case "7♠":
                valor = 67;
                break;

            case "8♠":
                valor = 68;
                break;

            case "9♠":
                valor = 69;
                break;

            case "10♠":
                valor = 70;
                break;

            case "J♠":
                valor = 71;
                break;

            case "Q♠":
                valor = 72;
                break;

            case "K♠":
                valor = 73;
                break;

            default:
                valor = -1;
                break;
        }

        return valor;
    }

    /**
     * Figura de la carta segun el valor de la carta que reciba
     * @param Nocarta
     * @return 
     */
    public String valCartaString(int Nocarta) {
        int valor = 0;
        String carta = "";
        switch (Nocarta) {
            // trebol
            case 1:
                carta = "A♣";
                break;
            case 2:
                carta = "2♣";
                break;

            case 3:
                carta = "3♣";
                break;

            case 4:
                carta = "4♣";
                break;

            case 5:
                carta = "5♣";
                break;

            case 6:
                carta = "6♣";
                break;

            case 7:
                carta = "7♣";
                break;

            case 8:
                carta = "8♣";
                break;

            case 9:
                carta = "9♣";
                break;

            case 10:
                carta = "10♣";
                break;

            case 11:
                carta = "J♣";
                break;

            case 12:
                carta = "Q♣";
                break;

            case 13:
                carta = "K♣";
                break;
            // diamante
            case 21:
                carta = "A♦";
                break;
            case 22:
                carta = "2♦";
                break;

            case 23:
                carta = "3♦";
                break;

            case 24:
                carta = "4♦";
                break;

            case 25:
                carta = "5♦";
                break;

            case 26:
                carta = "6♦";
                break;

            case 27:
                carta = "7♦";
                break;

            case 28:
                carta = "8♦";
                break;

            case 29:
                carta = "9♦";
                break;

            case 30:
                carta = "10♦";
                break;

            case 31:
                carta = "J♦";
                break;

            case 32:
                carta = "Q♦";
                break;

            case 33:
                carta = "K♦";
                break;
            // corazon
            case 41:
                carta = "A♥";
                break;
            case 42:
                carta = "2♥";
                break;

            case 43:
                carta = "3♥";
                break;

            case 44:
                carta = "4♥";
                break;

            case 45:
                carta = "5♥";
                break;

            case 46:
                carta = "6♥";
                break;

            case 47:
                carta = "7♥";
                break;

            case 48:
                carta = "8♥";
                break;

            case 49:
                carta = "9♥";
                break;

            case 50:
                carta = "10♥";
                break;

            case 51:
                carta = "J♥";
                break;

            case 52:
                carta = "Q♥";
                break;

            case 53:
                carta = "K♥";
                break;

            // pica
            case 61:
                carta = "A♠";
                break;
            case 62:
                carta = "2♠";
                break;

            case 63:
                carta = "3♠";
                break;

            case 64:
                carta = "4♠";
                break;

            case 65:
                carta = "5♠";
                break;

            case 66:
                carta = "6♠";
                break;

            case 67:
                carta = "7♠";
                break;

            case 68:
                carta = "8♠";
                break;

            case 69:
                carta = "9♠";
                break;

            case 70:
                carta = "10♠";
                break;

            case 71:
                carta = "J♠";
                break;

            case 72:
                carta = "Q♠";
                break;

            case 73:
                carta = "K♠";
                break;

            default:
                valor = -1;
                break;
        }

        return carta;
    }

    /**
     *
     * @param carta
     * @return
     */
    public int valorRealdelaCarta(String carta) {
        if (carta.equals("A♣") || carta.equals("A♥") || carta.equals("A♦") || carta.equals("A♠")) {
            return 1;
        } else if (carta.equals("2♣") || carta.equals("2♥") || carta.equals("2♦") || carta.equals("2♠")) {
            return 2;
        } else if (carta.equals("3♣") || carta.equals("3♥") || carta.equals("3♦") || carta.equals("3♠")) {
            return 3;
        } else if (carta.equals("4♣") || carta.equals("4♥") || carta.equals("4♦") || carta.equals("4♠")) {
            return 4;
        } else if (carta.equals("5♣") || carta.equals("5♥") || carta.equals("5♦") || carta.equals("5♠")) {
            return 5;
        } else if (carta.equals("6♣") || carta.equals("6♥") || carta.equals("6♦") || carta.equals("6♠")) {
            return 6;
        } else if (carta.equals("7♣") || carta.equals("7♥") || carta.equals("7♦") || carta.equals("7♠")) {
            return 7;
        } else if (carta.equals("8♣") || carta.equals("8♥") || carta.equals("8♦") || carta.equals("8♠")) {
            return 8;
        } else if (carta.equals("9♣") || carta.equals("9♥") || carta.equals("9♦") || carta.equals("9♠")) {
            return 9;
        } else if (carta.equals("10♣") || carta.equals("10♥") || carta.equals("10♦") || carta.equals("10♠")) {
            return 10;
        } else if (carta.equals("J♣") || carta.equals("J♥") || carta.equals("J♦") || carta.equals("J♠")) {
            return 11;
        } else if (carta.equals("Q♣") | carta.equals("Q♥") | carta.equals("Q♦") | carta.equals("Q♠")) {
            return 12;
        } else if (carta.equals("K♣") | carta.equals("K♥") | carta.equals("K♦") | carta.equals("K♠")) {
            return 13;
        } else {
            return -1;
        }

    }
    
    public String getCarta(int Nocarta) {
        
        int valor = 0;
        String carta = "";
        switch (Nocarta) {
            // trebol
            case 1:
                carta = "A♣";
                break;
            case 2:
                carta = "2♣";
                break;

            case 3:
                carta = "3♣";
                break;

            case 4:
                carta = "4♣";
                break;

            case 5:
                carta = "5♣";
                break;

            case 6:
                carta = "6♣";
                break;

            case 7:
                carta = "7♣";
                break;

            case 8:
                carta = "8♣";
                break;

            case 9:
                carta = "9♣";
                break;

            case 10:
                carta = "10♣";
                break;

            case 11:
                carta = "J♣";
                break;

            case 12:
                carta = "Q♣";
                break;

            case 13:
                carta = "K♣";
                break;
            // diamante
            case 21:
                carta = "A♦";
                break;
            case 22:
                carta = "2♦";
                break;

            case 23:
                carta = "3♦";
                break;

            case 24:
                carta = "4♦";
                break;

            case 25:
                carta = "5♦";
                break;

            case 26:
                carta = "6♦";
                break;

            case 27:
                carta = "7♦";
                break;

            case 28:
                carta = "8♦";
                break;

            case 29:
                carta = "9♦";
                break;

            case 30:
                carta = "10♦";
                break;

            case 31:
                carta = "J♦";
                break;

            case 32:
                carta = "Q♦";
                break;

            case 33:
                carta = "K♦";
                break;
            // corazon
            case 41:
                carta = "A♥";
                break;
            case 42:
                carta = "2♥";
                break;

            case 43:
                carta = "3♥";
                break;

            case 44:
                carta = "4♥";
                break;

            case 45:
                carta = "5♥";
                break;

            case 46:
                carta = "6♥";
                break;

            case 47:
                carta = "7♥";
                break;

            case 48:
                carta = "8♥";
                break;

            case 49:
                carta = "9♥";
                break;

            case 50:
                carta = "10♥";
                break;

            case 51:
                carta = "J♥";
                break;

            case 52:
                carta = "Q♥";
                break;

            case 53:
                carta = "K♥";
                break;

            // pica
            case 61:
                carta = "A♠";
                break;
            case 62:
                carta = "2♠";
                break;

            case 63:
                carta = "3♠";
                break;

            case 64:
                carta = "4♠";
                break;

            case 65:
                carta = "5♠";
                break;

            case 66:
                carta = "6♠";
                break;

            case 67:
                carta = "7♠";
                break;

            case 68:
                carta = "8♠";
                break;

            case 69:
                carta = "9♠";
                break;

            case 70:
                carta = "10♠";
                break;

            case 71:
                carta = "J♠";
                break;

            case 72:
                carta = "Q♠";
                break;

            case 73:
                carta = "K♠";
                break;

            default:
                valor = -1;
                break;
        }

        return carta;
    }
}
