package application;



import list.SortedLinkedList;
import list.SortedList;
import model.Animal;

import java.util.Iterator;
import java.util.*;

public class Main {
    public static void main(String[] args) {

// ------------------------------ mit Integer ----------------------------

        System.out.println(" ------------------------ mit Integer ------------------------------------");
        final SortedList<Integer> list = new SortedLinkedList<>();

        list.delete(1);

        list.insert(4);

        System.out.println(list);

        list.delete(1);

        list.insert(5);
        list.insert(1);
        System.out.println(list);

        list.insert(2);
        System.out.println(list);

        list.insert(7);



        System.out.println(list);

        System.out.println("Länge der Liste ist " + list.size());


        list.delete(4);

        System.out.println(list);
        System.out.println("Länge der Liste ist " + list.size());
        list.get(3);

        // -------------------------------- mit String ------------------------------

        System.out.println(" ------------ und jetzt mit String -------------------");


        final SortedList<String> listString = new SortedLinkedList<>();

        listString.insert("Berta");
        listString.insert("Katrin");
        listString.insert("Alfred");

        System.out.println(listString);

        listString.insert("Christian");
        System.out.println(listString);

        listString.delete(1);

        System.out.println(listString);

        listString.insert("Susanne");
        System.out.println(listString);

        System.out.println("Länge der Liste ist " + listString.size());


        // ------------------------------ mit Animal -------------------------

        System.out.println("------------ Jetzt mit Animal ----------------------");

        final SortedList<Animal> listAnimal = new SortedLinkedList<>();

        listAnimal.insert(new Animal(2, "Katze", 5, "Miau"));
        listAnimal.insert(new Animal(1, "Ameise", 3, "UhUh"));
        listAnimal.insert(new Animal(2, "Katze", 3, "Miau"));
        listAnimal.insert(new Animal(1, "Affe", 7, "UhUh"));
        listAnimal.insert(new Animal(2, "Katze", 5, "Iau"));

        System.out.println(listAnimal);
        listAnimal.delete(5);
        System.out.println(listAnimal);
    }
}




