/**
 * 
 */
package com.keily.Sort;

import java.util.Random;

/**
 * @author Administrator
 *
 */
public class QuickSort {

	/**
	 * 
	 */
	public QuickSort(Object[] arrData) {
		//Object[] arrData =new Object[20];
		//InitData(arrData);
		//Print(arrData);
		Sort(arrData,0,arrData.length-1);
		//Print(arrData);
	}
	public QuickSort() {
		/*Object[] arrData =new Object[20];
		InitData(arrData);
		Print(arrData);
		Sort(arrData,0,arrData.length-1);
		Print(arrData);*/
	}
	
	private void Print(Object[] arrData) {
		System.out.println("data:");
		for(int i=0;i<arrData.length;i++)
			System.out.print(arrData[i]+" ");
	}

	private void InitData(Object[] arrData) {
		Random r=new Random(); 
		for(int i=0;i<arrData.length;i++)
			arrData[i]=r.nextInt();
		//arrData = new int[]{56,89,63,4,102,86,96,55,1};
	}
	
	private int Compare(Object o1, Object o2){
        return (o1.hashCode()-o2.hashCode());
	}
	/**
	 * ����
	 * @param arrData ���������
	 * @param left ���±�
	 * @param right ���±�
	 */
	public void Sort(Object[] arrData, int left, int right){
		Object middle;
		int i,j;//�����±�
		i=left;
		j=right;
		middle=(arrData[(i+j)/2]);//�м���
		do{
			//�ҵ�middle��߱�arr[middle]���ұ߱�air[middle]С����������������
			/*while(arrData[i]<middle && i<right)
				i++;
			while(arrData[j]>middle && j>left)
				j--;*/
			while(Compare(arrData[i], middle)<0 && i<right)
				i++;
			while(Compare(arrData[j], middle)>0 && j>left)
				j--;
			//����
			if(i<=j){
				swap(arrData,i,j);
				i++;
				j--;
			}
		}while(i<=j);
		//
		if(i<right)
			Sort(arrData,i,right);
		if(j>left)
			Sort(arrData,left,j);
	}

	private void swap(Object[]arrData,int i, int j) {
		Object temp=arrData[i];
		arrData[i]=arrData[j];
		arrData[j]=temp;
	}

}
