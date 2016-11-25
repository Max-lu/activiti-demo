package cn.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class DeploymentProcessDefinition {

    @Test
    public void deploymentProcessDefinition() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = processEngine.getRepositoryService().createDeployment().name("first activiti").addClasspathResource("testActiviti.bpmn").deploy();
        System.out.println("deployment id : " + deployment.getId());
        System.out.println("deployment name : " + deployment.getName());
    }


}
