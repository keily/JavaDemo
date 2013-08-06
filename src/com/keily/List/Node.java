/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 * 节点
 */
public class Node {
	//当前节点值
	Object element;
	//下一个节点
	Node Next;
	/**
	 * @param _next 下一个节点
	 */
	public Node(Node _next) {
		this.Next = _next;
	}
	/**
	 * @param _element 下一个节点值
	 * @param _next 下一个节点
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
