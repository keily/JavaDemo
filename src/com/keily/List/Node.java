/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 * �ڵ�
 */
public class Node {
	//��ǰ�ڵ�ֵ
	Object element;
	//��һ���ڵ�
	Node Next;
	/**
	 * @param _next ��һ���ڵ�
	 */
	public Node(Node _next) {
		this.Next = _next;
	}
	/**
	 * @param _element ��һ���ڵ�ֵ
	 * @param _next ��һ���ڵ�
	 */
	public Node(Object _element, Node _next) {
		this.element = _element;
		this.Next = _next;
	}
	
	public void SetElement(Object _element){
		this.element = _element;
	}
	public Object GetElement(){
		return element;
	}
	public void SetNext(Node _next){
		this.Next = _next;
	}
	public Node GetNext(){
		return Next;
	}
	
	@Override
	public String toString(){
		return element.toString();
	}
}
