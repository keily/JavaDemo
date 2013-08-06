/**
 * 
 */
package com.keily.Sort;

import com.keily.BigData.*;
import com.keily.List.*;
import com.keily.Tree.*;

/**
 * @author Administrator
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//快速排序
		//QuickSort quickSort=new QuickSort();
		
		//树
		/*
		TreeLinkedList root=new TreeLinkedList();
		
		*/
		
		//二叉树
		/*
		int[] treeArr=new int[]{1,32,13,11,45,81,65,63,83,87};
		for(int i=0;i<10;i++){
			treeArr[i]=(int)(Math.random()*100)+1;
			System.out.print(treeArr[i]+",");
		}
		//1,32,13,11,45,81,65,63,83,87,
		BinaryTree root= new BinaryTree(treeArr[0]);
		for(int i=1;i<treeArr.length;i++){
			root.Insert(treeArr[i]);
		}
		
		if(root.Find(treeArr[3]))
			System.out.println("\nFind:"+treeArr[3]);
				
		System.out.println("MiddleList：");
		root.MiddleList();
		System.out.println("\nPreList：");
		root.PreList();
		System.out.println("\nAfterList:");
		root.AfterList();*/
		
		//顺序表
		/*IList seqlist = new SeqList();
		seqlist.Insert(1);
		seqlist.Insert(2);
		seqlist.Insert(3);
		seqlist.Insert(0,0);
		seqlist.Insert(2,10);
		seqlist.Insert(1,9);
		seqlist.Print();
		System.out.println("\nDelete(2)");
		seqlist.Delete(2);
		seqlist.Print();
		System.out.println("\nUpdate(1, 1111)"+seqlist.Update(1, 1111));
		seqlist.Print();
		System.out.println("Find(111)"+seqlist.Find(1111));
		seqlist.Sort();
		System.out.println("After Sort:" );
		seqlist.Print();*/
		
		//链表
		/*LinkList linklist = new LinkList();
		linklist.Insert(1);
		linklist.Insert(3);
		linklist.Insert(1,2);
		linklist.Insert(0,0);
		linklist.Insert(3,33);
		linklist.Print();
		System.out.println("Length:" + linklist.GetLength());
		linklist.Delete(0);
		linklist.Update(3, 1);		
		linklist.Print();
		System.out.println("Find:3/s location" + linklist.Find(3));
		while(!linklist.IsEmpty()){
			linklist.Delete(0);
		}
		linklist.Print();
		linklist.Insert(2);
		linklist.Insert(8);
		linklist.Insert(2);
		linklist.Insert(8);
		linklist.Insert(2);
		Object del = new Object();
		del =2;
		linklist.Delete(del);
		del =81;
		linklist.Delete(del);
		linklist.Print();*/
		
		//栈
		/*IStack stack = new SeqStack();
		stack.Push(5);
		stack.Push(15);
		stack.Push(35);
		stack.Pop();
		System.out.println("Top:" + stack.Top());
		stack.Print();
		
		stack = new LinkStack();
		stack.Push(5);
		stack.Push(15);
		stack.Push(35);
		stack.Pop();
		System.out.println("Top:" + stack.Top());
		stack.Print();*/
		
		//队列
		/*
		IQueue queue=new CycleQueue();
		queue.Append('A');
		queue.Append('B');
		queue.Append('C');
		queue.Append('D');
		queue.Append('E');
		System.out.println("length:"+queue.Length()+",front:"+queue.Front());
		while(!queue.IsEmpty())
			System.out.println("out:"+queue.Delete());
		*/
		
		
		//大数据相加
		/*BigData bg=new BigData();
		bg.TestBigDataAdd();*/
		
		
	}

}
