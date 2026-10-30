package practicals;
import java.nio.file.*;
import org.openqa.selenium.*;
public class Practical13_FileUploadDownload {
  public static void main(String[] args) throws Exception {
    Path sample=Paths.get("upload-sample.txt").toAbsolutePath();
    Files.writeString(sample, "STQA Practical 13 file upload demo");
    WebDriver d=Browser.chrome();
    try {
      d.get("https://the-internet.herokuapp.com/upload");
      d.findElement(By.id("file-upload")).sendKeys(sample.toString());
      d.findElement(By.id("file-submit")).click();
      System.out.println("Upload result: "+d.findElement(By.tagName("h3")).getText());
      System.out.println("Uploaded file: "+d.findElement(By.id("uploaded-files")).getText());
      d.get("https://the-internet.herokuapp.com/download");
      System.out.println("Download page opened. Choose a sample file link to download manually.");
      System.out.println("Download directory can be configured in Chrome preferences if automated download is required.");
    } finally { d.quit(); }
  }
}
