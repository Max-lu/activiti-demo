package cn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by max.lu on 2016/3/17.
 */
public class GatewayTest {
    @Test
    public void start() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRepositoryService().createDeployment().name("second activiti").addClasspathResource("testActiviti2.bpmn").deploy();
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");
        System.out.println("process instance id = " + processInstance.getId());
    }

    @Test
    public void findAllTask() {
        findTask("max0");
        findTask("max1");
        findTask("max2");
    }

    private void findTask(String assignee) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Task task = processEngine.getTaskService().createTaskQuery().taskAssignee(assignee).singleResult();
        System.out.println(assignee + " : " + (task == null ? "null" : task.getId()));
    }

    @Test
    public void completeTask() {
        String taskId = "72504";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("go", false);
        processEngine.getTaskService().complete(taskId, map);
        System.out.println("complete task : " + taskId);
    }

    @Test
    public void isProcessEnd() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String processInstanceId = "70005";
        ProcessInstance pi = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        if (pi == null) {
            System.out.println("end");
        } else {
            System.out.println("not end");
        }
        Logger.getGlobal().info("hahahaha");
    }
}
