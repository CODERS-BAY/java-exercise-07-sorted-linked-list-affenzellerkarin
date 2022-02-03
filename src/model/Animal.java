package model;

public class Animal implements Comparable <Animal> {

    private int animalID;
    private String animal;
    private int age;
    private String geraeusch;

    public Animal(int animalID, String animal, int age, String geraeusch) {
        this.animalID = animalID;
        this.animal = animal;
        this.age = age;
        this.geraeusch = geraeusch;
    }



    @Override
    public int compareTo(Animal other) {
        if (animalID == other.animalID) {
            if (animal.equals(other.animal)) {
                if (age == other.age) {
                    return geraeusch.compareTo(other.geraeusch);
                }
                return this.age - other.age;

            }
            return animal.compareTo(other.animal);
        }


        return this.animalID - other.animalID;
    }


    @Override
    public String toString() {
        return (animalID + ", " + animal  + ", Alter: " + age + ", Geräusch: " + geraeusch + '\n');
    }

}
