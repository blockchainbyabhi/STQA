package practicals;
/*
 * Selenium RC (Remote Control) was discontinued many years ago.
 * This is a modern WebDriver equivalent demonstrating browser automation.
 * It does NOT install or run the historical Selenium RC server.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Practical04_SeleniumRCModernEquivalent {
  public static void main(String[] args) {
    WebDriver driver = Browser.chrome();
    try {
      driver.get("https://the-internet.herokuapp.com/");
      System.out.println("Page title: " + driver.getTitle());
      driver.findElement(By.linkText("Form Authentication")).click();
      System.out.println("Opened login page: " + driver.getCurrentUrl());
    } finally { driver.quit(); }
  }
}
