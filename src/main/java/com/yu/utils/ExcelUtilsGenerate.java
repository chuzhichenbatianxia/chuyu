package com.yu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import com.yu.entity.School;

/**
 * 
 * @author 朱玉平
 * @excell 导入导出表
 */
public class ExcelUtilsGenerate {
	
	
	/**
	 * 
	 * @param schoolList
	 * 学校集合
	 * @param excelName
	 * excel 文件名
	 * @return
	 */
	public static HSSFWorkbook generateWorkbookForScholl(List<School> schoolList,String excelName){
		
		HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
		HSSFSheet hssfSheet=hssfWorkbook.createSheet(excelName);
		HSSFRow hssfRow=hssfSheet.createRow(0);
		HSSFCell hssfCell=null;
		//模拟的字段名
		List<String> titleList=new LinkedList<>();
		titleList.add("镇区");
		titleList.add("代理商");
		titleList.add("学校");
		titleList.add("学校ID");
		titleList.add("班级");
		titleList.add("姓名");
		titleList.add("学生ID");
		titleList.add("家长ID");
		titleList.add("是否本地");
		titleList.add("是否镇区");
		titleList.add("业务名称");
		//遍历字段名
        for (int i=0;i<titleList.size();i++){
            hssfCell=hssfRow.createCell(i);
            hssfCell.setCellType(HSSFCell.ENCODING_UTF_16);
            hssfCell.setCellValue(titleList.get(i));
        }
        //遍历集合数据
        for(int i=0;i<schoolList.size();i++)
        {
            hssfRow=hssfSheet.createRow(i+1);
            for(int j=0;j<titleList.size();j++){
                hssfCell=hssfRow.createCell(j);
                hssfCell.setCellType(HSSFCell.ENCODING_UTF_16);
                switch (j){
                    case 0:
                        hssfCell.setCellValue(schoolList.get(i).getTown());
                        break;
                    case 1:
                        hssfCell.setCellValue(schoolList.get(i).getFactor());
                        break;
                    case 2:
                        hssfCell.setCellValue(schoolList.get(i).getSchool());
                        break;
                    case 3:
                        hssfCell.setCellValue(schoolList.get(i).getSchoolId());
                        break;    
                    case 4:
                        hssfCell.setCellValue(schoolList.get(i).getClas());
                        break;
                    case 5:
                        hssfCell.setCellValue(schoolList.get(i).getStudentName());
                        break;
                    case 6:
                        hssfCell.setCellValue(schoolList.get(i).getStudentId());
                        break;
                    case 7:
                        hssfCell.setCellValue(schoolList.get(i).getParentsId());
                        break;
                    case 8:
                    	if (schoolList.get(i).getLocalIs()==0) {
                    		hssfCell.setCellValue("是");
						} else {
							hssfCell.setCellValue("否");
						}
                        break;
                    case 9:
                    	if (schoolList.get(i).getTownIs()==0) {
                    		hssfCell.setCellValue("是");
						} else {
							hssfCell.setCellValue("否");
						}
                        
                        break;
                    case 10:
                        hssfCell.setCellValue(schoolList.get(i).getBusinessName());
                        break;
                    default:
                        break;
                }

            }
        }
        hssfSheet.setColumnWidth(0,12 * 256);
        hssfSheet.setColumnWidth(1,25 * 256);
        hssfSheet.setColumnWidth(2,12 * 256);
        hssfSheet.setColumnWidth(3,12 * 256);
        hssfSheet.setColumnWidth(4,12 * 256);
        hssfSheet.setColumnWidth(5,12 * 256);
        hssfSheet.setColumnWidth(6,12 * 256);
        hssfSheet.setColumnWidth(7,12 * 256);
        hssfSheet.setColumnWidth(8,12 * 256);
        hssfSheet.setColumnWidth(9,12 * 256);
        hssfSheet.setColumnWidth(10,12 * 256);
        
		return hssfWorkbook;
		
	}
	
	//根据Excel文件获取列表
	public static List<School> loadShool(MultipartFile file) throws IOException{
		
		List<School> temp=new ArrayList<>();
		InputStream fileIn = file.getInputStream();
		//根据指定的文件输入流导入Excel从而产生Workbook对象
		HSSFWorkbook wb0 = new HSSFWorkbook(fileIn);
		//获取Excel文档中的第一个表单
		HSSFSheet sht0 = wb0.getSheetAt(0);
		//对Sheet中的每一行进行迭代
		for (Row r : sht0) {
		//弟一行不是数据不需要添加到School中
		if(r.getRowNum()<1){
		continue;
		}
		//创建实体类
		School school=new School();
		//取出当前行第1个单元格数据，并封装在info实体stuName属性上
		school.setTown(r.getCell(0).getStringCellValue());
		school.setFactor(r.getCell(1).getStringCellValue());
		school.setSchool(r.getCell(2).getStringCellValue());
		school.setSchoolId(r.getCell(3).getStringCellValue());
		school.setClas(r.getCell(4).getStringCellValue());
		school.setStudentName(r.getCell(5).getStringCellValue());
		school.setStudentId(r.getCell(6).getStringCellValue());
		school.setParentsId(r.getCell(7).getStringCellValue());
		if (r.getCell(8).getStringCellValue().equals("是")) {
			school.setLocalIs(0);
		} else {
			school.setLocalIs(1);
		}
		
		if (r.getCell(9).getStringCellValue().equals("是")) {
			school.setTownIs(0);
		} else {
			school.setTownIs(1);
		}
		school.setBusinessName(r.getCell(10).getStringCellValue());
//		info.setLscore(r.getCell(3).getNumericCellValue());
		temp.add(school);
		        }
		        fileIn.close();    
		        return temp;    
		    }
}
