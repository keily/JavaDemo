/**
 * 
 */
package com.keily.List;

/**
 * @author Administrator
 *
 */
public interface IList {
	public void Insert(int index ,Object element) throws Exception;
	public void Insert(Object element) throws Exception;
	public boolean Update(int index ,Object element) throws Exception;
	public void Delete(Object element) throws Exception;
	public void Delete(int index) throws Exception;
	public Object GetData(int index)throws Exception;
	public int GetLength() throws Exception;
	public int Find(Object element) throws Exception;
	public boolean IsEmpty() throws Exception;
	public void Print() throws Exception;
	public void Sort() throws Exception;
}
