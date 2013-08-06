/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 * 顺序栈
 */
public class SeqStack implements IStack {

	private int Capacity = 10;
	private int Top ;
	private Object[] mArray;
	/**
	 * 构造函数
	 */
	public SeqStack() {
		Init(Capacity);
	}
	public SeqStack(int initSize) {
		Init(initSize);
	}
	//初始化
	private void Init(int initSize)
	{
		mArray = new Object[initSize];
		Top = -1;
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IStack#Push()
	 */
	@Override
	public boolean Push(Object element) throws Exception {
		try{
			if(++Top>=Capacity){
				Capacity <<= 1;
				Object[] newmArray = new Object[Capacity];
				for(int i=0;i<mArray.length;i++)
					newmArray[i]=mArray[i];
				mArray = newmArray;
			}		
			mArray[Top]=element;
			return true;
		}catch(Exception e){
			Top--;
			return false;
		}		
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IStack#Pop()
	 */
	@Override
	public Object Pop() throws Exception {
		if(IsEmpty())
			throw new IllegalArgumentException("栈为空");
		
		return mArray[Top--];
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IStack#Top()
	 */
	@Override
	public Object Top() throws Exception {
		if(IsEmpty())
			throw new IllegalArgumentException("栈为空");
		
		return mArray[Top];
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IStack#IsEmpty()
	 */
	@Override
	public boolean IsEmpty() throws Exception {
		if(Top>=0)
			return false;
		return true;
	}
	@Override
	public void Print() throws Exception{		
		for(int i=Top;i>=0;i--){
			System.out.println(mArray[i]);
		}
	}
}
