package practicals;
import java.nio.file.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
public class Practical14_ScreenshotAndLogging {
  private static final Logger log=LogManager.getLogger(Practical14_ScreenshotAndLogging.class);
  public static void main(String[] args) {
    WebDriver d=Browser.chrome();
    try {
      d.get("https://the-internet.herokuapp.com/");
      log.info("Opened demo website: {}", d.getCurrentUrl());
      d.findElement(By.linkText("Broken Images")).click();
      log.info("Opened Broken Images page.");
      throw new RuntimeException("Intentional demo failure to demonstrate screenshot capture");
    } catch(Exception e) {
      log.error("Test failed; capturing screenshot.",e);
      try {
        byte[] shot=((TakesScreenshot)d).getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("Practical14-failure.png"),shot);
        log.info("Screenshot saved as Practical14-failure.png");
      } catch(Exception screenshotError) { log.error("Screenshot capture failed.",screenshotError); }
    } finally { d.quit(); }
  }
}
