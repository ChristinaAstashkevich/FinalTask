package driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.PropertyProvider;

import java.util.concurrent.TimeUnit;


public class LocalDriverStategy {

    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String GECKODRIVER_EXE_PATH = ".\\geckodriver\\geckodriver.exe";
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_EXE_PATH = ".\\chromedriver\\chromedriver.exe";
    private static final Logger log = LogManager.getRootLogger();
    private static WebDriver driver;
    //private String browser = "chrome";

    public LocalDriverStategy(){

    }

    private static WebDriver getActualDriver() {

        BrowserType type = BrowserType.valueOf(PropertyProvider.getProperty("browser"));

        switch (type) {
            case CHROME:
                driver = createChromeDriver();
                log.info("chrome driver has created");
                break;
           /* case FIREFOX:
                driver = createFirefoxDriver();
                log.info("firefox driver has created");
                break;*/
            default:
                driver = createChromeDriver();
                log.info("chrome driver has created");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return driver;
    }


    public static WebDriver getInstance() {
        if (driver == null) {
            getActualDriver();
            driver.navigate().to("https://gmail.com ");
        }
        return driver;
    }

    public static void close() {
        if (null != driver) {
            driver.close();
        }
        driver = null;
    }

    @Contract(" -> !null")
    private static WebDriver createFirefoxDriver() {
        System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_EXE_PATH);
        return new FirefoxDriver();
    }

    @Contract(" -> !null")
    private static WebDriver createChromeDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_EXE_PATH);
        return new ChromeDriver();
    }
}
