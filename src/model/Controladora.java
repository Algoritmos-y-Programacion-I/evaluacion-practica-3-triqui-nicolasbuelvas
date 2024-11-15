package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    /**
     * Permite al jugador humano realizar una jugada.
     *
     * @param fila    la fila donde desea jugar (0-2)
     * @param columna la columna donde desea jugar (0-2)
     * @return true si la jugada es válida y se realiza, false si no es válida.
     */
    public boolean realizarJugadaHumano(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tableroTresEnRaya[fila][columna].equals(" ")) {
            tableroTresEnRaya[fila][columna] = "O";
            return true;
        }
        return false;
    }

    /**
     * Verifica si hay un ganador en el tablero.
     *
     * @return "X" si gana la máquina, "O" si gana el humano, o null si no hay ganador.
     */
    public String verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tableroTresEnRaya[i][0].equals(tableroTresEnRaya[i][1]) &&
                tableroTresEnRaya[i][1].equals(tableroTresEnRaya[i][2]) &&
                !tableroTresEnRaya[i][0].equals(" ")) {
                return tableroTresEnRaya[i][0];
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tableroTresEnRaya[0][j].equals(tableroTresEnRaya[1][j]) &&
                tableroTresEnRaya[1][j].equals(tableroTresEnRaya[2][j]) &&
                !tableroTresEnRaya[0][j].equals(" ")) {
                return tableroTresEnRaya[0][j];
            }
        }

        if (tableroTresEnRaya[0][0].equals(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][2]) &&
            !tableroTresEnRaya[0][0].equals(" ")) {
            return tableroTresEnRaya[0][0];
        }
        if (tableroTresEnRaya[0][2].equals(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][0]) &&
            !tableroTresEnRaya[0][2].equals(" ")) {
            return tableroTresEnRaya[0][2];
        }

        return null;
    }
}