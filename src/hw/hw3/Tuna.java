package hw.hw3;

public class Tuna extends Food {

    /**
     * `numInstance` records how many instances of this class have been instantiated.
     */
    private static int numInstance = 0;

    public Tuna() {
        System.out.println(String.format("Tuna #%d was created.", ++numInstance));
    }

    @Override
    public void eat() {
        System.out.println("This tuna is great.");
    }

    @Override
    public void foodDescription() {
        System.out.println("tuna: a large fish that lives in warm seas");
    }

    @Override
    public void showNutrientsContained() {
        System.out.println("Nutrients contained in tuna...");
    }

    @Override
    public void showCalories() {
        System.out.println("Tuna: 200 kcal per 100 g.");
    }

    @Override
    public void showAdvice() {
        System.out.println("Go ahead and try tunas!");
    }

    public static int getNumInstance() {return numInstance;}
}
