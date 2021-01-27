package com.example.wbtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Workbook wb = new HSSFWorkbook();
        CreationHelper creationHelper = wb.getCreationHelper();
        Sheet sheet1 = wb.createSheet("new Sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet1.createRow(0);

        //Create a Cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        // on line code.
        row.createCell(1).setCellValue(1.2f);
        row.createCell(2).setCellValue(creationHelper.createRichTextString("this is a String"));
        row.createCell(3).setCellValue(true);


        // Create a SafeName for Sheet
        String safeName = WorkbookUtil.createSafeSheetName("[Illegal Name ?@]"); // name of the xls sheet
        Sheet sheet3 = wb.createSheet(safeName);


        File file = new File(this.getExternalCacheDir(), "test.xls");
        FileOutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream(file);
            wb.write(fileOut);
            Log.w("FileUtils", "Writing file" + file);
            fileOut.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (Exception ex) {}
        }


    }
}
