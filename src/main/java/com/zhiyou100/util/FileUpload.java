package com.zhiyou100.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class FileUpload {
public static String upload(Part filename){
	String fname="";
	String path="E:\\eclipse\\workspace\\Project1\\src\\main\\webapp\\";
  
	if(filename.getSize()>1024*1024){
		try {
			filename.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("文件太大，不能上传！");
		return null;
	}else{
		path=path+"image\\";//存放图片的路径
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		
		String h=filename.getHeader("content-disposition");
		fname=h.substring(h.lastIndexOf("filename")+10,h.length()-1);//得到文件名
		if(fname==null||fname==""||("").equals(fname))
			return fname;
		try {
			filename.write(path+fname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String url="http://localhost:8080/Project1/image/"+fname;
		
	return url;
}
}
}
