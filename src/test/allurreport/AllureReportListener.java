package allurreport;

import org.testng.IExecutionListener;

import java.io.IOException;
import java.util.Map;

public class AllureReportListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        // No action needed on start
    }

    @Override
    public void onExecutionFinish() {
        // Path to the Allure results directory
        String resultsDir = "C:\\Github\\Java\\JavaBasics\\SeleniumPractice\\allure-results";
        // Path to the Java installation
        String javaHome = "C:\\Program Files\\Java\\jdk-18.0.1.1";

        // Serve the Allure report
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("allure", "serve", resultsDir);
            Map<String, String> environment = processBuilder.environment();
            environment.put("JAVA_HOME", javaHome);
            environment.put("PATH", environment.get("PATH") + ";" + javaHome + "\\bin");
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Allure report served successfully.");
            } else {
                System.err.println("Allure report serving failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}