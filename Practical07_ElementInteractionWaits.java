package practicals;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
public class Practical07_ElementInteractionWaits {
  public static void main(String[] args) {
    WebDriver d = Browser.chrome();
    try {
      d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      d.get("https://the-internet.herokuapp.com/checkboxes");
      for (WebElement box : d.findElements(By.cssSelector("input[type=checkbox]"))) {
        if (!box.isSelected()) box.click();
      }
      System.out.println("Checkboxes selected: " + d.findElements(By.cssSelector("input:checked")).size());

      d.get("https://the-internet.herokuapp.com/dropdown");
      new Select(d.findElement(By.id("dropdown"))).selectByVisibleText("Option 2");
      System.out.println("Dropdown selected: " + new Select(d.findElement(By.id("dropdown"))).getFirstSelectedOption().getText());

      d.get("https://the-internet.herokuapp.com/javascript_alerts");
      d.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
      new WebDriverWait(d, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
      System.out.println("Alert accepted.");

      d.get("https://the-internet.herokuapp.com/iframe");
      new WebDriverWait(d, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
      System.out.println("Frame text: " + d.findElement(By.id("tinymce")).getText());
      d.switchTo().defaultContent();
    } finally { d.quit(); }
  }
}
