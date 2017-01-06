

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Invalidloginjava {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","./lib/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testInvalidloginjava() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("invalidUN");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("invalidUN");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("invalidPW");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("invalidPW");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.name("login")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
