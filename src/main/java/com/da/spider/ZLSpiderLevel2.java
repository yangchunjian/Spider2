package com.da.spider;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class ZLSpiderLevel2 implements PageProcessor {
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

		page.putField("title", page.getHtml().$("h1", "text").get());
		page.putField("company", page.getHtml().$("h2 a", "text").get());
		page.putField("companyHref", page.getHtml().$("h2 a", "href").get());
		page.putField("welfare", page.getHtml().$("div.welfare-tab-box span", "text").all().toString());
		page.putField("money", page.getHtml().$("div.terminalpage-left ul li:eq(0) strong", "text").get());
		page.putField("workPlace", page.getHtml().$("div.terminalpage-left ul li:eq(1) strong a", "text").get()
				+ page.getHtml().$("div.terminalpage-left ul li:eq(1) strong", "text").get());
		page.putField("workYear", page.getHtml().$("div.terminalpage-left ul li:eq(4) strong", "text").get());
		page.putField("needPerson", page.getHtml().$("div.terminalpage-left ul li:eq(6) strong", "text").get());
		page.putField("workType", page.getHtml().$("div.terminalpage-left ul li:eq(7) strong a", "text").get());
		List<String> list = page.getHtml().$("div.tab-inner-cont p", "text").replace("&nbsp;", "").all();
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			if (!s.trim().isEmpty()) {
				sb.append(s).append("\r\n");
			}
		}
		page.putField("details", sb.toString());
		page.putField("detailPlace", page.getHtml().$("div.tab-inner-cont h2", "text").get());
	}

}