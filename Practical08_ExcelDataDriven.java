package practicals;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
public class Practical08_ExcelDataDriven {
  public static void main(String[] args) throws Exception {
    File file = new File("StudentData.xlsx");
    try (FileInputStream in = new FileInputStream(file); XSSFWorkbook wb = new XSSFWorkbook(in)) {
      Sheet sheet = wb.getSheetAt(0);
      WebDriver d = Browser.chrome();
      try {
        for (int i=1; i<=sheet.getLastRowNum(); i++) {
          Row row = sheet.getRow(i); if (row == null) continue;
          String id = row.getCell(0).toString();
          String name = row.getCell(1).toString();
          String marks = row.getCell(2).toString();
          d.get("https://the-internet.herokuapp.com/inputs");
          WebElement input = d.findElement(By.tagName("input"));
          input.sendKeys(marks.replaceAll("\\.0$", ""));
          String actual = input.getAttribute("value");
          Cell result = row.getCell(3);
          if (result == null) result = row.createCell(3);
          result.setCellValue(actual.equals(marks.replaceAll("\\.0$", "")) ? "PASSED" : "FAILED");
          System.out.println(id + " | " + name + " | " + result.getStringCellValue());
        }
      } finally { d.quit(); }
      try (FileOutputStream out = new FileOutputStream(file)) { wb.write(out); }
      System.out.println("Excel updated: " + file.getAbsolutePath());
    }
  }
}
