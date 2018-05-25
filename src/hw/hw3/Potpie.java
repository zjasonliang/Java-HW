package hw.hw3;

public class Potpie extends Food {

    /**
     * `numInstance` records how many instances of this class have been instantiated.
     */
    private static int numInstance = 0;

    public Potpie() {
        System.out.println(String.format("Potpie #%d was created.", ++numInstance));
    }

    @Override
    public void eat() {
        System.out.println("This potpie is great.");
    }

    @Override
    public void foodDescription() {
        System.out.println("potpie: pastry-covered meat and vegetables cooked in a deep dish");
    }

    @Override
    public void showNutrientsContained() {
        System.out.println("Here are the nutrients contained in potpies...");
    }

    @Override
    public void showCalories() {
        System.out.println("Potpie: 198 kcal per 100 g.");
    }

    @Override
    public void showAdvice() {
        System.out.println("Potpie is good.");
    }

    public static int getNumInstance() {return numInstance;}
}
