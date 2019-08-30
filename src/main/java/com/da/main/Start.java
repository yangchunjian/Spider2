package com.da.main;

import com.da.handler.ZLHandler;
import com.da.spider.ZLSpiderLevel1;

import us.codecraft.webmagic.Spider;

public class Start {
	static String baseUrl = "http://sou.zhaopin.com/jobs/searchresult.ashx?"
			+ "jl=%e9%95%bf%e6%b2%99&kw=JAVA&sm=0&sg=6460312e6305442b8110692f839ba7ac&p=1";

	public static void main(String[] args) {
		//Spider.create(new ZLSpiderLevel1()).addUrl(baseUrl).thread(5).run();
		new ZLHandler().getZLDatas(1, 10);
	}
}
