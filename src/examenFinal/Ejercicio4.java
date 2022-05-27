package examenFinal;

import java.util.Scanner;

public class Ejercicio4 {
	
	/**
	 * Pre: ---
	 * Post: Este metodo main se encarga de pedir al usuario un numero
	 * para mostrarle, a traves de un metodo recursivo, la tabla de 
	 * multiplicar de ese numero hasta multiplicar por 100, solo de 
	 * los numeros pares. 
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
	    int numero = entrada.nextInt();
		tablaMultiplicar(numero);
		entrada.close();
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recibe un numero y se encarga de añadir
	 * el contador necesario para ejecutar el metodo recursivo
	 * sin que el usuario se entere.
	 */
	public static void tablaMultiplicar(int numero) {
		tablaMultiplicar(numero, 0);
	}
	
	/**
	 * Pre: ---
	 * Post: A este metodo le pasaremos el numero de la tabla que 
	 * queremos mostrar (por ejemplo para la tabla del 4 le 
	 * pasaremos un 4) y un numero contador que empieza en 0 
	 * que sirve como variable de control para dejar de llamarse 
	 * recursivamente a si mismo. Cuando esta variable sea mayor 
	 * o igual que 100 dejara de llamarse a si mismo. 
	 */
	private static void tablaMultiplicar(int numero, int contador) {	
		// Preguntamos si contador es un numero par para mostrar la multiplicacion o no
		if (contador % 2 != 1) {
			System.out.println(numero + " x " + contador + " = " + numero * contador);
		}
		// Mientras que contador sea inferior a 100
		if (contador < 100) {
			// Volvemos a llamar al metodo pero sumando 1 al contador
			tablaMultiplicar(numero, contador + 1);
		}	
	}

}
