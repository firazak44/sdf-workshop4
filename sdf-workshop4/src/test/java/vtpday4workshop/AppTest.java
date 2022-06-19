package vtpday4workshop;

import vtpday4workshop.server.fortunecookie;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCookie() {
        String randomCookie = fortunecookie
          .getRandomCookie("/Users/skyho/OneDrive/Documents/VISAJava/Sdf-Workshop4/sdf-workshop4/cookie_file.txt");
        Assert.assertNull(randomCookie);
      }
      
      @BeforeTest
      public void beforeTest() {
      }
    
      @AfterTest
      public void afterTest() {
    
      }
}
