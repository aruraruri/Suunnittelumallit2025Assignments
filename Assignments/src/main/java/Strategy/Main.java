package Strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // create datasets
        int[] bigIntArray = new int[100000];
        for (int i=0; i<bigIntArray.length-1; i++) {
            bigIntArray[i] = getRandomNumber(-1000000, 100000);
        }

        int[] smolIntArray = new int[30];
        for (int i=0; i<smolIntArray.length-1; i++) {
            smolIntArray[i] = getRandomNumber(-1000000, 100000);
        }

        // change sort type here
        SorterContext sorter = new SorterContext(new HeapSort());
        //sorter.setSortStrategy(new BubbleSort());
        sorter.setSortStrategy(new QuickSort());

        long sortBigStartTimeMs = System.nanoTime() / 1000000;
        sorter.sort(bigIntArray);
        long sortBigStopTimeMs = System.nanoTime() / 1000000;

        long sortTime = sortBigStopTimeMs - sortBigStartTimeMs;

        System.out.println(Arrays.toString(bigIntArray));
        System.out.println("sorting 100000 ints took "+sortTime+" ms");

        long sortStartTimeMs = System.nanoTime() / 1000000;
        sorter.sort(bigIntArray);
        long sortStopTimeMs = System.nanoTime() / 1000000;

        long sortSmolTime = sortStopTimeMs - sortStartTimeMs;

        System.out.println(Arrays.toString(smolIntArray));
        System.out.println("sorting 30 ints took "+sortSmolTime+" ms");


    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
