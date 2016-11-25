package cn.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * Created by max.lu on 2016/3/17.
 */
public class CompleteTask {
    @Test
    public void completeMyPersonTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService().complete("22502");
        System.out.println("complete task");
    }
}
