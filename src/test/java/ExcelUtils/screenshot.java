/**
 * 
 */
package ExcelUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.psl.OpenCart.commons.LoggersExample;

/**
 * @author segu_revathi
 *
 */
public class screenshot extends LoggersExample {

	public void takeScreenshot(WebDriver driver)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");

		//to take screenshot
		TakesScreenshot shot1=((TakesScreenshot)driver);
		
		File srcFile=shot1.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		try {
			FileUtils.copyFile(srcFile,new File("ScreenShots\\"+dateFormat.format(date)+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		LoggersExample.logger.info("Took screenshot successfully");
	}
}
