package examenFinal;

public class Node {
    private int content;
    private Node next;

    public Node(int content, Node next) {
        this.content = content;
        this.next = next;
    }

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

    public String toString() {
        return "Content = " + this.content + " Next = " + this.next;
    }
}
