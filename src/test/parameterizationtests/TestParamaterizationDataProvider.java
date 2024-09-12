package parameterizationtests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class TestParamaterizationDataProvider
{
    @Test (dataProvider = "getDataParamParralel")
    public void doLoginBasics (String browserName) throws InterruptedException{
        Date date = new Date();

        System.out.println("Browser Name: " + browserName +"---" +date);
        Thread.sleep(4000);

    }

    @DataProvider(parallel=true)
    public Object[][] getDataParamParralel() throws InterruptedException {
        Object[][] data = new Object[2][1];
        data[0][0] = "chrome";

        data[1][0] = "firefox";

        return data;
    }




}
