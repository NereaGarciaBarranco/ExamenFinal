package examenFinal;

/**
 * Esta clase sirve para formar objetos de tipo SimplLinkedList 
 * que crean una estructura de objetos de tipo Node que se van 
 * apuntando entre si. Se guarda cual es el primero para poder 
 * acceder siempre a el y realizar los desplazamientos necesarios. 
 * Tambien se guarda el tamano de la lista para saber cuantos hay.. 
 */

public class SimpleLinkedList {
	// Atributos de la clase
    private Node first;
    private int size;
    
    // Constructores de la clase
    public SimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public SimpleLinkedList(Node first) {
        this.first = first;
        this.size = 1;
    }
    
    // Metodos get y set
    public Node getFirst() {
        return this.first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Pre: ---
     * Post: Este metodo anade un nodo pasado por parametro teniendo
     * en cuenta si se va a insertar en la primera posicion, y si
     * no siempre lo agrega en la ultima, como la clase ArrayList.
     */
    public boolean add(Node node) {
        try {
        	// Si es el primer nodo que se inserta sera el primero
            if (this.size == 0) {
                this.first = node;
            } 
            // En el resto de casos buscamos el ultimo Nodo
            else {
                Node p = this.first;
                for(int i = 1; i < this.size; ++i) {
                    p = p.getNext();
                }
                // Una vez encontrado le decimos que su siguiente es el nuevo Nodo
                p.setNext(node);
            }
            // Aumentamos el tamano
            size++; return true;
        } catch (Exception var4) {
            System.out.println(var4.toString());
            return false;
        }
    }
    
    /**
     * Pre: ---
     * Post: Este metodo borra el Nodo de una lista Simple Enlazada
     * que se encuentre en esa posicion.
     */
    public boolean delete(int position) {
        try {
        	// Si se quiere borrar el primer nodo
            if (position == 0) {
            	// Desapuntamos el primer nodo y se piede
                first = first.getNext();
            } else {
            	// Creamos un puntero
                Node p;
                // Si es el ultimo nodo el que queremos borrar
                if (position == size) {
                    p = first;
                    for(int i = 1; i < this.size - 1; i++) {
                        p = p.getNext();
                    }
                    p.setNext((Node)null);
                } 
                // Si el nodo esta en medio
                else {
                    p = first;
                    for(int i = 0; i < position - 1; i++) {
                        p = p.getNext();
                    }
                    p.setNext(p.getNext().getNext());
                }
            }
            size--; return true;
        } catch (Exception var4) {
            System.out.println(var4.toString());
            return false;
        }
    }
    
    /**
     * Pre: ---
     * Post: Este metodo devuelve el Nodo situado en la posicion
     * pasada por parametro, como si fuera el metodo get de la 
     * clase ArrayList.
     */
    public Node get(int position) {
        try {
        	// Si la posicion es correcta
            if (position >= 0 && position < this.size) {
            	// Creamos un puntero
                Node p = this.first;
                // Avanzamos hasta la posicion que queremos
                for(int i = 1; i <= position; ++i) {
                    p = p.getNext();
                }
                // Devolvemos ese Node
                return p;
            }
        } catch (Exception var4) {
            System.out.println(var4.toString());
        }
        return null;
    }
    
    /**
     * Pre: ---
     * Post: Este metodo muestra por pantalla el contenido de una lista
     * simple enlazada que contiene numeros enteros.
     */
    public void show() {
        Node p = this.first;
        for(int i = 0; i < this.size; ++i) {
            System.out.println("[" + i + "] -> " + p.getContent());
            p = p.getNext();
        }
    }
    
    /**
     * Pre: ---
     * Post: Este metodo borra el elemento mayor de una Lista Simple
     * Enlazada que contiene enteros.
     */
    public void eliminarMayor() {
    	// Al principio el Nodo mayor siempre es el primero
        Node nodoActual = this.first;
        Node nodoMayor = this.first;
        int posicionMayor = 0;
        // Recorremos los nodos de la lista
        for(int i = 0; i < this.size; ++i) {
        	// Si el contenido del siguiente nodo es mayor que el actual
            if (nodoActual.getNext() != null && nodoActual.getNext().getContent() 
            		> nodoMayor.getContent()) {
            	// Decimos que es el nuevo nodo mayor
                nodoMayor = nodoActual.getNext();
                // Seteamos cual es su posicion nueva
                posicionMayor = i + 1;
            }
            // Vamos pasando al siguiente nodo para hacer la nueva comprobacion
            nodoActual = nodoActual.getNext();
        }
        // Una vez que hemos encontrado el nodo mayor lo borramos
        this.delete(posicionMayor);
        // Informamos de ello por consola
        System.out.println("El mayor era " + nodoMayor.getContent() 
        						+ " y ya ha sido borrado.");
    }
}
