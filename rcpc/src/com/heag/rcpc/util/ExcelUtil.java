package com.heag.rcpc.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.struts2.ServletActionContext;

import com.sun.tools.doclets.formats.html.AllClassesFrameWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-6-19 0019.
 */
public class ExcelUtil {
    private static String sheetName = "data";

    private HSSFWorkbook wb;

    private HSSFSheet sheet;

    private HSSFRow row;

    private HSSFCell cell;

    private HSSFFont font;

    private HSSFCellStyle cellStyle;

    private FileOutputStream fileOut;

    public ExcelUtil() {
        wb = new HSSFWorkbook();
        sheet=wb.createSheet(ExcelUtil.sheetName);
    }

    /**
     * @param excelName
     *            excel名称。
     * @param list
     *            这个list里面存放的是对象数组。数组元素可以转化为字符串显示的。这个对象数组一般对应数据库里的几列。
     * @param firstRowValue
     */
    public void outputExcel(String excelName, List list, String[] firstRowValue) {
        try {
            this.createSheet(firstRowValue);
            this.setValueToRow(excelName, list);
        } catch (Exception ex) {
            System.out.print(ex);
        }
        // System.out.println("文件名是:" + excelName);
        downloadFile(excelName);
    }

    public void outputExcel(String excelName, List list) {
        try {
            System.out.println("list.size(),outputExcel：" + list.size());
            this.setValueToRow(excelName, list);
        } catch (Exception e) {
        }
        downloadFile(excelName);
    }

    private void setValueToRow(String excelName, List list) {

        // 获得JSF上下文环境
        // FacesContext context = FacesContext.getCurrentInstance();
        // 获得ServletContext对象
        // ServletContext servletContext = (ServletContext) context
        //   .getExternalContext().getContext();
        // 取得文件的绝对路径
        ServletContext servletContext= ServletActionContext.getServletContext();
        excelName = servletContext.getRealPath("/UploadFile") + "/" + excelName;
        System.out.println("生成文件的路径是：" + excelName);
        Object[] obj;
        try {
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 1);
                if (list.get(i) instanceof Map){
                	Map<String,String> m = (Map<String,String>) list.get(i);
                	ArrayList<Object> al  = new ArrayList<Object>();
                	for(String key : m.keySet())  {
                		//String value = m.get(key).toString();
                		if("qid".equals(key)){
                			continue;
                		}
                		al.add( m.get(key));
					}
                	obj =al.toArray();
                }else{
                	obj = (Object[]) list.get(i);
                }

                this.createCell(row, obj);
            }
            fileOut = new FileOutputStream(excelName);
            wb.write(fileOut);

        } catch (Exception ex) {
            System.out.print("生成报表有误:" + ex);
        } finally {
            try {
                fileOut.flush();
                fileOut.close();
            } catch (Exception e) {
                System.out.println("ExcelUtil.setValueToRow()");
            }
        }
    }

    private void createSheet(String[] firstRowValue) {
        try {
            int length=firstRowValue.length-1;
            row = sheet.createRow(0);
            //font = wb.createFont();
            //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //cellStyle = wb.createCellStyle();
            //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
            //cellStyle.setFont(font);
            createCell(row,firstRowValue);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    private void createCell(HSSFRow row, Object[] obj) {
        try {
            for (int i = 0; i < obj.length; i++) {
                cell = row.createCell((short) i);
                //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                cell.setCellValue(obj[i].toString());
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    /**
     * <p>
     * 功能说明：根据提供的文件名下载文件,不支持中文文件名
     * </p>
     * 实现文件生成后的下载
     *
     * @param strfileName
     *            String
     * @return void
     */
    private static void downloadFile(String strfileName) {
        try {

            // 取得文件的绝对路径
            ServletContext servletContext =ServletActionContext.getServletContext();
            String excelName = servletContext.getRealPath("/UploadFile") + "/" + strfileName;
            File exportFile = new File(excelName);
            // HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
            //.getCurrentInstance().getExternalContext().getResponse();
            HttpServletResponse httpServletResponse =ServletActionContext.getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            // httpServletResponse.setHeader("Content-disposition",
            // "attachment; filename=" + strfileName);
            httpServletResponse.setHeader("Content-disposition","attachment; filename=" + strfileName);
            httpServletResponse.setContentLength((int) exportFile.length());
            httpServletResponse.setContentType("application/x-download");
            // httpServletResponse.setContentType("application/vnd.ms-excel");

            byte[] b = new byte[1024];
            int i = 0;
            FileInputStream fis = new java.io.FileInputStream(exportFile);
            while ((i = fis.read(b)) > 0) {
                servletOutputStream.write(b, 0, i);
            }
            fis.close();
            servletOutputStream.close();
            System.out.println("excelName:"+excelName);
            File file =new File(excelName);
            boolean bl=file.delete();
            System.out.println("file delete over?,"+bl);
            System.out.println("delete file over!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
