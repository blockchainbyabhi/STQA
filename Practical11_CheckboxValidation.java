package practicals;
import java.util.List;
import org.openqa.selenium.*;
public class Practical11_CheckboxValidation {
  public static void main(String[] args) {
    WebDriver d=Browser.chrome();
    try {
      d.get("https://the-internet.herokuapp.com/checkboxes");
      List<WebElement> boxes=d.findElements(By.cssSelector("input[type=checkbox]"));
      int checked=0;
      for(WebElement b:boxes) if(b.isSelected()) checked++;
      System.out.println("Total: "+boxes.size()+", Checked: "+checked+", Unchecked: "+(boxes.size()-checked));
      for(WebElement b:boxes) if(!b.isSelected()) b.click();
      int after=0; for(WebElement b:boxes) if(b.isSelected()) after++;
      System.out.println("Checked after selecting all: "+after);
    } finally { d.quit(); }
  }
}
