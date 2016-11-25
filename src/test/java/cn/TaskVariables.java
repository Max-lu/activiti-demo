package cn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.Date;

/**
 * Created by max.lu on 2016/3/17.
 */
public class TaskVariables {
    @Test
    public void setVariables() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String taskId = "40004";
        taskService.setVariable(taskId, "name", "name1");
        taskService.setVariable(taskId, "time", new Date());
        JavaBean javaBean = new JavaBean();
        javaBean.setRight(false);
        taskService.setVariable(taskId, "javaBean", javaBean);
        System.out.println("set variables success");
    }

    @Test
    public void getTaskVariables() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String taskId = "40004";
        String name = (String) taskService.getVariable(taskId, "name");
        Date time = (Date) taskService.getVariable(taskId, "time");
        JavaBean javaBean = (JavaBean) taskService.getVariable(taskId, "javaBean");
        System.out.println(name);
        System.out.println(time);
        System.out.println(javaBean.isRight());
    }


}
