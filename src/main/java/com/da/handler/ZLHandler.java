package com.da.handler;

import java.util.List;

import com.da.bean.ZLData;
import com.da.service.ZLService;

public class ZLHandler {
	private ZLService service = new ZLService();

	public void getZLDatas(int page, int size) {
		List<ZLData> datas = service.getZLDatas(page, size);
		for (ZLData d : datas) {
			System.out.println("招聘：" + d.getTitle());
			System.out.println("公司名：" + d.getCompany());
			System.out.println("公司链接：" + d.getCompanyHref());
			System.out.println("福利：" + d.getWelfare());
			System.out.println("月薪：" + d.getMoney());
			System.out.println("工作地点：" + d.getWorkPlace());
			System.out.println("工作年限：" + d.getWorkYear());
			System.out.println("招聘人数：" + d.getNeedPerson());
			System.out.println("职位类别：" + d.getWorkType());
			System.out.println("具体地址：" + d.getDetailPlace());
			System.out.println(d.getDetails());
			System.out.println("---------------------------------------");
		}
	}
}
