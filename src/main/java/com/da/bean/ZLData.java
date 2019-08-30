package com.da.bean;

public class ZLData {
	private String title;// 标题
	private String company;// 公司名
	private String companyHref;// 公司链接
	private String welfare;// 福利
	private String money;// 月薪
	private String workPlace;// 工作地点
	private String workYear;// 工作年限
	private String needPerson;// 招聘人数
	private String workType;// 职位类别
	private String details;// 细节要求
	private String detailPlace;// 具体地址

	public ZLData() {
		super();
	}

	public ZLData(String title, String company, String companyHref, String welfare, String money, String workPlace,
			String workYear, String needPerson, String workType, String details, String detailPlace) {
		super();
		this.title = title;
		this.company = company;
		this.companyHref = companyHref;
		this.welfare = welfare;
		this.money = money;
		this.workPlace = workPlace;
		this.workYear = workYear;
		this.needPerson = needPerson;
		this.workType = workType;
		this.details = details;
		this.detailPlace = detailPlace;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyHref() {
		return companyHref;
	}

	public void setCompanyHref(String companyHref) {
		this.companyHref = companyHref;
	}

	public String getWelfare() {
		return welfare;
	}

	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getNeedPerson() {
		return needPerson;
	}

	public void setNeedPerson(String needPerson) {
		this.needPerson = needPerson;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetailPlace() {
		return detailPlace;
	}

	public void setDetailPlace(String detailPlace) {
		this.detailPlace = detailPlace;
	}

	@Override
	public String toString() {
		return "ZLData [title=" + title + ", company=" + company + ", companyHref=" + companyHref + ", welfare="
				+ welfare + ", money=" + money + ", workPlace=" + workPlace + ", workYear=" + workYear + ", needPerson="
				+ needPerson + ", workType=" + workType + ", details=" + details + ", detailPlace=" + detailPlace + "]";
	}

}
