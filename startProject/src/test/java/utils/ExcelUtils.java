package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import java.util.*;
public class ExcelUtils {

	
	public static Object[][] getExcelData(String filePath, String sheetName) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);

                    if (cell == null) {
                        data[i - 1][j] = "";   // blank
                    } else {
                        data[i - 1][j] = cell.getStringCellValue();
                    }
                }
            }
            wb.close();
            return data;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
