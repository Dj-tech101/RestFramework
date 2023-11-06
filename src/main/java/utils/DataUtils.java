package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class DataUtils {

	String path;
	String sheetName;

	public DataUtils(String path, String sheetName) {

		this.path = path;
		this.sheetName = sheetName;

	}

	public static String[][] dataContainer(String path, String sheetname)
			throws EncryptedDocumentException, IOException {

		File f1 = new File(path);

		@SuppressWarnings("unused")
		FileInputStream file = new FileInputStream(f1);

		xlUtils read = new xlUtils(path, sheetname);

		int row = read.getrow();
		int col = read.getcoloumn();

	//	System.out.println("row " + row);
	//	System.out.println("coloum" + col);

		String[][] data = new String[row][col];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				data[i - 1][j] = read.getcellValue(i, j);
			}

		}
		return data;

	}
}
