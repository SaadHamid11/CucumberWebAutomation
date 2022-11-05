package apphooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
private DriverFactory driverFactory;
private WebDriver driver;
private ConfigReader configReader;
private Properties properties;


@Before(value = "@skip_scenario", order=0)
public void skipScenarion(Scenario scenario){
    System.out.println("Skipped Scenario: "+scenario.getName());
    Assume.assumeTrue(false);
}
@Before(order=1)
    public void getProperty(){
    configReader = new ConfigReader();
    properties = configReader.initializeProperties();
}

@Before(order = 2)
    public void launchBrowser(){
    String browser = properties.getProperty("browser");

    driverFactory = new DriverFactory();
    driver = driverFactory.initializeDriver(browser);
}

@After(order = 0)
    public void quitBrowser(){
    if(driver!=null){
        driver.quit();
    }
}

@After(order = 1)
    public void tearDown(Scenario scenario){
    if(scenario.isFailed()){
        //Take screenshot
        String screenshotName = scenario.getName().replaceAll(" ","_");
        byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath,"image/png", screenshotName);

    }

}
}
