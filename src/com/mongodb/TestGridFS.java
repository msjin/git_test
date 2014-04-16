package com.mongodb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.mongodb.DBinfo;

import com.mongodb.gridfs.GridFSDBFile;

public class TestGridFS {

	GridFSdemo gridFSdemo =null;
	
	public static void main(String[] args) {
		TestGridFS testGridFS=new TestGridFS();
//		testGridFS.upFile();
		testGridFS.downFile();
	}
	
	public TestGridFS(){
//		gridFSdemo =GridFSdemo.getInstance(dBinfo, FS_NAME);
		DBinfo dBinfo = new DBinfo();
		dBinfo.setDbName("testdb");
		dBinfo.setUrl("127.0.0.1");
		dBinfo.setPort(27017);
//		gridFSdemo.init(dBinfo, "bbb");
	}
	
	/*
	 * 上传
	 */
	public void upFile(){
		
		String url = "F:/tu/cat.jpg";
//		url="C:/Users/Administrator/Desktop/apache-activemq-5.6.0/README.txt";
		File file = new File(url);
		if(!file.exists()){
			return;
		}
		
		BasicDBObject basicDBObject = new BasicDBObject();
	    basicDBObject.put("key", "value其它信息"); //keyValue形式 BasicDBList是数据形式
	    
	    String fileName = null;
	    String contentType= url.substring(url.indexOf("."));
	    
	    gridFSdemo.saveFile(file, fileName, contentType, basicDBObject);
	}
	
	/*
	 * 下载
	 */
	public void downFile(){
		try {
			GridFSDBFile dbfile = gridFSdemo.findFileByName("cat.jpg");

			String contentType = dbfile.getContentType();
			String fileName = dbfile.getFilename();
			File file = new File("d:/"+fileName);
			if(!file.exists()){
				file.createNewFile();
			}
			
			InputStream in = dbfile.getInputStream();
			if(!file.exists()){
				file.createNewFile();
			}
			OutputStream out = new FileOutputStream(file);
			int i = 0;
			byte[] b =new byte[1024];   
			while((i=in.read(b))!=-1){
				out.write(b, 0, i);
			}
			out.flush();
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
