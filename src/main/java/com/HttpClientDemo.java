/**  
 * ---------------------------------------------------------------------------
 * Copyright (c) 2014, 深圳市问我时代科技有限公司- All Rights Reserved.
 * Project Name:Test  
 * File Name:HttpClientDemo.java  
 * Package Name:com
 * Author   Administrator
 * Date:2014-3-7下午5:38:06
 * ---------------------------------------------------------------------------  
*/  
  
package com;  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**  
 * ClassName:HttpClientDemo 
 * Date:     2014-3-7 下午5:38:06
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6
 */
public class HttpClientDemo {

	public static void main(String[] args) throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		try{
			String target = "http://cooljsun:qwe123@ddns.oray.com/ph/update?hostname=melon.wicp.net&myip=";
			HttpGet get = new HttpGet(target);
			CloseableHttpResponse resp = client.execute(get);
			
			HttpEntity entity = resp.getEntity();
//			EntityUtils.consume(resp.getEntity());
			
			InputStream in = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			System.out.println(reader.readLine());
			while(reader.readLine() !=null){
				System.out.println(reader.readLine());
			}
			
			Thread.sleep(3000);
			System.out.println(resp.getStatusLine());
			System.out.println(EntityUtils.getContentCharSet(entity));
			System.out.println("he:"+EntityUtils.toString(entity));
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
  
