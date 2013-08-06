/**
 * 
 */
package com.keily.Tree;

/**
 * @author Administrator
 *
 */
public interface ITree {
	/*
	 * 获取当前节点值
	 * */
	public Object getElem(Object obj);
	/*
	 * 设置当前节点值，并返回旧值
	 * */
	public Object setElem(Object obj);
	/*
	 * 获取当前节点的父节点
	 * */
	public TreeLinkedList getParent();
	/*
	 * 获取当前节点的第一个子节点
	 * */
	public TreeLinkedList getFirstChild();
	/*
	 * 获取当前节点的下一个兄弟节点
	 * */
	public TreeLinkedList getNextSibling();
	/*
	 * 获取当前节点数
	 * */
	public int getSize();
	/*
	 * 获取当前树高度
	 * */
	public int getHeight();
	/*
	 * 获取当前数深度
	 * */
	public int getDepth();
}
