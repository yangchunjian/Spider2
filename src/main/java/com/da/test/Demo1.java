package com.da.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Demo1 implements PageProcessor {
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {

		page.addTargetRequests(page.getHtml().xpath("").all());

		page.addTargetRequests(page.getHtml().$("div.title a", "href").all());

		System.out.println(page.getHtml().$("h1.main", "title"));

	}

	public static void main(String[] args) {
		long startTime, endTime;
		System.out.println("开始爬取...");
		startTime = System.currentTimeMillis();
		Spider.create(new Demo1()).addUrl("https://cs.lianjia.com/ershoufang/yuelu/").thread(5).run();
		endTime = System.currentTimeMillis();
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");
	}

}