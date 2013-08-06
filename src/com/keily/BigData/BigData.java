package com.keily.BigData;

public class BigData {

	public BigData() {
		
	}
	public void TestBigDataAdd(){
		char[] A={'5','3','2','7'};
		char[] B={'3','4','2','7'};
		char[] sum=BigDataAdd(A,B);
		System.out.println(sum);
	}
	
	public char[] BigDataAdd(char[] A,char[] B){
		int lenA=A.length;
		int lenB=B.length;
		int maxLen=lenA>lenB? lenA : lenB;
		char[] tempA=new char[maxLen+1];
		char[] tempB=new char[maxLen+1];
		char[] sum=new char[maxLen+1];
		
		for(int i=0;i<lenA;i++){
			tempA[i]=(char)(A[lenA-i-1]-'0');
		}
		for(int i=0;i<lenB;i++){
			tempB[i]=(char)(B[lenB-i-1]-'0');
		}
		
		for(int i=0,c=0;i<=maxLen;i++){
			sum[i]=(char)((tempA[i]+tempB[i]+c)%10+'0');
			c=(tempA[i]+tempB[i]+c)/10;
		}
				
		for(int i=0;i<(maxLen+1)/2;i++){
			char temp = sum[i];
			sum[i]=sum[maxLen-i];
			sum[maxLen-i]=temp;
		}
		if(sum[0]=='0')
			sum[0]=' ';
		
		return sum;
	}

}
