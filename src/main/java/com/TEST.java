package com;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

public class TEST extends Thread {
	public int i = 0;
	public String sss= "string";
	String rep = "((^((1[8-9]\\d{2})|([2-9]\\\\d{3}))([-\\\\/\\\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)" +
	"|(^((1[8-9]\\d{2})|([2-9]\\d{3})) ([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)" +
	"|(^((1[8-9]\\d{2})|([2-9]\\d{3})) ([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1- 9])$)" +
	"|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)" +
	"|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)" +
	"|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)" +
	"|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";
	
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}
	
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static void main(String[] args) {
		String str = generateShortUuid();
		System.out.println(str);
	}
	
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
        "W", "X", "Y", "Z" };  

    /**
     * 获取唯一码，8位
     */
	public static String generateShortUuid() {  
		StringBuffer shortBuffer = new StringBuffer();  
		String uuid = UUID.randomUUID().toString().replace("-", "");  
		for (int i = 0; i < 8; i++) {  
		    String str = uuid.substring(i * 4, i * 4 + 4);  
		    int x = Integer.parseInt(str, 16);  
		    shortBuffer.append(chars[x % 0x3E]);  
		}  
		return shortBuffer.toString();  
		
	}  
	
	/**
	 * 
	 * 相除 保留n位小数点
	 */
	public static void numberFormat(){
		DecimalFormat  format = new DecimalFormat("0.##");
		String result = format.format((double)129/2);
		double f = Double.valueOf(result);
		System.out.println(f);
	}
	
	/**
	 * 
	 * Collections排序List
	 */
	private static void listSort(){
		List<Integer> topList = new ArrayList<Integer>();
		topList.add(9);
		topList.add(3);
		topList.add(1);
		topList.add(1);
		topList.add(7);
		topList.add(5);
		Collections.sort(topList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1  > o2 ){
					return 1;
				}else{
					return -1;
				}
			}
		});
		
		System.out.println(topList);
	}
	
	/**
	 * list内部情况2
	 */
	public static void listIsChance2(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		for(String s:list){
			if(s.equals("2")){
				list.remove(s);
			}
		}
		System.out.println(list);
	}
	
	/**
	 * list内部情况1
	 */
	public static void listIsChance(){
		List<Map> list = new ArrayList<Map>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aa");
		list.add(map);
		
		for(Map<String, String> m : list){
			m.put("a", "cc");
		}
		System.out.println(list);
	}
	
	
//	public static Map sortByValuee(Map map){
//		Map m = new LinkedHashMap();
//		m = map;
//		TreeMap<String, String> tree = new TreeMap<String, String>(new Comparator<String>() {			
//			@Override
//			public int compare(String a, String b) {
//				 if (Long.valueOf(base.get(a)) >= Long.valueOf(base.get(b))) {
//		            return -1;
//		         } else {
//		            return 1;
//		         } 
//			}
//		});
//		return m;
//	}
	
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<K, V>();
		if (map != null && map.size() > 0) {
			List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
					map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
				public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
					Long a = Long.valueOf(o2.getValue().toString());
					Long b = Long.valueOf(o1.getValue().toString());
//					int f = a.compareTo(b);
//					if(a>b){
//						return 1;
//					}else if(a<b){
//						return -1;
//					}else{
//						return 0;
//					}
					return (o2.getValue()).compareTo(o1.getValue());
				}
			});
			for (Map.Entry<K, V> entry : list) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	
	public void maptest(){
//		LinkedHashMap<String, String> tm = new LinkedHashMap<String,String>();
//		TreeMap<String, String> tm = new TreeMap<String, String>();
		Map<String,String> tm = new LinkedHashMap<String,String>();
		tm.put("1", "a");
		tm.put("2", "b");
		tm.put("cccc", "ccccc");
		tm.put("5", "f");
		tm.put("k", "k");
		tm.put("j", "j");
		tm.put("3", "c");
		tm.put("4", "d");
		
		for(int i=0;i<tm.size();i++){
			System.out.println(tm.get(i));
		}
		Set<String> keys = tm.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			System.out.println(tm.get(it.next()));
		}
	}
	
	public void s(String s){
		String a = s;
		a = "b";
		System.out.println("a:"+a+"\t"+"s:"+s);
	}
	
	/**
	 * 去除字符串签名的0，如0010变为10
	 */
	public void subString(){
		String string = "0010";
		System.out.println(string);
		int i=0;
		for(i=0;i<string.length();i++){
			char c = string.charAt(i);
			if(c>'0'){
				break;
			}
		}
		String str = string.substring(i);
		System.out.println(str);
	}
	
	/**
	 * 查看字符串里面有多少个数字组合
	 * @param value
	 */
	public void showNum(String value){
		int n=0;
		boolean isStr = true;
		char c;
		for(int i=0,l=value.length();i<l;i++){   
            c=value.charAt(i);   
            if(c<'0'||c>'9'){   
            	isStr=true;
                continue;   
            }   
            if(!isStr)continue;   
            n++;
            isStr=false;   
        }   
		System.out.println(n); 
	}
	
	Bean b ;
	Bean be;
	public void set(){
		be= new Bean();
		b=be;
		System.out.println(b==be);
		be.setAge(2);
		System.out.println(b.getAge());
	}
	public void change(){
		b.setAge(3);
		System.out.println(b==be);
		System.out.println(be.getAge());
	}
	
	//当前时间加时间
	public void time() throws InterruptedException{
		Calendar   cal   =   GregorianCalendar.getInstance(); 
		Date date1 = cal.getTime();
        cal.add(Calendar.MINUTE,1); 
        Date   date2  =   cal.getTime(); 
        SimpleDateFormat   format   =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
        String t1 = format.format(date1);
        String t2 = format.format(date2); 
        
        System.out.println(t1+"   改变后的时间: "+t2+ "\r\n "); 

        this.sleep(2000);
		System.out.println(date1.getTime() > new Date().getTime());
	}
	
	public void pattern(){
		String str1 = "^[0-9]{0,8}$"; //小于8位的正整数
		String str2 = "^[0-9]{0,12}(\\.\\d{0,2})?$"; //最大12位整数，2位小数点
		String str3 = "^[0-9]{0,12}(\\.\\d{0,6})?$"; //最大12位整数，6位小数点
		Pattern p = Pattern.compile(str1);
		Matcher m = p.matcher("1231233.");
		System.out.println(m.matches());
	}
	
	/**
	 * 表驱动法
	 */
	public void biaoqudong(){
		String[] dayNames=new String[]{"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		 
		String dayName=dayNames[2];
		
		System.out.println(dayName);
		
	}
	
	/**
	 * 统计一个字符串中第一次出现且频率最高的字符
	 * @param str
	 * @return
	 */
	public static char statMostRateChar(String str) {
	    if (str != null && !"".equals(str)) {
	        int charsStat[] = new int[256];
	        int charsFirstIdx[] = new int[256];
	        int strLen = str.length();
	        
	        for (int ch = 0; ch < 256;ch++) {
	        charsFirstIdx[ch] = strLen;
	        }
	        
	        // 統計字符出現的次數
	        for (int idx = 0; idx < strLen; idx++) {
	            charsStat[str.charAt(idx)]++;
	            // 记录字符第一次出现的位置
	            if (idx < charsFirstIdx[str.charAt(idx)]) {
	            charsFirstIdx[str.charAt(idx)] = idx;
	            }
	        }

	        int mostRateChar = 0;
	        for (int ch = 1; ch < 256; ch++) {
	        if (charsStat[ch] == 0) {
	        continue;
	        }
	            // 找频率出现最高的字符
	        if (charsStat[mostRateChar] < charsStat[ch]) {
	            mostRateChar = ch;
	            // 出现频率一样时，选择出现在前面的数
	            } else if (charsStat[mostRateChar] == charsStat[ch]&&
	            charsFirstIdx[mostRateChar] > charsFirstIdx[ch]) {
	            mostRateChar = ch;
	            }
	        }

	        return (char) mostRateChar;
	    } else {
	        return '\0';
	    }
	}

	
	public void newObject(){
		String y=null;
		String b=null;
		for(int i=0;i<2;i++){
			String s = new String("1");
			if(i==0){
				y=s;
//				System.out.println(y==s);
			}else{
				b=s;
				System.out.println(b==y);
			}
		}
	}
	
	@Override
	public void run() {
		c=++c;
		testsynchronized("线程",c);
	}

	static int c=0; 
	/**
	 * 异步
	 * @param s
	 * @param k
	 */
	public void testsynchronized(String s,int k){
		if(k==2){
			System.out.println(s+k+"不需要此资源");
		}else{
			System.out.println(s+k+"等候");
			synchronized(s){
				System.out.println(s+k+"已进来并锁住");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println(s+k+"出来");
			}
		}
	}
	
	/**
	 * 二进制--->十进制：1101（2）=1*2^0+0*2^1+1*2^2+1*2^3=1+0+4+8=13 
	 * 十进制--->二进制：
	 * 	 789=1100010101 　
	 * 　789/2=394.5 =1 第10位 　
	 * 　394/2=197 =0 第9位 　
	 * 　197/2=98.5 =1 第8位 　
	 * 　98/2=49 =0 第7位 　
	 * 　49/2=24.5 =1 第6位 　
	 * 　24/2=12 =0 第5位 　
	 * 　12/2=6 =0 第4位 　
	 * 　6/2=3 =0 第3位 
	 * 　3/2=1.5 =1 第2位 
	 */
	
	/**
	 * 页面权限
	 */
	public void Authorization(){
		
		int a = 1; //add添加
		int d = 2; //delete删除
		int u = 4; //update修改
		int s = 8; //select查询
		
		//添加权限
		int user1 = a|d;
		int user2 = a|u|s;
		
		System.out.println(user1+"\t"+user2);
		
		if((user1 & a) == a){ //判断
			System.out.println("user:add");
		}
		
		user1 = user1|s; //添加权限
		if((user1 & s) == s){
			System.out.println("user:select");
		}
		
		user1 = user1 & (~s); //删除权限
		if((user1 & s) == s){
			System.out.println("user:select");
		}
		
		if((a & a)==a){
			System.out.println("yes");
		}
	}
	
	
	/**
	 * 反射
	 * @param t
	 */
	public void reflectTest(Class t){
		try {
			Field[] f = t.getFields();
			for(int i =0;i<f.length;i++){
				System.out.println(f[i].toString()+"\t"+f[i].getName()+"\t"+f[i].getModifiers()+"\t"+f[i].getType());
			}
			Method[] m = t.getMethods();
			for(int j =0;j<m.length;j++){
				System.out.println(m[j].getDefaultValue()+"\t"+m[j].getName()+"\t"+m[j].getReturnType()+"\t"+m[j].getTypeParameters());
			}
			//获取TEST类下的q方法,q方法参数为空
			Method method = t.getMethod("q", null);
			//执行q方法,TEST类下
			method.invoke(new TEST(), null);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void q(){
		System.out.println(getClass().getResource("../")+"msgLogger.properties");
		
	}
	
	public void vectorTest(){
		Vector<String> list= new Vector<String>();
		for(int i=0;i<30;i++){
			list.addElement("vector"+i);
		} 
		
		System.out.println(list.size());
		list.removeAll(list);
		System.out.println(list.size());
	}
	
	public void testFinally(){
		testTry();
		System.out.println("testFinally");
	}
	
	public void testTry(){
		try{
			System.out.println("try");
			return ;
		}catch (Exception e) {
			System.out.println("catch");
		}finally{
			System.out.println("finally");
		}
		
	}
	
	public void mixed() throws Exception{
		System.out.println(URLEncoder.encode("utf-8", "gbk"));
		String str = "bank_type=DEFAULT&body=问我钻石&fee_type=1&input_charset=utf-8&notify_url=http://weiwen.wenwo.com/pay/tenpayModifyOrderStatus&out_trade_no=697f85a352194460ae8c7fc40db36ee2&partner=1900000109&product_fee=0.01&return_url=http://weiwen.wenwo.com/pay/tenpayOrderFinish&service_version=1.0&sign_key_index=1&sign_type=MD5&spbill_create_ip=127.0.0.1&time_start=20131118174820&total_fee=0.01&transport_fee=0";
		MessageDigest md  = MessageDigest.getInstance("MD5");
		String sign2 = byteArrayToHexString(md.digest(str.getBytes()));
		String sign = DigestUtils.md5Hex(str.getBytes());
		
		System.out.println(sign2+"\t"+sign);
//		List list = new ArrayList();
//		Map m = new HashMap();
//		m.put("aa", list);
//		list.add("adddd");
//		System.out.println(m.get("aa"));
		
//				SimpleDateFormat   format   =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss:SSS");
//				long l = new Long(format.format(new Date()));
//				System.out.println(l);
//		System.out.println(format.format(new Date()));
//		System.out.println(format.format(new Date()));
//		for(int i=0;i<10;i++){
//			if(1==1){
//				System.out.println(i);
//				if(1==1){
//					System.out.println("en");
//					if(i==2){
//						System.out.println("222222222222222222222");
//						continue;
//					}
//					System.out.println("hello");
//				}
//				System.out.println("yes");
//			}
//		}
		
//		String ss= "123u123";
//		System.out.println(ss.indexOf("s"));
//		String s="true";
//		boolean b= Boolean.valueOf(s.trim());
//		System.out.println(b);
//		boolean b1=false;
//		System.out.println(b1);
		
//		File file=new File(".");
//		String s=file.getCanonicalPath();
//		System.out.println(file.mkdirs());
//		System.out.println(s);
//		System.out.println(file.toString());
		
//		System.out.println(System.getProperty("java.version"));
//		
//		String ss="2009-9-10 ";
//		String[] str=ss.split("-");
//		System.out.println(str[2]);
//		System.out.println(TEST.class.getResource(""));

//		TEST t=new TEST();
//		t.testFinally();
//		t.q();
//		
//		System.out.println(System.getenv("windir"));
//		String s="ab cd evi";
//		System.out.println(s.indexOf("cd"));
//		char c='A';
//		for(int i=0;i<30;i++)
//		System.out.println(++c);
		
		
//		File f=new File("c:/");
//		if(f.exists()){
//			System.out.println(f.getTotalSpace());
//		}
		
//		t.vectorTest();
		
//		String s1="ab";
//		String s2=new String("ab");
//		System.out.println(s2==s1);
//		System.out.println(s2 == s1.intern());
		
//		Map map = new HashMap();
//		map.put(1, 1);
//		map.put(2, 2);
//		System.out.println(map.size());
//		map.clear();
//		System.out.println(map.size());
		
//		for(int i=0;i<10;i++){
//			if(i==2) return;
//			System.out.println(i);
//		}
		
//		String s = "jkjk=1";
//		System.out.println(s.substring(s.indexOf("=")+1));
		
		TEST t= new TEST();
//		t.reflectTest(t.getClass());
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		   String dateString = formatter.format(new Date(new Long("4070880000000")));
//		   System.out.println(dateString);
		 

//		Thread thread = new Thread(t);
//		thread.start();
//		t.testsynchronized("1线程");
//		t.Authorization();
		
		
//		t.newObject();
//		long t1 = new Date().getTime();
//		String s =null;
//		for(int i=0;i<1000000;i++){
//			s = s+"k";
//		}
//		long t2 = new Date().getTime();
//		System.out.println(t2-t1);
		
//		System.out.println(t.statMostRateChar("sssllesdfsghskfs"));
//		t.biaoqudong();
		
//		String s1 = new String("1");
//		String s2 = new String("1");
//		System.out.println(s1==s2);
//		System.out.println(s1.equals(s2));
		
//		String s = "klllsdl代码：";
//		s.contains("代码");
//		System.out.println(s.replace("代码", ""));
		
//		System.out.println(String.format("任务编号:%1$s\r\n任务分组:%2$s\r\n执行时间:%3$tF %3$tT\r\n","sdfsd"));
		
//		String s = "123jkl";
//		t.pattern();
		
//		while(true){
//			System.out.println("1");
//			if(0==0) continue;
//			System.out.println("2");
//		}
//		t.set();
//		t.change();
//		for(int i=0;i<10;i++){
//		Thread th = new Thread(t);
//		th.start();
//		}
//		t.showNum("abc334de5533aa44");
		
//		boolean a = false;
//		System.out.println();
//		if(a=true){
//			System.out.println(a);
//		}
		
		
//		Scanner s = new Scanner(System.in);
//		System.out.println(s.next());
		
		
//		String s = String.format("user_helpexpnent_week_sort_%s_%s", "weiwen",null);
//		System.out.println(s);
		
//		t.maptest();
		
//		Map<String,Integer> map = new HashMap<String, Integer>();
//		map.put("f", 539);
//		map.put("a", 1115);
//		map.put("d", 44);
//		map.put("b", 222);
//		map.put("c", 333);
////		sortByValue(map);
//		System.out.println(map);
		
//		System.out.println("实得分ds".substring(0, 10));
//		
//		Map mm = new HashMap();
//		mm.put("a", "a");
//		TreeMap ta = new TreeMap(new LowMapByValue(mm));
//		ta.putAll(mm);
//		Iterator iii = ta.entrySet().iterator();
//		while(iii.hasNext()){
//			Entry en = (Entry)iii.next();
//			System.out.println(en.getKey()+"\t"+en.getValue());
//		}
//		System.out.println(ta);
//		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("A","579");
//        map.put("B","67");
//        map.put("C","8");
//        map.put("D","666");
//        LowMapByValue bvc =  new LowMapByValue(map);
//        TreeMap<String,String> sorted_map = new TreeMap<String,String>(bvc);
//
////        map.put("A",579l);
////        map.put("B",67l);
////        map.put("C",8l);
////        map.put("D",67l);
//
//        System.out.println("unsorted map: "+map);
//
//        sorted_map.putAll(map);
//        Set keys = sorted_map.keySet();
//        Iterator it = keys.iterator();
//        while(it.hasNext()){
//        	Object key = it.next();
//        	System.out.println(sorted_map.get(key));
//        }
//        
//        System.out.println("results: "+sorted_map);
	}
	
}

//根据map的value降序
class LowMapByValue implements Comparator<String>{
	Map<String, String> basemap ;
	public LowMapByValue(Map<String,String> map){
		this.basemap=map;
	}
	@Override
	public int compare(String o1, String o2) {
		 if (Long.valueOf(basemap.get(o1)) >= Long.valueOf(basemap.get(o2))) {
	            return -1;
	        } else {
	            return 1;
	        }
	}
	
}


class ValueComparator implements Comparator<String> {

    Map<String, String> base;
    public ValueComparator(Map<String, String> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (Long.valueOf(base.get(a)) >= Long.valueOf(base.get(b))) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
    
}
