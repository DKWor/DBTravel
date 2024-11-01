package utils;

// Import necessary classes for file handling and Apache POI library for Excel operations
import java.io.File; // For handling file operations
import java.io.IOException; // For handling IO exceptions
import java.util.ArrayList; // For using dynamic arrays (lists)
import java.util.LinkedHashMap; // For maintaining insertion order in maps
import java.util.List; // For using lists
import java.util.Map; // For using maps
import org.apache.poi.openxml4j.exceptions.InvalidFormatException; // For handling invalid format exceptions in Excel files
import org.apache.poi.ss.usermodel.*; // For working with Excel Workbook, Sheet, Row, and Cell classes
import org.apache.poi.ss.util.NumberToTextConverter; // For converting numeric values in Excel to text


public class ExcelReader {

    // Retrieve data from the Excel sheet by sheet name
    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    // Retrieve data from the Excel sheet by sheet index
    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    // Get the sheet by name
    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException {
        return getWorkBook(excelFilePath).getSheet(sheetName);
    }

    // Get the sheet by index
    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException {
        return getWorkBook(excelFilePath).getSheetAt(sheetNumber);
    }

    // Create and return the workbook from the given Excel file path
    private Workbook getWorkBook(String excelFilePath) throws IOException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    // Read data from the sheet and return as a list of maps
    private List<Map<String, String>> readSheet(Sheet sheet) {
        List<Map<String, String>> excelRows = new ArrayList<>();
        int totalRows = sheet.getPhysicalNumberOfRows();
        int headerRowNumber = getHeaderRowNumber(sheet);

        if (headerRowNumber != -1) {
            int totalColumns = sheet.getRow(headerRowNumber).getLastCellNum();
            for (int currentRow = 1; currentRow <= totalRows; currentRow++) {
                Row row = sheet.getRow(currentRow);
                Map<String, String> rowData = new LinkedHashMap<>();
                for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++) {
                    rowData.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(rowData);
            }
        }
        return excelRows;
    }

    // Get the header row number
    private int getHeaderRowNumber(Sheet sheet) {
        int totalRows = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRows; currentRow++) {
            Row row = sheet.getRow(currentRow);
            if (row != null) {
                for (Cell cell : row) {
                    if (cell.getCellType() != CellType.BLANK) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return -1;
    }

    // Get value from a particular cell
    private Map<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        Map<String, String> columnData = new LinkedHashMap<>();
        String headerName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();

        if (row == null) {
            columnData.put(headerName, "");
            return columnData;
        }

        Cell cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        switch (cell.getCellType()) {
            case STRING:
                columnData.put(headerName, cell.getStringCellValue());
                break;
            case NUMERIC:
                columnData.put(headerName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                break;
            case BOOLEAN:
                columnData.put(headerName, Boolean.toString(cell.getBooleanCellValue()));
                break;
            case ERROR:
                columnData.put(headerName, Byte.toString(cell.getErrorCellValue()));
                break;
            default:
                columnData.put(headerName, "");
                break;
        }

        return columnData;
    }
}
