package com.sp.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readExcelByPoi {
    public static Object[][] readExcelData(String filepath) throws InvalidFormatException, IOException {

//        String filepath = "/Users/yebeibei/Documents/rocket/AutoTest/selen/data/test.xlsx";
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = filepath.substring(filepath.indexOf("."));
        if (fileExtensionName.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xsl")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
        List<Object[]> records = new ArrayList<Object[]>();
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            String fields[] = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                fields[j] = row.getCell(j).getStringCellValue();
            }
            records.add(fields);
        }
        Object[][] results = new Object[records.size()][];
        for (int k = 0; k < records.size(); k++) {
            results[k] = records.get(k);
            System.out.println(results[k]);
        }


        return results;
    }
}
