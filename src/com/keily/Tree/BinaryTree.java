/**
 * 
 */
package com.keily.Tree;

/**
 * @author Administrator
 *
 */
public class BinaryTree {

	private int Data;
	private BinaryTree LeftNode,RightNode;
	/**
	 * 
	 */
	public BinaryTree(int data) {
		this.Data=data;
	}
	/**
	 * 
	 * @param node
	 */
	public void Insert(int node){
		if(node>Data){
			if(RightNode==null){
				RightNode = new BinaryTree(node);
			}
			else{
				RightNode.Insert(node);
			}
		}
		else{
			if(LeftNode==null){
				LeftNode = new BinaryTree(node);
			}
			else{
				LeftNode.Insert(node);
			}
		}
	}
	
	public boolean Find(int node){
		if(node>Data){
			if(RightNode==null){
				return false;
			}
			else{
				return RightNode.Find(node);
			}
		}
		else if(node<Data){
			if(LeftNode==null){
				return false;
			}
			else{
				return LeftNode.Find(node);
			}
		}
		else{
			return true;
		}
	}
	
	public void PreList(){
		System.out.print(this.Data+",");
		if(LeftNode!=null)
			LeftNode.PreList();
		if(RightNode!=null)
			RightNode.PreList();
	}
	
	public void MiddleList(){		
		if(LeftNode!=null)
			LeftNode.PreList();
		System.out.print(this.Data+",");
		if(RightNode!=null)
			RightNode.PreList();
	}
	
	public void AfterList(){		
		if(LeftNode!=null)
			LeftNode.PreList();
		if(RightNode!=null)
			RightNode.PreList();
		System.out.print(this.Data+",");
	}
}
