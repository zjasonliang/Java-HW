package hw;
import java.lang.Math;

public class Cube {
    private long cubeSum(long begin, long end) {
        return (end*(end + 1)/2) * (end*(end + 1)/2) - (begin*(begin - 1)/2) * (begin*(begin - 1)/2);
    }

    public static void main(String [] args) {
        Cube c = new Cube();
        for (long end = 1; end < 10000; end++)
            for (long begin = 1; begin < end; begin++) {
                long candidate = (long) Math.floor(Math.cbrt(c.cubeSum(begin, end)));
                if (candidate*candidate*candidate == c.cubeSum(begin, end))
                    System.out.format("%d ... %d -> %d\n", begin, end, candidate);
                if ((candidate-1)*(candidate-1)*(candidate-1) == c.cubeSum(begin, end))
                    System.out.format("%d ... %d -> %d\n", begin, end, candidate-1);
                if ((candidate+1)*(candidate+1)*(candidate+1) == c.cubeSum(begin, end))
                    System.out.format("%d ... %d -> %d\n", begin, end, candidate+1);
            }
    }
}
