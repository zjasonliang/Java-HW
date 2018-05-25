package hw.hw3;

public class Main {
    public static void main(String[] args) {

        // Demo: Polymorphic array
        // Store objects of different classes in a superclass array.
        Food[] food = new Food[2];
        food[0] = new Potpie();
        food[1] = new Tuna();

        for (int i = 0; i < food.length; i++) food[i].eat();


        // Demo: Polymorphic Arguments
        Fatty bucky = new Fatty();
        bucky.digest(food[0]);
        bucky.digest(food[1]);

        System.out.println(Tuna.getNumInstance());
        System.out.println(Potpie.getNumInstance());
    }
}
