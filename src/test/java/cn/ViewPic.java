package cn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by max.lu on 2016/3/17.
 */
public class ViewPic {
    @Test
    public void viewPic() throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String deploymentId = "25001";
        List<String> names = processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
        String resourceName= "";
        if (names != null && !names.isEmpty()) {
            for (String name : names) {
                if (name.endsWith(".png")) {
                    resourceName = name;
                    break;
                }
            }
        }
        InputStream inputStream = processEngine.getRepositoryService().getResourceAsStream(deploymentId, resourceName);
        File file = new File("E:/test/" + resourceName);
        FileUtils.copyInputStreamToFile(inputStream, file);
    }
}
