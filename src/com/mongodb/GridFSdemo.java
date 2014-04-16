package com.mongodb;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.types.ObjectId;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class GridFSdemo {
	private static GridFS gridFS=null;
	private GridFSDBFile gridFSDBFile=null;
	
	private GridFSdemo(){
		
	}
	public static void getInstance(DBinfo dBinfo,String FS_NAME){
		if(gridFS!=null) return;
		try {
			Mongo mongo = new Mongo(dBinfo.getUrl(),dBinfo.getPort());//建立连接
		    DB myDb = mongo.getDB(dBinfo.getDbName());//获取数据库
		    gridFS=new GridFS(myDb, FS_NAME); //FS_NAME相当于gridfs文件系统的表名，可以有多个
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 上传文件
	 */
	public boolean saveFile(File file, String fileName, String contentType,
		      DBObject metaData) {
		     
		    GridFSInputFile gfsInput;
		    try {   
		      if(gridFS==null) return false;
		      gfsInput = gridFS.createFile(file);//读取文件信息
		      if(fileName!=null)
		    	  gfsInput.setFilename(fileName);//每条记录都有finename字段，默认将会取上传文件名，例如：D:/README.txt，filename为README.txt
		      if(contentType!=null)
		    	  gfsInput.setContentType(contentType);//默认为空
		      gfsInput.setMetaData(metaData);//其它信息
		      gfsInput.save();
		    } catch (IOException e) {
		      return false;
		    }
		    return true;
		  }
	
	
	/*
	 * 通过文件名读取文件
	 */
	public GridFSDBFile findFileByName(String fileName){
	    GridFSDBFile gfsFile ;
	    try {    
	    	if(gridFS==null) return null;
	    	gfsFile =gridFS.findOne(fileName);
	    } catch (Exception e) {
	      return null;
	    }
	    return gfsFile;
	  }
	
	/*
	 * 通过id读取文件
	 */
	public GridFSDBFile findFileById(String id){
	    GridFSDBFile gfsFile ;
	    try {      
	    	if(gridFS==null) return null;
		    gfsFile = gridFS.find(new ObjectId(id));
	    } catch (Exception e) {
	      return null;
	    }
	    return gfsFile;
	  }
	
	/*
	 * 输出文件到OutputStream
	 */
	private boolean writeToOutputStream(OutputStream out, GridFSDBFile gfsFile) {
	    try {     
	      gfsFile.writeTo(out);
	    } catch (IOException e) {
	      return false;
	    }
	    return true;
	  }
}
