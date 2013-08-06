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

		//TxtFileIndexer.search(new String[]{"name","desc"},"苍井");


		Seg seg = new Seg();
		seg.useDefaultDict();
		System.out.println(seg.cut("至于在这个程序中没有太大的意义, 这是Java提供的强制转化机制。草泥马"));
		System.out.println(seg.cut("润恒冷链物流及农产品深加工项目"));
		System.out.println(seg.cut("沈阳润恒农产品市场有限公司"));
		System.out.println(seg.cut("综合楼及厂房,沈政地出字[2012]07032号,沈阳亚特重型设备制造有限公司,浑河二十街33号"));

		/*
		BigData bg=new BigData();
		bg.TestBigDataAdd();
		*/
	}

}