package com.da.test;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Demo3 implements PageProcessor {
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	static String baseUrl = "http://sou.zhaopin.com/jobs/searchresult.ashx?"
			+ "jl=长沙&kw=JAVA&sm=0&sg=6460312e6305442b8110692f839ba7ac&p=1";

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
	
		List<String> hrefs = page.getHtml().$("table.newlist td.zwmc div a", "href")
				.regex("http://jobs.zhaopin.com/\\w+.htm").all();
		page.addTargetRequests(hrefs);
	
		System.out.println("标题：" + page.getHtml().$("h1", "text").get());
		System.out.println("公司名：" + page.getHtml().$("h2 a", "text").get());
		System.out.println("公司链接：" + page.getHtml().$("h2 a", "href").get());
		System.out.println("福利：" + page.getHtml().$("div.welfare-tab-box span", "text").all());
		System.out.println("月薪：" + page.getHtml().$("div.terminalpage-left ul li:eq(0) strong", "text").get());
		System.out.println("工作地点：" + page.getHtml().$("div.terminalpage-left ul li:eq(1) strong a", "text").get()
				+ page.getHtml().$("div.terminalpage-left ul li:eq(1) strong", "text").get());
		System.out.println("工作年限：" + page.getHtml().$("div.terminalpage-left ul li:eq(4) strong", "text").get());
		System.out.println("招聘人数：" + page.getHtml().$("div.terminalpage-left ul li:eq(6) strong", "text").get());
		System.out.println("职位类别：" + page.getHtml().$("div.terminalpage-left ul li:eq(7) strong a", "text").get());
		List<String> list = page.getHtml().$("div.tab-inner-cont p", "text").replace("&nbsp;", "\r\n").all();
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			if (!s.trim().isEmpty()) {
				sb.append(s).append("\r\n");
			}
		}
		System.out.println(sb.toString());
		System.out.println("具体地址：" + page.getHtml().$("div.tab-inner-cont h2", "text").get());

	}

	public static void main(String[] args) {
		long startTime, endTime;
		System.out.println("开始爬取...");
		startTime = System.currentTimeMillis();
		Spider.create(new Demo3()).addUrl(baseUrl).thread(5).run();
		endTime = System.currentTimeMillis();
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");
	}

}