package practicals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Practical06_LoginAutomation {
  public static void main(String[] args) {
    WebDriver driver = Browser.chrome();
    try {
      driver.get("https://the-internet.herokuapp.com/login");
      driver.findElement(By.id("username")).sendKeys("tomsmith");
      driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
      driver.findElement(By.cssSelector("button[type='submit']")).click();
      String message = driver.findElement(By.id("flash")).getText();
      boolean success = driver.getCurrentUrl().contains("/secure")
          && message.contains("You logged into a secure area!")
          && driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed();
      System.out.println("Login validation: " + (success ? "PASS" : "FAIL"));
      System.out.println("Message: " + message);
    } finally { driver.quit(); }
  }
}
