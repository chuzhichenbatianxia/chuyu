package com.yu.controler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yu.entity.School;
import com.yu.service.SchoolService;
import com.yu.utils.ExcelUtilsGenerate;

/**
 * 
 * @author Administrator
 *	Excell导入导出
 */
@Controller
@RequestMapping("/scholl")
public class SchoolController {

	@Autowired
	private SchoolService schoolservice;
	private School school;
	@RequestMapping("/schollList.do")
	public ModelAndView list(){
		
		List<School> schoolList=schoolservice.queryStudentList();
		System.out.println(schoolList.get(0).getStudentName());
		return new ModelAndView("schoolList", "schoolList", schoolList);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * 导出学校信息Excel文件
	 */
	@RequestMapping("/exportExcel.do")
	 public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
		 
		 //查询列表数据
		List<School> schoolList=schoolservice.queryStudentList();
		HSSFWorkbook hssfWorkbook=ExcelUtilsGenerate.generateWorkbookForScholl(schoolList, "蕉岭幼儿园信息表.xls");
       
		try {
            response.setHeader("Content-Disposition", "attachment; filename=" + new String("蕉岭幼儿园信息表.xls".getBytes("gb2312"), "ISO8859-1"));
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            OutputStream out = response.getOutputStream();
            hssfWorkbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
				
	 }
	
	@RequestMapping("/importExcel.do")
	public void importExcel(HttpServletRequest request, HttpServletResponse response,@RequestParam MultipartFile file){
		
		if (file.isEmpty()) {
			System.out.println("文件未上传！");
		}else {
			System.out.println(file.getName());
			try {
				List<School> listScholl=ExcelUtilsGenerate.loadShool(file);
//				System.out.println(listScholl.get(0));
				for (int i = 0; i < listScholl.size(); i++) {
					school=new School();
					school=listScholl.get(i);
					System.out.println(school);
					schoolservice.insertStudentList(school);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
}
