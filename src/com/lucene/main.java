package com.lucene;

import fx.sunjoy.*;
/**
 * @author Administrator
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		//TxtFileIndexer.index();

		//TxtFileIndexer.search(new String[]{"name","desc"},"�Ծ�");


		Seg seg = new Seg();
		seg.useDefaultDict();
		System.out.println(seg.cut("���������������û��̫�������, ����Java�ṩ��ǿ��ת�����ơ�������"));
		System.out.println(seg.cut("�������������ũ��Ʒ��ӹ���Ŀ"));
		System.out.println(seg.cut("�������ũ��Ʒ�г����޹�˾"));
		System.out.println(seg.cut("�ۺ�¥������,�����س���[2012]07032��,�������������豸�������޹�˾,��Ӷ�ʮ��33��"));

		/*
		BigData bg=new BigData();
		bg.TestBigDataAdd();
		*/
	}

}