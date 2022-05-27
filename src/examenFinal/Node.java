package examenFinal;

/**
* Esta clase crea objetos de tipo Node que sirven para almacenar
* numeros de tipo entero y mediante su siguiente podemos saber
* el que le sigue en una Lista Simple Enlazada.
*/
public class Node {
	// Atributos de la clase
    private int content;
    private Node next;
    
    // Metodo constructor
    public Node(int content, Node next) {
        this.content = content;
        this.next = next;
    }

    // Metodos get y set
    public int getContent() {
        return this.content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "Content = " + this.content + " Next = " + this.next;
    }
}
