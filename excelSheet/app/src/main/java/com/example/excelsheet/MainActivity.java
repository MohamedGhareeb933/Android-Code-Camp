package com.example.excelsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    viewClassAdabter vAdabter;
    ArrayList <viewClass> addView;
    ListView listView;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView_parent);
        addView = new ArrayList<>();

        addView.add(new viewClass(1, 1, 1, 1, 1));
        addView.add(new viewClass(2, 2, 2, 2, 2));
        addView.add(new viewClass(3, 3, 3, 3, 3));

        vAdabter = new viewClassAdabter(this, addView);

        listView.setAdapter(vAdabter);

        Save = findViewById(R.id.button_Save);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExcilFile();
            }
        });

    }


    private void saveExcilFile() {

        //New Workbook
        Workbook wb = new HSSFWorkbook();
        CreationHelper creationHelper = wb.getCreationHelper();

        //Cell style for header row
        CellStyle cs = wb.createCellStyle();
        cs.setFillForegroundColor(HSSFColor.LIME.index);
        cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        //New Sheet
        Sheet sheet1 = null;
        String safeName = WorkbookUtil.createSafeSheetName("match");
        sheet1 = wb.createSheet(safeName);




        /**

           Row row1 = sheet1.createRow(0);

        // r for Row and c for Cell
        Cell r1c0 = row1.createCell(0);
        r1c0.setCellValue("Player Name");
        r1c0.setCellStyle(cs);

        Cell r1c1 = row1.createCell(1);
        r1c1.setCellValue("Points");
        r1c1.setCellStyle(cs);*/

        //LOOP THROUGHT ARRAYLIST SIZE TO DEFINE THE ROWS
        for(short r = 0; r < addView.size() ; r++) {
            // R for row
            Row R = sheet1.createRow(r);

            //  create 5 cells every row
            for (short c = 0; c < 5; c++) {
                // C for Cell
                Cell C = R.createCell(c);

                //PRINT OUT THE ARRAY LIST USING SWITCH
                    switch (c) {
                        case 0:
                            C.setCellValue(vAdabter.getItem(r).getFirst());
                            break;
                        case 1:
                            C.setCellValue(vAdabter.getItem(r).getSecond());
                            break;
                        case 2:
                            C.setCellValue(vAdabter.getItem(r).getThird());
                            break;
                        case 3:
                            C.setCellValue(vAdabter.getItem(r).getFourth());
                            break;
                        case 4:
                            C.setCellValue(vAdabter.getItem(r).getFifth());
                            break;
                    }  // TEST........ again, succeded

            }
        }
        /**
        Row row2 = sheet1.createRow(1);

        Cell r2c1 = row2.createCell(0);
        r2c1.setCellValue(vAdabter.getItem(0).getFirst());

        Cell r2c2 = row2.createCell(1);
        r2c2.setCellValue(vAdabter.getItem(0).getSecond());
         */

        File file = new File(this.getExternalCacheDir(), "text.xls");
        FileOutputStream fileOut = null;


        try {
            fileOut = new FileOutputStream(file);
            wb.write(fileOut);
            Log.w("fileUtitls", "saveExcelFile: " + file);
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (Exception e) {}
        }

    }

}
