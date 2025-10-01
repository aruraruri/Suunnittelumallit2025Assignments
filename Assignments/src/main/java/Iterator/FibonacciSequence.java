package Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FibonacciSequence implements Sequence {
    /*
    The sequence class only keeps track of current and last numbers for the iterators to do their work.
     */

    private Integer current = 1;
    private Integer last = 0;

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }

    public Integer getCurrent() {
        return current;
    }
    public Integer getLast() {
        return last;
    }
    public void setCurrent(Integer current) {
        this.current = current;
    }
    public void setLast(Integer last) {
        this.last = last;
    }
}
