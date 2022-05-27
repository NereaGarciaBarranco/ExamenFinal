package examenFinal;

public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post: Este metodo main se encarga de demostrar por consola
	 * el funcionamiento del metodo eliminarMayor(), con el cual
	 * se elimina el Nodo con el contenido mayor de una Lista
	 * Simple Enlazada.
	 */
    public static void main(String[] args) {
    	// Creamos una lista 
        SimpleLinkedList l = new SimpleLinkedList();
        // Creamos y añadimos varios nodos
        Node n1 = new Node(300, (Node)null);
        l.add(n1);
        Node n2 = new Node(8, (Node)null);
        l.add(n2);
        Node n3 = new Node(53, (Node)null);
        l.add(n3);
        Node n4 = new Node(17, (Node)null);
        l.add(n4);
        Node n5 = new Node(11, (Node)null);
        l.add(n5);
        System.out.println("El estado inicial de la lista es:");
        l.show();
        l.eliminarMayor();
        System.out.println("El estado final de la lista es:");
        l.show();
    }
}
