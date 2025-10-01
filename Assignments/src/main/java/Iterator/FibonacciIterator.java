package Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FibonacciIterator implements Iterator<Integer> {

    private FibonacciSequence sequence;

    public FibonacciIterator(FibonacciSequence sequence) {
        this.sequence = sequence;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        /*
        Operating on the sequence objects' current and last numbers enables multiple iterators to
        advance the sequence independently.
         */
        Integer next = sequence.getCurrent() + sequence.getLast();
        sequence.setLast(sequence.getCurrent());
        sequence.setCurrent(next);
        return next;
    }
}
