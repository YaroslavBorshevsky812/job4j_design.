package Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public boolean hasNext() {
        boolean even = false;
        for (int i = this.point; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                even = true;
            }
        }
        return even;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
            while(numbers[point] %2 !=0){
                point++;
            }
        return numbers[point++];
    }
}


