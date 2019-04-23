//import com.microsoft.schemas.office.visio.x2012.main.CellType;
//import org.apache.poi.ss.format.CellFormatType;
//import org.apache.poi.ss.formula.functions.T;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class AddNewCustomersExcelDataDrivenTest {
//    public static ArrayList<String> dataDriven() throws FileNotFoundException {
//        return getTestData("Purchase");
//    }
//
//    public static ArrayList<String> getTestData(String testCaseName) throws FileNotFoundException {
//        FileInputStream file = new FileInputStream("D:\\Elena\\project1\\demodata.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        ArrayList<String> excelValueArray = new ArrayList<>();
//        try {
//            int sheetCount = workbook.getNumberOfSheets(); //check number of sheets
//
//            for (int i = 0; i < sheetCount; i++) {
//                if (workbook.getSheetName(i).equalsIgnoreCase("test1")) {
//                    XSSFSheet sheet = workbook.getSheetAt(i);
//                    Iterator<Row> rows = sheet.iterator();
//                    Row firstRow = rows.next();
//                    Iterator<Cell> cell = firstRow.cellIterator();
//                    int columnIndex = 0;
//                    while (cell.hasNext()) {
//                        Cell value = cell.next();
//                        if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
//                            break;
//                        }
//                        columnIndex++;
//                    }
//                    while (rows.hasNext()) {
//                        Row rowValue = rows.next();
//                        if (rowValue.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testCaseName)) {
//                            Iterator<Cell> cellIterator = rowValue.cellIterator();
//                            while (cellIterator.hasNext()) {
//                                Cell nextCell = cellIterator.next();
//                                switch (nextCell.getCellType()) {
//                                    case Cell.CELL_TYPE_STRING:
//                                        excelValueArray.add(cellIterator.next().getStringCellValue());
//                                        break;
//                                    case Cell.CELL_TYPE_NUMERIC:
//                                        excelValueArray.add(String.valueOf(cellIterator.next().getNumericCellValue()));
//                                        break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return excelValueArray;
//    }
//}
