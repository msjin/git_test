package com.mianShiTi;

public class TryCatch {

	/**
	 * Java异常处理中，try {}里有一个return语句，那么紧跟在这个try后的finally 
	 * {}里的code会不会被执行，什么时候被执行，在return前还是后?
	 * 
	 * 会执行，在return前执行。
	 */
	public static void main(String[] args) {
		System.out.println(tryCatch());
	}
	
	public static int tryCatch(){
		try{
			System.out.println("try");
			return 2;
		}catch(Exception e){
			System.out.println("catch");
		}finally{
			System.out.println("finally");
		}
		return 0;
	}
	
}
