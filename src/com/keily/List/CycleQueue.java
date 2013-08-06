/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 * ����
 */
public class CycleQueue implements IQueue {
	static final int DefaultSize=10;
	private int Size;
	private int Rear,Front,Count;
	private Object[] data;
	/**
	 * ѭ������
	 */
	public CycleQueue() {
		Init(DefaultSize);
	}
	public CycleQueue(int size) {
		Init(size);
	}
	private void Init(int size){
		Size=size;		
		Rear=Front=0;
		Count=0;
		data = new Object[Size];
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IQueue#Append(java.lang.Object)
	 */
	@Override
	public void Append(Object element) throws Exception {
		if(Count>0 && Front==Rear){
			throw new Exception("����������");
		}

		data[Rear]=element;
		Rear=(Rear+1)%Size;
		Count++;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IQueue#Delete()
	 */
	@Override
	public Object Delete() throws Exception {
		if(Count==0)
			throw new Exception("�����ѿգ�");
		
		Object temp=data[Front];
		Front=(Front+1)%Size;
		Count--;
		return temp;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IQueue#Front()
	 */
	@Override
	public Object Front() throws Exception {
		if(Count==0)
			throw new Exception("�����ѿգ�");
		
		return data[Front];
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IQueue#IsEmpty()
	 */
	@Override
	public boolean IsEmpty() throws Exception {		
		return Count==0;
	}
	@Override
	public int Length()throws Exception{		
		return Count;
	}
}
