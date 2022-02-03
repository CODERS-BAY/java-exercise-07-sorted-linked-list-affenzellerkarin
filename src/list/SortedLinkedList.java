package list;


// S extends Comparable<S> bedeutet, dass sich zB Integer mit Integer vergleichen soll,
//oder Animal mit Animal
public class SortedLinkedList <S extends Comparable<S>> implements SortedList<S> {

    private Node<S> head;

    Node<S> current = new Node<S>();
    private int size;


    private class Node <S> {
        S elem;
        Node<S> next;


        @Override
        public String toString() {

            return elem.toString();
        }
    }

    @Override
    public void insert(S elem) {
        Node<S> newNode = new Node<>();
        Node<S> previous = null;
        current=head;
        newNode.elem = elem;

        // wenn die Liste noch leer ist, dann wird das neue Element in den Head gespeichert
        if (current==null) {
            head = newNode;
        }

        else {
            // Solange das aktuelle Element nicht leer ist und es kleiner als das zu hinzufügende ist,
            while (current !=null && current.elem.compareTo(newNode.elem) < 0) {
                // kann ich mein aktuelles Element als das Element davor annehmen und mit dem
                // aktuellen (also zu überprüfenden Element) um eines weiter rutschen -->
                previous = current;  //das momentan Aktuelle wird nun zum previous Element (ist also sicher vor dem,
                // das eingefügt werden soll
                current = current.next; //und mein neues aktuelles Element rutscht um eines weiter und es wird neu überprüft
           }
            //sobald der Punkt gefunden wurde, wo es eingefügt wird, wird zuerst überprüft, ob es einen Vorgänger gibt
            // Falls es keinen Vorgänger gibt, dann bedeutet das, dass das element vor das erste Element eingefügt gehört und somit
            // der neue Head wird

            if (previous!=null) { //sofern es einen Vorgänger gibt ...
            previous.next = newNode; // nun wird das neue Element direkt nach dem previous-Element eingefügt und zum
            // neuen previous-Element
            newNode.next = current; //und das Element nach dem neuen Element wird zum Current
            }
            else { // Wenn es keinen Vorgänger gibt, dann ist das neue Element der Head
                newNode.next=current; // Current wir auf das nächste Element geschoben
                head= newNode; // das einzufügenden Element wird der neue Head
            }
        }
        size++;
    }


    @Override
    public String toString() {
        Node<S> nodeCurrent=head;
        StringBuilder sb = new StringBuilder();
        while (nodeCurrent!=null) {
            sb.append(nodeCurrent);
            sb.append(", ");
            nodeCurrent=nodeCurrent.next;
        }

        return sb.substring(0, sb.length() -2);
        //Substring, damit ich den letzten Beistrich wegbekomme
    }

    @Override
    public boolean delete(int index) {
        Node <S> previous = null;
        current=head;

        // Überprüfen, ob die Liste leer ist
        if (head==null) {
            System.out.println("Die Liste ist leer");
            return false;
        }

        //Überprüfen, ob der gewünschte Index überhaupt innerhalb der Listenlänge liegt
        if (index > size) {
            System.out.println("Die Liste enthält nicht so viele Elemente");
            return false;
        }

        // falls man das erste Element löschen möchte
        if (index==1) {
            if (size == 1) { //falls es nur ein Element gibt, wird der Head auf null gesetzt
                head = null;
            } else {
                head = current.next; //der Head rutscht eines nach rechts
            }
        }
        //falls es mehr als ein Element in der Liste gibt
        else {
            for (int i=0; i<index-1; i++) {
                previous=current;
                current=current.next;
            }
            // das Previous-Element hüpft jetzt um 2 weiter, überspringt also das Element, das gelöscht wird.
            previous.next=current.next;
        }
        size--; //verringert die Anzahl der Elemente um 1
        System.out.println("Das Element " + this.current + " an der Stelle " + index + " wurde gelöscht");
        return true;
    }

    @Override
    public S get(int index) {
        current=head;

        // Überprüfen, ob die Liste leer ist
        if (head==null) {
            System.out.println("Die Liste ist leer");
            return null;
        }

        //Überprüfen, ob der gewünschte Index überhaupt innerhalb der Listenlänge liegt
        if (index > size) {
            System.out.println("Die Liste enthält nicht so viele Elemente");
            return null;
        }
        // Die Liste soll bis zum Element vor dem Index durchlaufen werden, current wird dann das Element an der richtigen Stelle
        for (int i=0; i<index-1; i++) {
            current=current.next;

        }
        System.out.println("An der Stelle " + index + " befindet sich das Element " + this.current);

      return current.elem; // ??? Warum ich das Element anhängen muss, weiß ich leider nicht.
    }

    @Override
    public int size() {
        return size;
    }



}
