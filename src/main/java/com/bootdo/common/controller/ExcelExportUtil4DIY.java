package com.bootdo.common.controller;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xuxueli.poi.excel.ExcelExportUtil;

public class ExcelExportUtil4DIY extends ExcelExportUtil{
    private static Logger logger = LoggerFactory.getLogger(ExcelExportUtil.class);
    /**
     * 导出Excel文件到磁盘
     * @param dataList
     * @param outputStream
     */
    public static void exportToFile(List<?> dataList, OutputStream outputStream){
        // workbook
        Workbook workbook = exportWorkbook(dataList);
        try {
            // workbook 2 FileOutputStream
            workbook.write(outputStream);
            // flush
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream!=null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }
}
