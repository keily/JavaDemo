/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 * ��ջ�ӿ�
 */
public interface IStack {
	public boolean Push(Object element) throws Exception;
	public Object Pop() throws Exception;
	public Object Top() throws Exception;
	public boolean IsEmpty() throws Exception;
	public void Print() throws Exception;
}
