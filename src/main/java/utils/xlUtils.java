package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class xlUtils {

	String path;
	String sheetName;

	public xlUtils(String path, String sheetName) {
		this.sheetName = sheetName;
		this.path = path;

	}

	public int getrow() throws EncryptedDocumentException, IOException {

		File file = new File(path);
		FileInputStream f1 = new FileInputStream(file);

		Workbook wk = WorkbookFactory.create(f1);

		Sheet sheet = wk.getSheet(sheetName);

		int row = sheet.getLastRowNum();

		return row;

	}

	public int getcoloumn() throws EncryptedDocumentException, IOException {

		File file = new File(path);
		FileInputStream f1 = new FileInputStream(file);

		Workbook wk = WorkbookFactory.create(f1);

		Sheet sheet = wk.getSheet(sheetName);

		Row rw = sheet.getRow(0);

		int coloum = rw.getLastCellNum();

		return coloum;

	}

	public String getcellValue(int row, int coloum) throws EncryptedDocumentException, IOException {

		File file = new File(path);
		FileInputStream f1 = new FileInputStream(file);

		Workbook wk = WorkbookFactory.create(f1);

		Sheet sheet = wk.getSheet(sheetName);

		Row rw = sheet.getRow(row);
		Cell cell = rw.getCell(coloum);

		String data = "";
		try {

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);

		} catch (Exception e) {

		}

		return data;

	}

}
