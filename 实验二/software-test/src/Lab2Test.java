import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Lab2Test {

	private WebDriver driver;
    private String baseUrl;
    private XSSFSheet sheet;
    private DecimalFormat df = new DecimalFormat("0");

    public Lab2Test() {
    }

    @Before
    public void setUp() throws Exception {
        String driverPath = System.getProperty("user.dir") + "/src/driver/geckodriver";
        System.setProperty("webdriver.gecko.driver", driverPath);
        this.driver = new FirefoxDriver();
        this.baseUrl = "http://121.193.130.195:8800/login";
        this.driver.manage().timeouts().implicitlyWait(30000L, TimeUnit.SECONDS);
        XSSFWorkbook workbook = new XSSFWorkbook("软件测试名单.xlsx");
        this.sheet = workbook.getSheetAt(0);
    }

    @Test
    public void test() throws Exception {
        this.driver.get(this.baseUrl + "/");

        for(int row_idx = 2; row_idx < this.sheet.getPhysicalNumberOfRows(); ++row_idx) {
            XSSFRow row = this.sheet.getRow(row_idx);
            String username = this.df.format(row.getCell(1).getNumericCellValue());
            String password = username.substring(username.length() - 6, username.length());
            String address = row.getCell(3).toString();
            this.driver.findElement(By.name("id")).sendKeys(new CharSequence[]{username});
            this.driver.findElement(By.name("password")).sendKeys(new CharSequence[]{password});
            this.driver.findElement(By.id("btn_login")).sendKeys(new CharSequence[]{Keys.ENTER});
            String student_git = this.driver.findElement(By.id("student-git")).getText().toString();
            this.driver.findElement(By.id("btn_logout")).sendKeys(new CharSequence[]{Keys.ENTER});
            this.driver.findElement(By.id("btn_return")).sendKeys(new CharSequence[]{Keys.ENTER});
            Assert.assertEquals(address, student_git);
        }

    }
}
