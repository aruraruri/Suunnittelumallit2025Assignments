package Strategy;

public class SorterContext{

    private SortingStrategy sortStrategy;

    public SorterContext(SortingStrategy strategy) {
        this.sortStrategy = strategy;
    }

    public void setSortStrategy(SortingStrategy strategy) {
        this.sortStrategy = strategy;
    }

    public int[] sort(int[] ints) {
        System.out.println("Sorting with "+sortStrategy.getClass());
        return sortStrategy.sortInts(ints);
    }

}
