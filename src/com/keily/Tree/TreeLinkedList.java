/**
 * 
 */
package com.keily.Tree;

/**
 * @author Administrator
 * 基于链表存储结构的树实现
 */
public class TreeLinkedList implements ITree{

	private Object element;//节点值
	//父亲节点，第一个子节点，下一个兄弟节点
	private TreeLinkedList parentNode,childNode,nextSiblingNode;
	/**
	 * 
	 */
	public TreeLinkedList() {
		this(null,null,null,null);
	}
	public TreeLinkedList(Object _element,TreeLinkedList _parent,TreeLinkedList _child,
			TreeLinkedList _sibling) {
		element=_element;
		parentNode=_parent;
		childNode=_child;
		nextSiblingNode=_sibling;
	}
	@Override
	public Object getElem(Object obj) {
		return element;
	}

	@Override
	public Object setElem(Object obj) {
		Object o=element;
		element=obj;
		return o;
	}

	@Override
	public TreeLinkedList getParent() {		
		return parentNode;
	}

	@Override
	public TreeLinkedList getFirstChild() {
		return childNode;
	}

	@Override
	public TreeLinkedList getNextSibling() {
		return nextSiblingNode;
	}

	@Override
	public int getSize() {
		int size=1;//根节点为1
		//获取第一个子节点
		TreeLinkedList curNode=getFirstChild();
		//如果有子节点 递归进行
		while(null!=curNode){
			//递归获取子节点树
			size+=curNode.getSize();
			//扫描兄弟节点
			curNode=curNode.getNextSibling();
		}
		return size;
	}

	@Override
	public int getHeight() {
		int hegiht=-1;
		//获取第一个子节点
		TreeLinkedList curNode=getFirstChild();
		//如果有子节点 递归进行
		while(null!=curNode){
			//递归获取子节点树
			hegiht=Math.max(hegiht,curNode.getHeight());
			//扫描兄弟节点
			curNode=curNode.getNextSibling();
		}
		return hegiht+1;
	}

	@Override
	public int getDepth() {
		int depth=0;
		//获取第一个子节点
		TreeLinkedList curNode=getParent();
		//如果有子节点 递归进行
		while(null!=curNode){
			//递归获取子节点树
			depth++;
			//扫描兄弟节点
			curNode=curNode.getParent();
		}
		return depth;
	}

}
