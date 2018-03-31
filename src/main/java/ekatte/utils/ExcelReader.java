package ekatte.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;

public class ExcelReader {
    public String readExcelFile(String fileName){

        String data = "";
        String path = String.format("C:\\Users\\onehu\\Desktop\\EKATTE\\java\\src\\main\\resources\\static\\excel\\%s.xls", fileName);

        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(path));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for(int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if(row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if(row != null) {
                    for(int c = 0; c < cols; c++) {
                        cell = row.getCell(c);
                        if(cell != null) {
                            data += cell + "@@";
                        }
                    }
                    data += "\n";
                }
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }

        return data;
    };
}
