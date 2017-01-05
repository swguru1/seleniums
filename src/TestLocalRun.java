




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;

public class TestLocalRun {
    private WebDriver driver;
 

   
   
     @BeforeTest
     public void setUp() {
    	 System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
    	 driver = new ChromeDriver();
      
       driver.get("http://www.google.com");
     }
     

     @Test
     public void testGoogleSearch() {	 
    		   
    		 driver.get("http://www.google.com"); 
    		 Assert.assertEquals("Google",driver.getTitle());
      
     }
     @AfterTest 
     public void tearDown() {
    	 driver.close();
         driver.quit();
     }
   
}
