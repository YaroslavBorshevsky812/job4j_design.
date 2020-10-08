package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        int evenIndex = 0;
        boolean isEven = false;
        for (int i = point; i < numbers.length; i++) {
                if(numbers[i] %2 == 0){
                    isEven = true;
                    evenIndex = i;
                }
                point = evenIndex;
        }
        return isEven;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return null;
    }
}


