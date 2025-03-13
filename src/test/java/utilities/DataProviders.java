package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException
    {
        String path="./testData/OpenCart_Logindata.xlsx";//taking xl file from testData

        ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
            for(int j=0;j<totalcols;j++)  //0    i is rows j is col
            {
                logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata;//returning two dimension array

    }

    //DataProvider 2
    @DataProvider(name="searchdata")
    public String [][] getSearchData() throws IOException
    {
        String path="./testData/OpenCart_Logindata.xlsx";//taking xl file from testData

        ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet2");
        int totalcols=xlutil.getCellCount("Sheet2",1);

        String logindata[][] = new String[totalrows][totalcols]; // One-dimensional array for one column

        /*for (int i = 1; i <= totalrows; i++) {  // Loop through rows
            logindata[i - 1] = xlutil.getCellData("Sheet2", i, 0); // Store only first column data
        }*/
        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
            for(int j=0;j<totalcols;j++)  //0    i is rows j is col
            {
                logindata[i-1][j]= xlutil.getCellData("Sheet2",i, j);  //1,0
            }
        }
        return logindata; // Returning one-dimensional array
    }

    //DataProvider 3

    //DataProvider 4
}
