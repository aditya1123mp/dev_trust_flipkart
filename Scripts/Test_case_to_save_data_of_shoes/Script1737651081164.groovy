import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import java.io.FileOutputStream

// Get the current WebDriver
WebDriver driver = DriverFactory.getWebDriver()

// Prepare Excel file
String filePath = "C:\\Users\\DELL\\OneDrive\\Desktop\\ProductsData.xlsx"
XSSFWorkbook workbook = new XSSFWorkbook()
XSSFSheet sheet = workbook.createSheet("Products")

// Create header row
XSSFRow header = sheet.createRow(0)
header.createCell(0).setCellValue("Price (MRP)")
header.createCell(1).setCellValue("Original Price")
header.createCell(2).setCellValue("Discount Offered")

int rowIndex = 1 // Initialize rowIndex

// Function to extract and save data
int extractAndSaveData(WebDriver driver, int rowIndex, XSSFSheet sheet) {
    List<WebElement> productElements = driver.findElements(By.xpath('//a[@class="+tlBoD"]'))
    productElements.eachWithIndex { WebElement productElement, int index ->
        // Use relative XPaths for the current product
        String baseXPath = '(//a[@class="+tlBoD"])[' + (index + 1) + ']'
        String priceXPath = baseXPath + '/div[1]/div[1]'
        String originalPriceXPath = baseXPath + '/div[1]/div[2]'
        String discountXPath = baseXPath + '/div[1]/div[3]'

        // Extract data for the current product
        String price = driver.findElement(By.xpath(priceXPath)).getText()
        String originalPrice
        String discount

        // Check if original price exists
        if (driver.findElements(By.xpath(originalPriceXPath)).size() > 0) {
            originalPrice = driver.findElement(By.xpath(originalPriceXPath)).getText()
        } else {
            originalPrice = "Not available"
        }

        // Check if discount exists
        if (driver.findElements(By.xpath(discountXPath)).size() > 0) {
            discount = driver.findElement(By.xpath(discountXPath)).getText()
        } else {
            discount = "Not available"
        }

        println("Product ${index + 1}: Price (MRP): ${price}, Original Price: ${originalPrice}, Discount: ${discount}")

        // Write data to Excel
        XSSFRow row = sheet.createRow(rowIndex++)
        row.createCell(0).setCellValue(price)
        row.createCell(1).setCellValue(originalPrice)
        row.createCell(2).setCellValue(discount)
    }
    return rowIndex // Return updated rowIndex
}

// Extract data from the first page
rowIndex = extractAndSaveData(driver, rowIndex, sheet)

// Click the "Next" button to go to the second page
WebElement nextButton = driver.findElement(By.xpath('//span[contains(text(),"Next")]'))
if (nextButton.isDisplayed() && nextButton.isEnabled()) {
    nextButton.click()
    WebUI.delay(5) // Wait for the second page to load
}

// Extract data from the second page
rowIndex = extractAndSaveData(driver, rowIndex, sheet)

// Save the Excel file
FileOutputStream outputStream = new FileOutputStream(filePath)
workbook.write(outputStream)
outputStream.close()
workbook.close()

println("Data saved to Excel file: " + filePath)

// Delay for a few seconds
WebUI.delay(5)

// Close browser
WebUI.closeBrowser()

//project
//ADITYA_AGARWAL
//project_for_dev_trust_flipkart