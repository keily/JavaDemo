package com.keily.List;

public class LinkStack implements IStack {

	private Node Top;
	private int Size;
	
	public LinkStack() {
		Init();
	}
	private void Init(){
		Size = 0;
	}

	@Override
	public boolean Push(Object element) throws Exception {
		Node temp = new Node(element, Top);
		this.Top = temp;
		Size++;
		return true;
	}

	@Override
	public Object Pop() throws Exception {
		if(IsEmpty())
			throw new IllegalArgumentException("Õ»Îª¿Õ");
		Object temp = Top.element;
		Top = Top.Next;
		Size--;
		return temp;
	}

	@Override
	public Object Top() throws Exception {
		if(IsEmpty())
			throw new IllegalArgumentException("Õ»Îª¿Õ");
		return Top.element;
	}
	
	@Override
	public boolean IsEmpty() throws Exception {
		if(Size==0)
			return true;
		return false;
	}
	
	@Override
	public void Print() throws Exception{
		Node cur = Top;
		while(cur!=null){
			System.out.println(cur.element);
			cur = cur.Next;
		}
	}
}
