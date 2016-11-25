package cn.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * Created by max.lu on 2016/3/17.
 */
public class FindTask {
    @Test
    public void findMyPersonTask() {
        printTaskInfo("max");
        printTaskInfo("max2");
    }

    private void printTaskInfo(String assignee) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee(assignee).list();
        System.out.println("Task of " + assignee + " :");
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("no tasks.\n");
            return;
        }
        for (Task task : tasks) {
            System.out.println("task id : " + task.getId());
            System.out.println("task name : " + task.getName());
            System.out.println("parent task id : " + task.getParentTaskId());
            System.out.println("task create time : " + task.getCreateTime());
            System.out.println("task assignee : " + task.getAssignee());
            System.out.println("process instance id : " + task.getProcessInstanceId());
            System.out.println("execution id : " + task.getExecutionId());
            System.out.println("process definition id : " + task.getProcessDefinitionId());
            System.out.println("--------------");
        }
        System.out.println();
    }
}
