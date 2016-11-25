package cn.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * Created by max.lu on 2016/3/17.
 */
public class StartProcessInstance {

    @Test
    public void startProcessInstance() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println("--------------");
        String key = "myProcess";
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(key);
        System.out.println("instance id : " + processInstance.getId());
        System.out.println("definition id : " + processInstance.getProcessDefinitionId());
    }
}
