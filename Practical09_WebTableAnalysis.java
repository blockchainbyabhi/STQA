package practicals;
import java.util.*;
import org.openqa.selenium.*;
public class Practical09_WebTableAnalysis {
  public static void main(String[] args) {
    WebDriver d = Browser.chrome();
    try {
      d.get("https://the-internet.herokuapp.com/tables");
      List<WebElement> rows = d.findElements(By.cssSelector("#table1 tbody tr"));
      int qualifying=0;
      System.out.println("Rows found: " + rows.size());
      for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        String name = cells.get(0).getText() + " " + cells.get(1).getText();
        String due = cells.get(3).getText().replace("$","").trim();
        double amount = Double.parseDouble(due);
        System.out.println(name + " | Due: " + amount);
        if (amount > 60) qualifying++;
      }
      System.out.printf("Above 60: %d (%.2f%%)%n", qualifying, 100.0*qualifying/rows.size());
    } finally { d.quit(); }
  }
}
