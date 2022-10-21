import Container.Strategy;
import Factory.TaskContainerFactory;
import Model.MessageTask;
import Model.SortingTask;
import Runners.*;
import Sorter.AbstractSorter;
import Sorter.BubbleSorter;
import Sorter.MergeSorter;

import java.time.LocalDateTime;

@SuppressWarnings("SpellCheckingInspection")
public class TestRunner {
    private static MessageTask[] getMessages() {
        MessageTask temaLab = new MessageTask("1",
                "doua probleme", "pentru seminar", "Mihai","Florentin", LocalDateTime.now());

        MessageTask temaSeminar = new MessageTask("2",
                "trei probleme","pentru laborator","Andrei","Andreea",LocalDateTime.now());

        MessageTask temaCurs = new MessageTask("3",
                "patru probleme","pentru curs", "Diana", "Paula", LocalDateTime.now());

        MessageTask temaLab2 = new MessageTask("4",
                "doua probleme","pentru lab2", "Daniela", "Sky", LocalDateTime.now());

        MessageTask temaLab3 = new MessageTask("5",
                "patru probleme","pentru lab3", "Echo", "Azotic", LocalDateTime.now());

        return new MessageTask[]{temaLab, temaSeminar, temaCurs, temaLab2, temaLab3};
    }

    private static SortingTask[] getSortingTasks(){
        AbstractSorter sorter = new MergeSorter();
        SortingTask t1 = new SortingTask("11", "pentru lab", new Integer[]{10,3,5,3}, sorter);
        SortingTask t2 = new SortingTask("12", "pentru lab2", new Integer[]{1,3,2,3, 9, 2}, sorter);
        SortingTask t3 = new SortingTask("13", "pentru lab3", new Integer[]{0,12,42,1, 23}, sorter);

        return new SortingTask[]{t1, t2, t3};
    }

    public static void run(String arg) {
        MessageTask[] messages = getMessages();
        SortingTask[] sorters = getSortingTasks();

        // 0. Sorting Task
        System.out.println("Sorting task:");
        StrategyTaskRunner sorterTaskRunner = new StrategyTaskRunner(Strategy.valueOf(arg));
        for(SortingTask task : sorters) {
            sorterTaskRunner.addTask(task);
        }
        sorterTaskRunner.executeAll();

        // 1. StrategyTaskRunner
        System.out.println("StrategyTaskRunner:");
        StrategyTaskRunner strTaskRunner = new StrategyTaskRunner(Strategy.valueOf(arg));
        for(MessageTask msg : messages) {
            strTaskRunner.addTask(msg);
        }
        strTaskRunner.executeAll();

        // 2. DelayTaskRunner
        System.out.println("\nDelayTaskRunner:");
        DelayTaskRunner dlTaskRunenr = new DelayTaskRunner(strTaskRunner);
        for(MessageTask msg : messages) {
            strTaskRunner.addTask(msg);
        }
        dlTaskRunenr.executeAll();

        // 3. Printer TaskRunner
        System.out.println("\nPrinterTaskRunner");
        PrinterTaskRunner prtTaskRunner = new PrinterTaskRunner(strTaskRunner);
        for(MessageTask msg : messages) {
            strTaskRunner.addTask(msg);
        }
        prtTaskRunner.executeAll();
    }

}
