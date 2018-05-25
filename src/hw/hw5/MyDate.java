package hw.hw5;

public class MyDate implements Comparable {

    /**
     *  Allocates a Date object and initializes it so that
     * it represents the time at which it was allocated.
     */
    public MyDate() {

    }

    public MyDate(int year, int month, int day) {
    }

    public MyDate(int year, int month, int day, int hour, int minute, int second) {

    }

    /**
     * set the current date to a later date
     */
    public void forward() {

    }

    /**
     * set the current date to an earlier date
     */
    public void backward() {

    }


    /**
     * Returns the day of the week
     * @return the day of the week
     */
    public int getDay() {
        return 0;
    }


    /**
     * Class MyDate implements the interface Comparable.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
