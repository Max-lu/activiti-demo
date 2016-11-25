package cn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * Created by max.lu on 2016/3/17.
 */
public class DeploymentTest {


    /**
     * 部署流程定义 类路径从classpath
     */
    @Test
    public void deploymentProcessDefinitionFromClasspath() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = processEngine.getRepositoryService() // 与流程定义和部署对象相关的service
                .createDeployment()// 创建一个部署对象
                .name("流程定义")// 添加部署的名称
                .addClasspathResource("diagrams/helloworld.bpmn")// 从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("diagrams/helloworld.png")// 从classpath的资源中加载，一次只能加载一个文件
                .deploy();// 完成部署
        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称:" + deployment.getName());
    }

    /**
     * 部署流程定义 zip
     */
    @Test
    public void deploymentProcessDefinitionFromZip() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/helloworld.zip");
        ZipInputStream zipInputStream = new ZipInputStream(in);
        Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
                .createDeployment()// 创建一个部署对象
                .name("流程定义")// 添加部署
                .addZipInputStream(zipInputStream)// 指定zip格式的文件完成部署
                .deploy();// 完成部署
        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称:" + deployment.getName());

    }

}
