/**
 * 
 */
package com.keily.List;

import com.keily.Sort.QuickSort;

/**
 * @author Administrator
 * ����
 */
public class LinkList implements IList {

	private Node Current;
	private Node Head;
	private Node End;
	private int Size;
	/**
	 * ���캯��
	 */
	public LinkList() {
		Head = Current = End = null;
		Size = 0;
	}

	private void LocationNode(int index)throws Exception {
		if(index < 0 || index >= Size)
			throw new IllegalArgumentException("�������Ϸ�");
		
		Current = Head;
		int loc=0;
		while(Current!=null && loc<index){
			Current = Current.Next;
			loc++;
		}
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#Insert(int, java.lang.Object)
	 */
	@Override
	public void Insert(int index, Object element) throws Exception {
		//��λ�ڵ�
		LocationNode(index);
		
		Node temp = new Node(element, Current.Next);
		
		//Ԫ��Ϊ��
		if(0 == Size){
			Head = End = Current = temp;
		}
		//ĩβ����
		else if(index == Size-1){
			Current.Next = temp;
			End = End.Next;
		}
		else{
			Current.Next = temp;
		}
		Size++;
	}
	
	/* (non-Javadoc)
	 * @see com.keily.List.IList#Insert(java.lang.Object)
	 */
	@Override
	public void Insert(Object element) throws Exception {
		//��β������
		Node temp = new Node(element, null);
		//Ԫ��Ϊ��
		if(Size == 0){
			Head = End = Current = temp;
		}else{
			End.Next = temp;
			End = End.Next;
		}
		Size++;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#Update(int, java.lang.Object)
	 */
	@Override
	public boolean Update(int index, Object element) throws Exception {
		//��λ�ڵ�
		LocationNode(index);
		Current.element = element;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#Delete(java.lang.Object)
	 */
	@Override
	public void Delete(Object element) throws Exception {
		if(IsEmpty())
			return;
		//ֻ��һ��Ԫ��
		if(Head==End && Head.element.equals(element)){
			Head = Current = null;
			return;
		}
		//2��Ԫ��
		Delete2(Head , Head.Next , element);
		//�ټ��head
		if(Head.element.equals(element)){
			Node Temp = Head;
			Head = Head.Next;
			Temp = null;
		}
	}
	private void Delete2(Node _pre, Node _cur, Object element) throws Exception {
		if(_cur!=null && _cur.element.equals(element))
		{
			if(_cur == End)
				End = _pre;
			_pre.Next = _cur.Next;
			_cur = _pre;
		}
		
		if(_cur!=null)
			Delete2(_cur, _cur.Next, element);
	}
	//���
	public void Clean()throws Exception {
		Delete(Head);
		Head = End = Current = null;
		Size = 0;
	}
	//�ݹ�ɾ��
	private void DeleteAll(Node _node)throws Exception {
		if(_node != null ){
			Node temp = _node.Next;
			_node = null;
			Delete(temp);
		}
	}
	@Override
	public void Delete(int index) throws Exception {
		if(index<0 || index>Size-1)
			throw new IllegalArgumentException("�������Ϸ�");
		//���ɾ���ĵ�һ��Ԫ��
		if(index == 0){
			//�������ֻ��һ��Ԫ��
			if(Size == 1){
				Head = End = Current = null;
				Size--;
			}
			//��������ж��Ԫ��
			else{
				Node temp = Head;
				Head = Head.Next;
				temp = null;
				Size--;
			}
		}
		//���ɾ��������ĩβԪ��
		else if(index == Size-1){
			//��λ�ڵ�
			LocationNode(index-1);
			Node temp = End;
			End = Current;
			temp = null;
		}
		//��������
		else{
			Node temp = Current;
			Current = Current.Next;
			temp = null;
			Size--;
		}
	}
	/* (non-Javadoc)
	 * @see com.keily.List.IList#GetData(int)
	 */
	@Override
	public Object GetData(int index) throws Exception {
		//��λ�ڵ�
		LocationNode(index);
		return Current.element;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#GetLength()
	 */
	@Override
	public int GetLength() throws Exception {
		return Size;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#Find(java.lang.Object)
	 */
	@Override
	public int Find(Object element) throws Exception {
		Current = Head;
		int loc=0;
		while(Current!=null ){
			if(element.equals(Current.element))
				return loc;
			Current = Current.Next;			
			loc++;
		}
		return -1;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#IsEmpty()
	 */
	@Override
	public boolean IsEmpty() throws Exception {
		if(Size == 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#Print()
	 */
	@Override
	public void Print() throws Exception {
		Current = Head;
		int loc=0;
		while(Current!=null ){
			System.out.println("index:" + loc + "  element:" + Current.element.toString());
			Current = Current.Next;
			loc++;
		}
	}

	/* (non-Javadoc)
	 * @see com.keily.List.IList#Sort()
	 */
	@Override
	public void Sort() throws Exception {
		Object[] sortArr = new Object[this.Size];
		int loc=0;
		Current = Head;
		//copy
		while(Current!=null ){
			sortArr[loc++] = Current.element;
			Current = Current.Next;
		}
		//sort
		QuickSort sort = new QuickSort(sortArr);
		//copy
		loc=0;
		Current = Head;
		while(Current!=null ){
			Current.element = sortArr[loc++];
			Current = Current.Next;
		}
	}

}
