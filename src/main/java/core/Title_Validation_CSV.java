package core;

// BEGIN
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class Title_Validation_CSV {
	public static void main(String[] args) throws IOException {
		
			
		String csvFile = "./src/main/resources/Test.csv";
		BufferedReader br = null;
		String line = null;
		String csvSplitBy = ",";
		String text_case_id = null;
		String url = null;
		String title_expected = null;
		
		br = new BufferedReader(new FileReader(csvFile));
		WebDriver driver = new FirefoxDriver(); // Version 1.1 :: Firefox
		
		while((line = br.readLine()) != null)  {
			
			String[] csv = line.split(csvSplitBy);
			text_case_id = csv[0];
			url = csv[1];
			title_expected = csv[2];
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
	
			System.out.println("");
			if (title_expected.equals(title_actual)) {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			} else {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
				}
			}
			driver.quit();
			br.close();
		}
	}

// END