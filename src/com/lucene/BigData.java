package com.lucene;

public class BigData {

	public BigData() {

	}
	public void TestBigDataAdd(){
		char[] A = ("1150").toCharArray();
		char[] B = ("2053").toCharArray();
		System.out.println("A:"+A + "+B:"+B);
		char[] returns = BigDataAdd(A,B);
		int vaildindex=0;
		String val="";
		for(int i=0;i<returns.length;i++)
			if(vaildindex==0 && (returns[i]) == '0'){
				vaildindex = i;
			}else{
				val+=returns[i];
			}
		System.out.println("result:" + val);
	}
	public char[] BigDataAdd(char[] A,char[] B){
		int intLenA = A.length;
		int intLenB = B.length;

		char[] sSum = new char[100];	
		for(int i=0,c=0;i<intLenA || i<intLenB;i++){
			sSum[i] = (char)((A[i]+B[i]+c-2*'0')%10+'0');
			c = (A[i]+B[i]+c-2*'0')/10;
		}
		return sSum;
	}


}