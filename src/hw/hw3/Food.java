package hw.hw3;

import org.w3c.dom.ranges.RangeException;

abstract public class Food implements NutritionFacts {

    /**
     * The price should be somewhere between 1 and 100 dollars.
     */
    private int price;

    /**
     * The attribute `AUTHOR` tells who created this class.
     * It cannot be re-assigned another value because it is decorated by `final`.
     */
    public final String AUTHOR = "Zhen Liang";

    /**
     * `aboutThisClass()` prints out the AUTHOR of this class.
     * It cannot be overridden because it is decorated by `final`
     */
    public final void aboutThisClass() {
        System.out.println("The 'Food' class is brought to you by Zhen Liang.");
    }

    public void eat() {
        System.out.println("This food is great.");
    }

    /**
     * `foodDescription()` is an abstract method that must be overridden in subclasses.
     */
    abstract public void foodDescription();


    /**
     * `setPrice()` sets the price of this kind of food.
     * It will throw an exception if the price is not in the expected range, i.e., [1:100].
     * @param price    The price of this kind of food.
     * @throws IllegalArgumentException
     */
    public void setPrice(int price) throws IllegalArgumentException {
        if (price >= 1 && price <= 100) {
            this.price = price;
            System.out.println(String.format("Price set to %d", price));
        }
        else throw new IllegalArgumentException("Price out of range [1, 100]");
    }

    /**
     * Read the price of this kind of food.
     * @return this.price
     */
    public int getPrice() {return this.price;}

}
