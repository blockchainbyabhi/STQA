package practicals;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Practical05_GridRemoteExecution {
  public static void main(String[] args) throws Exception {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
    try {
      driver.get("https://the-internet.herokuapp.com/");
      System.out.println("Remote browser title: " + driver.getTitle());
      driver.findElement(By.linkText("Form Authentication")).click();
      System.out.println("Remote URL: " + driver.getCurrentUrl());
    } finally { driver.quit(); }
  }
}
