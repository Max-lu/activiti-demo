package cn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * Created by max.lu on 2016/3/17.
 */
public class Config {

    /**
     * without xml
     */
    @Test
    public void configWithoutXml() {
        ProcessEngineConfiguration config = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        config.setJdbcDriver("com.mysql.jdbc.Driver");
        config.setJdbcUrl("mysql:jdbc//localhost:3306/activiti1?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8");
        config.setJdbcUsername("root");
        config.setJdbcPassword("root");
        /*
         * DB_SCHEMA_UPDATE_FALSE = "false" 不能自动创建表，需要表存在
         * DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop" 先删除表再创建表
         * DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
         */
        config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = config.buildProcessEngine();
        System.out.println(processEngine);
    }

    /**
     * with xml
     */
    @Test
    public void configWithXml() {
        ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = config.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void configWithDefault() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();//default load the file "activiti.cfg.xml"
        System.out.println(processEngine);
    }
}
