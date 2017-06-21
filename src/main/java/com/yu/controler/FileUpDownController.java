package com.yu.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author Administrator
 *	文件上传控制器
 */
@Controller
public class FileUpDownController {
	/**
	 * 
	 * @param uploadFile
	 * 接收的文件
	 * @param session
	 * @return
	 * 单文件上传
	 */
	@RequestMapping("/first.do")
	public String doFirst(@RequestParam MultipartFile uploadFile,HttpSession session){
		System.out.println(uploadFile.getOriginalFilename());
		//获取文件名作为保存到服务器的文件名
		String filename=uploadFile.getOriginalFilename();
		//前半部分路径，目录，将webcontext下一个名称为images文件夹转换成绝对路径
//		String leftPath=session.getServletContext().getRealPath("/images");
//		System.out.println(leftPath);
		String leftPath="G:/websource";
		//进行路径拼接=前半部分+文件名称
		File file=new File(leftPath,filename);
		try {
			uploadFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "welcome";
	}
	

	@RequestMapping("/second.do")
	public String doSecond(@RequestParam MultipartFile[] uploadFile,HttpSession session){
		
		for (MultipartFile item : uploadFile) {
			//获取文件名作为保存到服务器的文件名
			String filename=item.getOriginalFilename();
			//匹配文件格式
//			if (filename.endsWith("jpg")||filename.endsWith("gif")) {
				//前半部分路径，目录，将webcontext下一个名称为images文件夹转换成绝对路径
				//上传到服务器的位置
				String leftPath="G:/websource";
				//进行路径拼接=前半部分+文件名称
				File file=new File(leftPath,filename);
				try {
					item.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
//			}
		}
		return "welcome";
	}
	/**
	 * 
	 * @param request
	 * @return
	 * 基于ResponseEntity实现文件下载
	 */
	@RequestMapping("/fileDownload.do")
	public ResponseEntity<byte[]> download(HttpServletRequest request){
		ResponseEntity<byte[]> entity=null;
		//要下载文件在服务器的位置
		File file=new File("G:/公司资料文件/智慧校园各区域用户数据（最新）第三方递四方速递粉色的范德萨范德萨.xlsx");
		byte[] body=null;
		InputStream is;
		try {
			is = new FileInputStream(file);
			body=new byte[is.available()];
			is.read(body);
			HttpHeaders headers=new HttpHeaders();
			//java.net.URLEncoder.encode(file.getName(), "UTF-8") 解决中午文件名乱码
			headers.add("Content-Disposition", "attchement;filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8") );
			HttpStatus statusCode=HttpStatus.OK;
			entity=new ResponseEntity<byte[]>(body, headers, statusCode);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entity;
		
	}
}
