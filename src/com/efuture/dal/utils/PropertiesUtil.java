package com.efuture.dal.utils;

import java.io.UnsupportedEncodingException;   
import java.text.MessageFormat;   
import java.util.Locale;   
import java.util.MissingResourceException;   
import java.util.ResourceBundle;   


public class PropertiesUtil {

	private static String encoding = "UTF-8";   
	   /**  
         * read the message with key from the resource bundle  
	     * @param bundlePath  
         * @param key  
	     * @return  
	     */  
	    public static String getString(String bundlePath,String key){   
	        return getString(bundlePath,key,null);   
	    }   
	    /**  
	     * read the message with key from the resource bundle  
	     * @param bundlePath  
	     * @param key  
	     * @param args  
	     * @return  
	     */  
	    public static String getString(String bundlePath,String key,Object[] args){   
	        // we will throw a MessingResourceException if the bundle name is invalid   
	        ResourceBundle bundle = getBundle(bundlePath);   
	        try{   
	            String msg = bundle.getString(key);   
	            if(msg == null){   
	                return "";   
	            }   
	            // change the message encoding   
	            msg = convertISO(msg);   
	            return msg = MessageFormat.format(msg, args);   
	        } catch(MissingResourceException e){   
	            return "";   
	        }   
	    }   
	    /**  
	     * get ResourceBundle with bundlePath  
	     * @param bundlePath  
	     * @return  
	     * @throws MissingResourceException if resource is messing  
	     */  
	    private static ResourceBundle getBundle(String bundlePath){   
	        Locale locale = Locale.getDefault();   
	        ResourceBundle bundle = ResourceBundle.getBundle(bundlePath,locale,getClassLoader());   
	        return bundle;   
	    }   
	    /**  
	     * get the current ClassLoader  
	     * @return  
	     */  
	    protected static ClassLoader getClassLoader(){   
	        return PropertiesUtil.class.getClassLoader();   
	    }   
	    /**  
	     * convert msg encoding  
	     * @param msg  
	     * @return  
	     */  
	    public static String convertISO(String msg){   
	        if(msg != null){   
	            try{   
	                return new String(msg.getBytes("iso-8859-1"),getEncoding());   
	            } catch(UnsupportedEncodingException e){   
	                e.printStackTrace();   
	            }   
	        }   
	        return "";   
	    }   
	    /**  
	   * get encoding  
	     * @return  
	     */  
	    public static String getEncoding() {   
	        return encoding;   
	   }   
	   /**  
        * set encoding  
	    * @param encoding  
	   */  
	    public static void setEncoding(String encoding) {   
	        PropertiesUtil.encoding = encoding;   
	    }   

}
