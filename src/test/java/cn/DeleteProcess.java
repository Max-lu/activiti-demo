package cn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.util.List;

/**
 * Created by max.lu on 2016/3/17.
 */
public class DeleteProcess {
    @Test
    public void deleteProcessDefinitionByKey() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String key = "myProcess";
        List<Deployment> list = processEngine.getRepositoryService().createDeploymentQuery().processDefinitionKey(key).list();
        if (list != null && !list.isEmpty()) {
            for (Deployment deployment : list) {
                String deployId = deployment.getId();
//                processEngine.getRepositoryService().deleteDeployment(deployId);//只能删除未启动的
                processEngine.getRepositoryService().deleteDeployment(deployId, true);//级联删除，启动的也可删除
                System.out.println("delete success.");
            }
        }
    }
}
