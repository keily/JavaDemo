/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 *
 */
public interface IQueue {
	public void Append(Object element)throws Exception;
	public Object Delete()throws Exception;
	public Object Front()throws Exception;
	public boolean IsEmpty()throws Exception;
	public int Length()throws Exception;
}
