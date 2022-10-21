package Runners;

import Utils.Constants;

import java.time.LocalDateTime;

public class DelayTaskRunner extends AbstractTaskRunner{
    public DelayTaskRunner(TaskRunner runner) {
        super(runner);
    }
    @Override
    public void executeOneTask() {
        decorateExecuteOneTask();
        runner.executeOneTask();
    }

    public void decorateExecuteOneTask() {
        try{
            Thread.sleep(2500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
