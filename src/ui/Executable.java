package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    /**
     * Constructor de la clase Executable.
     */
    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    /**
     * Método principal que ejecuta el menú del programa.
     *
     * @param flag indica si el programa debe continuar ejecutándose.
     */
    public void run(boolean flag) {
        flag = false;

        while (!flag) {
            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" +
                    "1. Imprimir tablero \n" +
                    "2. Jugada de la maquina \n" +
                    "3. Jugada de humano \n" +
                    "4. Verificar ganador \n" +
                    "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida.");
                    continue;
            }
        }
    }

    /**
     * Método main que inicia la ejecución del programa.
     *
     * @param args argumentos del programa.
     */
    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    /**
     * Imprime el tablero actual en la consola.
     */
    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    /**
     * Realiza una jugada de la máquina y actualiza el tablero.
     */
    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina ha realizado su jugada.");
        imprimirTablero();
    }

    /**
     * Permite al jugador humano realizar una jugada ingresando las coordenadas.
     */
    private void jugadaHumano() {
        System.out.println("Ingrese la fila (0-2) para su jugada: ");
        int fila = reader.nextInt();
        System.out.println("Ingrese la columna (0-2) para su jugada: ");
        int columna = reader.nextInt();
        reader.nextLine();

        boolean jugadaExitosa = cont.realizarJugadaHumano(fila, columna);
        if (jugadaExitosa) {
            System.out.println("Jugada realizada con exito.");
        } else {
            System.out.println("Jugada invalida, intente nuevamente.");
        }
        imprimirTablero();
    }

    /**
     * Valida si hay un ganador en el tablero actual.
     */
    private void validarGanador() {
        String ganador = cont.verificarGanador();
        if (ganador != null) {
            System.out.println("Tenemos un ganador! El ganador es: " + ganador);
        } else {
            System.out.println("No hay un ganador todavia.");
        }
    }
}