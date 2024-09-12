package parameterizationtests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProvider
{
    @Test (groups = "parameterization", dataProvider = "getDataBasics")
    public void doLoginBasics (String username, String password){
        System.out.println(username +"-----" +password);

    }

    @DataProvider
    public Object[][] getDataBasics() {

        Object[][] data = new Object[3][2];

        data[0][0] = "aaaaauser@gmail.com";
        data[0][1] = "11111Aa111111";

        data[1][0] = "bbbbuser@gmail.com";
        data[1][1] = "222222Aa111111";

        data[2][0] = "bbbbbuser@gmail.com";
        data[2][1] = "333333Aa111111";
        return data;
    }

    // Method to read data from Excel and return it as a 2D Object array for DataProvider
    public Object[][] readExcelData(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        // Skip the header row and read data
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString(); // Convert cell to String
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

    // DataProvider to supply data from Excel to the test method
    @DataProvider(name = "excelDataProvider")
    public Object[][] excelDataProvider() throws IOException {
        String excelPath = "C:\\selenium\\book1.xlsx"; // Update this path to the actual file
        return readExcelData(excelPath);
    }

    // Test method with dataProvider
    @Test(groups = "parameterization", dataProvider = "excelDataProvider")
    public void dataParameterizationWithExcell(String email, String password) {
        // Your test logic
        System.out.println(email + " ----- " + password);
    }


}
