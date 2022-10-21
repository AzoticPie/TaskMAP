package Model;

import Sorter.AbstractSorter;
import Sorter.BubbleSorter;
import Sorter.SortingMethod;

public class SortingTask extends Task {
    private Integer[] values;
    private AbstractSorter sorter;

    public SortingTask(String taskID, String description) {
        super(taskID, description);
        this.values = new Integer[]{};
        this.sorter = new BubbleSorter();
    }
    public SortingTask(String taskID, String description, Integer[] values) {
        super(taskID, description);
        this.values = values;
        this.sorter = new BubbleSorter();
    }

    public SortingTask(String taskID, String description, Integer[] values, AbstractSorter sorter) {
        super(taskID, description);
        this.values = values;
        this.sorter = sorter;
    }

    public void setValues(Integer[] values) {
        this.values = values;
    }

    public Integer[] getValues() {
        return values;
    }

    public AbstractSorter getSorter() {
        return sorter;
    }

    public void setSorter(AbstractSorter sorter) {
        this.sorter = sorter;
    }

    public void execute(){
        this.sorter.sort(this.values);
        System.out.println(this.toString()+ "\n");
    }

    @Override
    public String toString(){
        String temp = new String();
        for(Integer value: this.values){
            temp += value.toString() + " ";
        }
        return super.toString() + ": " + temp;
    }
}
