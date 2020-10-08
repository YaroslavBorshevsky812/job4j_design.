package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int cell = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;

        for (int i = 0; i < data.length; i++) {
            if(data[i].length != 0){
                return true;
            }
        }
        return hasNext;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while(cell >= data[row].length && row < data.length -1){
            row++;
            cell = 0;
        }
        return data[row][cell++];
    }
}
