package com.mianShiTi.suanfa;


public class Erfenfa {

	public static void main(String[] args) {
		long[] data = Erfenfa.createData();
		System.out.println(Erfenfa.binaryFind(data, 789));
	}
	
//-------------------	二分法  ---------------------------------
//	构造数据
	public static long[] createData(){
		int length=50000;
		long[] data = new long[length];
		for(int i=0;i<length;i++){
			data[i]=i+1;
		}
		return data;
	}
	public static int binaryFind(long[] data ,long terget){
		int result=-1;
		int start = 0;
		int end = data.length-1;
		int middleIndex=0;
		long tempTerget;
		while(start<=end){
			middleIndex=(start+end)/2;
			tempTerget =data[middleIndex]; 
			if(tempTerget==terget){
				result=middleIndex;
				break;
			}
			if(terget>tempTerget){
				start=middleIndex+1;
			}else{
				end=middleIndex-1;
			}
		}
		
		return result;
	}
}
