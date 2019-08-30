package com.da.test;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Demo4 implements PageProcessor {
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	static String baseUrl = "http://sou.zhaopin.com/jobs/searchresult.ashx?"
			+ "jl=%e9%95%bf%e6%b2%99&kw=JAVA&sm=0&sg=6460312e6305442b8110692f839ba7ac&p=1";

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		List<String> hrefs = page.getHtml().$("div.pagesDown ul li a", "href")
				.regex("http://sou.zhaopin.com/jobs/searchresult.ashx\\?"
						+ "jl=%e9%95%bf%e6%b2%99&kw=JAVA&sm=0&sg=6460312e6305442b8110692f839ba7ac&p=[2-8]{1}")
				.all();
		page.addTargetRequests(hrefs);
		String url = page.getUrl().toString();
		System.out.println(url);

	}

	public static void main(String[] args) {
		long startTime, endTime;
		System.out.println("开始爬取...");
		startTime = System.currentTimeMillis();
		Spider.create(new Demo4()).addUrl(baseUrl).thread(5).run();
		endTime = System.currentTimeMillis();
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");
	}

}