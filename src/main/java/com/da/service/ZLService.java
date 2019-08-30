package com.da.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.alibaba.fastjson.JSON;
import com.da.bean.ZLData;
import com.da.dao.ZLDao;
import com.da.utils.BeanMapUtils;
import com.mongodb.client.MongoCursor;

public class ZLService {
	private static String dbName = "zldata";
	private ZLDao dao = new ZLDao();

	public void saveZLDatas(List<ZLData> datas) {
		List<Document> docs = new ArrayList<>();
		for (ZLData data : datas) {
			Document doc = new Document(BeanMapUtils.beanToMap(data));
			docs.add(doc);
		}

		dao.insert(docs, dbName);
	}

	public void saveZLData(ZLData data) {
		Document doc = new Document(BeanMapUtils.beanToMap(data));
		dao.insert(doc, dbName);
	}

	public void saveZLData(Map<String, Object> data) {
		Document doc = new Document(data);
		dao.insert(doc, dbName);
	}

	public List<ZLData> getZLDatas(int page, int size) {
		page = page == 0 ? 1 : page;
		size = size == 0 ? 10 : size;
		List<ZLData> infos = new ArrayList<>();
		MongoCursor<Document> cursor = dao.find(new Document(), dbName, page, size, null);
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			String json = doc.toJson();
			ZLData info = JSON.parseObject(json, ZLData.class);
			infos.add(info);
		}
		return infos;
	}
}
