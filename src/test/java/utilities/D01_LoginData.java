package utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class D01_LoginData {

	@DataProvider(name = "LoginData")
	public Object[][] getdata() throws IOException {
		String path = ".\\testData\\LoginTestdata.xlsx";
		ExcelUtities xlutil = new ExcelUtities(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getcellcount("Sheet1", 1);

		String LoginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int c = 0; c < totalcols; c++) {
				LoginData[i - 1][c] = xlutil.getcelldata("Sheet1", i, c); // 1,0
			}
		}
		return LoginData; // returning two dimensional Array
		}

	// DataProvider02
	// data pr03

}
