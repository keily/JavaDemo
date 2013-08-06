/**
 * 
 */
package com.keily.Tree;

/**
 * @author Administrator
 * ��������洢�ṹ����ʵ��
 */
public class TreeLinkedList implements ITree{

	private Object element;//�ڵ�ֵ
	//���׽ڵ㣬��һ���ӽڵ㣬��һ���ֵܽڵ�
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
		int size=1;//���ڵ�Ϊ1
		//��ȡ��һ���ӽڵ�
		TreeLinkedList curNode=getFirstChild();
		//������ӽڵ� �ݹ����
		while(null!=curNode){
			//�ݹ��ȡ�ӽڵ���
			size+=curNode.getSize();
			//ɨ���ֵܽڵ�
			curNode=curNode.getNextSibling();
		}
		return size;
	}

	@Override
	public int getHeight() {
		int hegiht=-1;
		//��ȡ��һ���ӽڵ�
		TreeLinkedList curNode=getFirstChild();
		//������ӽڵ� �ݹ����
		while(null!=curNode){
			//�ݹ��ȡ�ӽڵ���
			hegiht=Math.max(hegiht,curNode.getHeight());
			//ɨ���ֵܽڵ�
			curNode=curNode.getNextSibling();
		}
		return hegiht+1;
	}

	@Override
	public int getDepth() {
		int depth=0;
		//��ȡ��һ���ӽڵ�
		TreeLinkedList curNode=getParent();
		//������ӽڵ� �ݹ����
		while(null!=curNode){
			//�ݹ��ȡ�ӽڵ���
			depth++;
			//ɨ���ֵܽڵ�
			curNode=curNode.getParent();
		}
		return depth;
	}

}
