package com.xfn.dbLog.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xfn-ac on 16/7/8.
 */
public class FileParser {

    public JSONArray parseExcelToJSONArray(String path) throws IOException {
        FileInputStream fin = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fin);

        HSSFSheet hssfSheet;
        HSSFRow hssfTitleRow;
        HSSFRow hssfRow;
        HSSFCell hssfCell;
        int sheetNum;
        int rowNum;
        int cellNum;

        JSONArray jsonArr = new JSONArray();
        JSONObject json;

        sheetNum = hssfWorkbook.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            hssfSheet = hssfWorkbook.getSheetAt(i);
            rowNum = hssfSheet.getPhysicalNumberOfRows();

            List<String> keys = new ArrayList<>();
            hssfTitleRow = hssfSheet.getRow(0);
            for (int k = 0; k < hssfTitleRow.getPhysicalNumberOfCells(); k++) {
                keys.add(hssfTitleRow.getCell(k).toString());
            }

            for (int j = 1; j < rowNum; j++) {
                hssfRow = hssfSheet.getRow(j);
                cellNum = hssfRow.getPhysicalNumberOfCells();

                json = new JSONObject();
                for (int k = 0; k < cellNum; k++) {
                    hssfCell = hssfRow.getCell(k);
                    hssfCell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    json.put(keys.get(k), hssfCell.getStringCellValue());
                }
                jsonArr.add(json);
            }
        }
        return jsonArr;
    }
}
