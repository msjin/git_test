package com;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import com.efuture.dal.utils.PropertiesUtil;

public class PropertiesU {
	private String sendURL = "tcp://localhost:61616";
	private String user = "";
	private String password = "";
	private String subject = "MSG.DEFAULT";
	private boolean topic;
	private boolean transacted = false;
	private boolean persistent = false;
	private boolean isOpenMQ=false;
	private long sleeptime;
	private String msgProperties = "msgLogger";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertiesU u=new PropertiesU();
		
		u.propertiesUtil();
		u.setConfig();
	}
	
	public void propertiesUtil(){
		long d1=new Date().getTime();
		isOpenMQ=PropertiesUtil.getString(msgProperties, "isOpenMQ").equals("true")?true:false;
		sendURL=PropertiesUtil.getString(msgProperties, "sendURL");
		user=PropertiesUtil.getString(msgProperties, "user");
		password=PropertiesUtil.getString(msgProperties, "password");
		subject=PropertiesUtil.getString(msgProperties, "subject");
		topic=PropertiesUtil.getString(msgProperties, "topic").equals("true")?true:false;
		transacted=PropertiesUtil.getString(msgProperties, "transacted").equals("true")?true:false;
		persistent=PropertiesUtil.getString(msgProperties, "persistent").equals("true")?true:false;
		sleeptime=Long.valueOf(PropertiesUtil.getString(msgProperties, "sleeptime"));
		long d2=new Date().getTime();
		System.out.println(d2-d1);
		System.out.println(isOpenMQ+"\t"+sendURL+"\t"+user+"\t"+password+"\t"+subject+"\t"+topic+"\t"+transacted+"\t"+
				persistent+"\t"+sleeptime);

	}
	
	public void setConfig() throws IOException {
		long d=new Date().getTime();
		Properties p = new Properties();
		File file = new File("src/msgLogger.properties");
		if (!file.exists())
			return;
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		p.load(in);
		Set keyset = p.keySet();
		Object[] obj = keyset.toArray();
		for (int i = 0; i < keyset.size(); i++) {
			if (obj[i].equals("isOpenMQ")) {
				isOpenMQ = p.getProperty((String) obj[i]).equals("false")?false:true;
			}
			if (obj[i].equals("sendURL")) {
				sendURL = p.getProperty((String) obj[i]);
			}
			if (obj[i].equals("user")) {
				user = p.getProperty((String) obj[i]);
			}
			if (obj[i].equals("password")) {
				password = p.getProperty((String) obj[i]);
			}
			if (obj[i].equals("subject")) {
				subject = p.getProperty((String) obj[i]);
			}
			if (obj[i].equals("topic")) {
				topic = p.getProperty((String) obj[i]).equals("false") ? false
						: true;
			}
			if (obj[i].equals("transacted")) {
				transacted = p.getProperty((String) obj[i]).equals("false") ? false
						: true;
			}
			if (obj[i].equals("persistent")) {
				persistent = p.getProperty((String) obj[i]).equals("false") ? false
						: true;
			}
			if (obj[i].equals("sleeptime")) {
				sleeptime = new Long(p.getProperty((String) obj[i]));
			}
		}
		keyset.clear();
		in.close();
		long d2=new Date().getTime();
		System.out.println(d2-d);
	}

}
