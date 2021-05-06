import java.util.Scanner;

public class Main {
        Scanner miguel = new Scanner(System.in); // Lector
        char[][] a = new char [9][9]; // La sala de cine es una matriz.
        int b = 0; // Filas.
        int c = 0; // Columnas.
        int e; // Tarjeta.
        int f = 64; // Cantidad de puestos.
        int w = 7000, x = 9000; // w = Estándar, x = Preferencial.
        double v = 0; // Total máximo.

        for (int i = 1; i < a.length; i++){
            for (int j = 1; j < a[1].length; j++){
                a[i][j] = 'O'; // Se rellena la matriz con caracteres O
            }
        }

        for(int m = 0; m < f; m++){
            double y = 0; // Total por reserva.
            System.out.println("La sala está así, pantalla arriba:\nX = Ocupado.\nO = Vacío.\n");
            for (int i = 1; i < a.length; i++){
                for (int j = 1; j < a[1].length; j++){
                    System.out.print("["+a[i][j]+"] "); // Se imprime la matriz, muestra qué puestos están vacíos y llenos.
                }
                System.out.println();
            }

            System.out.print("\n¿Cuántos puestos deseas? ");
            int d = miguel.nextInt(); // Cantidad de puestos.
            if (d < 1 || d > f){
                System.out.println("No puedes elegir esa cantidad de puestos. ");
            } else {
                for (int z = 1; z <= d; z++){ // Ciclo que termina en la cantidad de puestos elegidos.
                    System.out.print(z+") ¿Qué puesto deseas? ");
                    b = miguel.nextInt(); // Fila. Ya inicializada.
                    c = miguel.nextInt(); // Columna. Ya inicializada.
                    if (b <= a.length && c <= a[0].length && a[b][c] != 'X'){ // Si la fila es menor que la longitud horizontal de la matriz y la columna es menor que la longitud vertical de la matriz y la posición deseada no está ocupada entonces...
                        for (int i = 1; i < a.length; i++){
                            for (int j = 1; j < a[1].length; j++){
                                a[b][c] = 'X'; // Rellenamos el puesto deseado con X para indicar que está lleno.
                            }
                        }
                        f--; // La cantidad de puestos disminuye 1 espacio
                        System.out.println("Tu puesto ha sido reservado.\n");
                        if (b > 0 && b < 7){ // Si la fila está entre 1 y 6
                            y += w; // La silla es una Estándar de 7000 pesos
                        } else if (b > 6 && b < 9){ // Si la fila está entre 7 y 8
                            y += x; // La silla es una preferencial de 9000 pesos
                        }
                    } else {
                        System.out.println("Ese puesto no puede ser reservado.\n");
                    }
                }

                do{
                    System.out.print("¿Utilizas Tarjeta Cineco? 1) Sí 2) No. ");
                    e = miguel.nextInt();
                    if (e == 1){
                        y -= (y * 0.1); // Si el usuario cuenta con tarjeta de suscripción, tiene rebaja del 10%
                    }
                }while(e != 1 && e != 2); // Si el usuario digita algo diferente de 1 o 2

                System.out. println("El costo de la reserva es: $"+y+"\n");
                v += y; // Total máximo se le añade el total de la reserva.
            }

            System.out.println("Gracias por utilizar nuestros servicios.\n\n ");
        }

        System.out.println("Esta sala está llena. ");
        for (int i = 1; i < a.length; i++){
            for (int j = 1; j < a[1].length; j++){
                System.out.print("["+a[i][j]+"] "); // Se imprime la matriz mostrando la sala llena de X
            }
            System.out.println();
        }
        System.out.println("Total recaudado: "+v);
    }
}
/*
 * Hecho por Ricardo García tras entender que esto es lo que hubiera tenido que entregarle a la profe Mireya en segundo semestre de haber entendido programación en ese entonces
 */
