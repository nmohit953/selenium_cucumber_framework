package com.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<String[]> readSheet(String filePath, int sheetIndex) {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            for (Row row : sheet) {
                int last = row.getLastCellNum();
                String[] rowData = new String[last];
                for (int i = 0; i < last; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData[i] = cell.toString();
                }
                data.add(rowData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
