package practicals;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class Practical10_DropdownVerification {
  public static void main(String[] args) {
    WebDriver d=Browser.chrome();
    try {
      d.get("https://the-internet.herokuapp.com/dropdown");
      Select s=new Select(d.findElement(By.id("dropdown")));
      System.out.println("Total options: "+s.getOptions().size());
      System.out.println("Default: "+s.getFirstSelectedOption().getText());
      s.selectByVisibleText("Option 1");
      System.out.println("Selected after test: "+s.getFirstSelectedOption().getText());
      s.selectByVisibleText("Option 2");
      System.out.println("Selected after test: "+s.getFirstSelectedOption().getText());
    } finally { d.quit(); }
  }
}
