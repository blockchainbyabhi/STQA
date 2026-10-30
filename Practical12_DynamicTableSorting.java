package practicals;
import java.util.*;
import org.openqa.selenium.*;
public class Practical12_DynamicTableSorting {
  public static void main(String[] args) {
    WebDriver d=Browser.chrome();
    try {
      d.get("https://the-internet.herokuapp.com/tables");
      List<String> before=new ArrayList<>();
      for(WebElement r:d.findElements(By.cssSelector("#table1 tbody tr")))
        before.add(r.findElements(By.tagName("td")).get(0).getText());
      d.findElement(By.cssSelector("#table1 th:nth-child(1)")).click();
      List<String> after=new ArrayList<>();
      for(WebElement r:d.findElements(By.cssSelector("#table1 tbody tr")))
        after.add(r.findElements(By.tagName("td")).get(0).getText());
      List<String> sorted=new ArrayList<>(after); Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
      System.out.println("Before: "+before);
      System.out.println("After click: "+after);
      System.out.println("Sorted ascending validation: "+after.equals(sorted));
    } finally { d.quit(); }
  }
}
