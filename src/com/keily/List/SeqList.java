/**
 * 
 */
package com.keily.List;

import com.keily.Sort.*;

/**
 * @author Administrator
 *顺序表
 */
public class SeqList implements IList {
	//默认顺序表空间大小
	private final int DefaultSize=10;
	//顺序表空间大小
	private int Capacity;
	//存储数组
	private Object[] mArrary;
	//当前大小
	private int Size;
	/**
	 * 构造函数
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
			throw new IllegalArgumentException("索引不合法");
		
		//如果当前插入的索引值等于链表的最大值，
		//为了考虑下次插入的效率，申请比现在大一倍的空间的新数组，并将值复制到新数组中
		if(Capacity==Size){
			//申请比现在大一倍的空间的新数组
			Object[] newmArrary = new Object[Capacity*2];
			//将索引小于index的值copy到新数组
			for(int i=0;i<index;i++)
				newmArrary[i]=mArrary[i];
			//将插入值插入新数组
			newmArrary[index]=element;
			//将索引大于index的值copy到新数组
			for(int i=index;i<Size;i++)
				newmArrary[i+1]=mArrary[i];
			
			//更新数组
			mArrary = newmArrary;
			//
			Capacity *=2;
			Size++;
		}
		else{
			//将索引大于index的值后移
			for(int i=Size-1;i>=index;i--)
				mArrary[i+1]=mArrary[i];
			//插入新值
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
			throw new IllegalArgumentException("索引不合法");
		
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
			throw new IllegalArgumentException("索引不合法");
		
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
			throw new IllegalArgumentException("索引不合法");
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
