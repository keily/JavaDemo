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
	 * ��ȡ��ǰ�ڵ�ֵ
	 * */
	public Object getElem(Object obj);
	/*
	 * ���õ�ǰ�ڵ�ֵ�������ؾ�ֵ
	 * */
	public Object setElem(Object obj);
	/*
	 * ��ȡ��ǰ�ڵ�ĸ��ڵ�
	 * */
	public TreeLinkedList getParent();
	/*
	 * ��ȡ��ǰ�ڵ�ĵ�һ���ӽڵ�
	 * */
	public TreeLinkedList getFirstChild();
	/*
	 * ��ȡ��ǰ�ڵ����һ���ֵܽڵ�
	 * */
	public TreeLinkedList getNextSibling();
	/*
	 * ��ȡ��ǰ�ڵ���
	 * */
	public int getSize();
	/*
	 * ��ȡ��ǰ���߶�
	 * */
	public int getHeight();
	/*
	 * ��ȡ��ǰ�����
	 * */
	public int getDepth();
}
