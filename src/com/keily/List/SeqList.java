/**
 * 
 */
package com.keily.List;

import com.keily.Sort.*;

/**
 * @author Administrator
 *˳���
 */
public class SeqList implements IList {
	//Ĭ��˳���ռ��С
	private final int DefaultSize=10;
	//˳���ռ��С
	private int Capacity;
	//�洢����
	private Object[] mArrary;
	//��ǰ��С
	private int Size;
	/**
	 * ���캯��
	 */
	public SeqList() {
		Initize(DefaultSize);
	}
	public SeqList(int initSize) {
		Initize(initSize);
	}
	
	private void Initize(int initSize){
		Size=0;
		Capacity = initSize;
		mArrary = new Object[initSize];
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IList#Insert(int, java.lang.Object)
	 */
	@Override
	public void Insert(int index, Object element) throws Exception {
		if(index<0 || index>Size)
			throw new IllegalArgumentException("�������Ϸ�");
		
		//�����ǰ���������ֵ������������ֵ��
		//Ϊ�˿����´β����Ч�ʣ���������ڴ�һ���Ŀռ�������飬����ֵ���Ƶ���������
		if(Capacity==Size){
			//��������ڴ�һ���Ŀռ��������
			Object[] newmArrary = new Object[Capacity*2];
			//������С��index��ֵcopy��������
			for(int i=0;i<index;i++)
				newmArrary[i]=mArrary[i];
			//������ֵ����������
			newmArrary[index]=element;
			//����������index��ֵcopy��������
			for(int i=index;i<Size;i++)
				newmArrary[i+1]=mArrary[i];
			
			//��������
			mArrary = newmArrary;
			//
			Capacity *=2;
			Size++;
		}
		else{
			//����������index��ֵ����
			for(int i=Size-1;i>=index;i--)
				mArrary[i+1]=mArrary[i];
			//������ֵ
			mArrary[index]=element;
			Size++;
		}
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IList#Insert(int, java.lang.Object)
	 */
	@Override
	public void Insert(Object element) throws Exception {
		Insert(Size,element);
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IList#Update(java.lang.Object)
	 */
	@Override
	public boolean Update(int index ,Object element) throws Exception{
		if(index<0 || index>=Size)
			throw new IllegalArgumentException("�������Ϸ�");
		
		try{
			mArrary[index]=element;
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IList#Delete(java.lang.Object)
	 */
	@Override
	public void Delete(Object element) throws Exception {
		int index = Find(element);
		if(index!=-1){
			for(int i=index;i<Size-2;i++){
				mArrary[i]=mArrary[i+1];
			}
			mArrary[Size-1]=0;
			Size--;
		}
	}
	@Override
	public void Delete(int index) throws Exception {
		if(index<0 || index>=Size)
			throw new IllegalArgumentException("�������Ϸ�");
		
		for(int i=index;i<Size-2;i++){
			mArrary[i]=mArrary[i+1];
		}
		mArrary[Size-1]=0;
		Size--;
	}
	
	/* (non-Javadoc)
	 * @see com.keily.List.IList#Find(java.lang.Object)
	 */
	@Override
	public int Find(Object element) throws Exception{
		for(int i=0;i<Size;i++)
			if(mArrary[i].equals(element))
				return i;
		return -1;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#GetData(int)
	 */
	@Override
	public Object GetData(int index) throws Exception {
		if(index<0 || index>=Size)
			throw new IllegalArgumentException("�������Ϸ�");
		return mArrary[index];
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#GetLength()
	 */
	@Override
	public int GetLength() throws Exception {
		return Size;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#IsEmpty()
	 */
	@Override
	public boolean IsEmpty() throws Exception {
		return Size>0? false : true;
	}
	@Override
	public void Print() throws Exception{
		for(int i=0;i<Size;i++)
			System.out.print(mArrary[i]+",");
	}
	@Override
	public void Sort(){
		Object[] sortArr = new Object[this.Size];
		for(int i=0;i<this.Size;i++)
			sortArr[i] = mArrary[i];
		QuickSort sort = new QuickSort(sortArr);
		for(int i=0;i<this.Size;i++)
			mArrary[i] = sortArr[i];
		//sort.Sort(mArrary, 0, mArrary.length-1);
	}
}
