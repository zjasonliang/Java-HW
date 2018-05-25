package hw.week6;

class MySonIsNotHappyException extends RuntimeException {
    public MySonIsNotHappyException() {
        super();
    }

    public MySonIsNotHappyException(String message) {
        super(message);
    }
}

/**
 * A class that simulates my son's mood!
 */
class Son {
    int happiness;

    public Son(int happiness) {
        if (happiness < 0) throw new IllegalArgumentException("Initial happiness less than 0.");
        else this.happiness = happiness;
    }

    public void decreaseHappiness(int amount) {
        if (happiness - amount < 0) throw new MySonIsNotHappyException("Can't do this! Happiness will drop to " + (happiness - amount) + "!");
        else this.happiness -= amount;
    }

    public void increaseHappiness(int amount) {
        this.happiness += amount;
    }


}

/**
 * My life with my lovely son!
 */
public class LifeWithSon {
    private Son son;

    public LifeWithSon(int initialHappiness) {
        this.son = new Son(initialHappiness);
    }

    /**
     * Play with him! Make him happier!
     */
    public void playWithMySon() {
        son.increaseHappiness(2);
    }

    /**
     * If you try not playing with your son, see what will happen...
     */
    public void notPlayWithMySon() {
        son.decreaseHappiness(5);
    }

    /**
     * Buying gifts is always the best policy!
     */
    public void buyHimGifts() {
        son.increaseHappiness(4);
    }

    public static void main(String[] args) {
        try {

            LifeWithSon life = new LifeWithSon(10);
            life.playWithMySon();
            life.buyHimGifts();
            life.notPlayWithMySon();
            life.notPlayWithMySon();
            life.notPlayWithMySon();
            life.notPlayWithMySon();
        } catch (MySonIsNotHappyException e) {
            e.printStackTrace();
        }
    }
}
