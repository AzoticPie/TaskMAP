package Sorter;

public class BubbleSorter extends AbstractSorter{
    public void sort(Integer[] values){
        this.bubbleSort(values);
    }
    private void bubbleSort(Integer[] values) {
        for (int i = 0; i < values.length - 1; i++)
            for (int j = 0; j < values.length - i - 1; j++)
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
    }
}
