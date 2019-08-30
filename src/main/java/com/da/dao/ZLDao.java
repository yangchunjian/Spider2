package com.da.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ZLDao {
	// 1.建立一个Mongo的数据库连接对象
	private MongoClient mongoClient = null;
	// 2.创建相关数据库的连接
	private MongoDatabase mongoDatabase = null;

	public ZLDao(String dbName) {
		mongoClient = new MongoClient("localhost", 27017);
		mongoDatabase = mongoClient.getDatabase(dbName);
	}

	public ZLDao() {
		mongoClient = new MongoClient("localhost", 27017);
		mongoDatabase = mongoClient.getDatabase("foobar");
	}

	/**
	 * 创建一个数据库集合
	 * 
	 * @param collName
	 *            集合名称
	 * @param mongoDatabase
	 *            数据库实例
	 */
	public void createCollection(String collName) {
		mongoDatabase.createCollection(collName);
	}

	/**
	 * 为相应的集合添加数据
	 */
	public void insert(Document doc, String collName) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		// 2.插入操作
		collection.insertOne(doc);
	}

	/**
	 * 为集合批量插入数据
	 */
	public void insert(List<Document> docs, String collName) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		// 2.插入操作
		collection.insertMany(docs);
	}

	/**
	 * 根据条件删除数据
	 */
	public void deleteByName(String name, String value, String collName) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.deleteOne(Filters.eq(name, value));
	}

	/**
	 * 更新数据
	 */
	public void update(String collName, Document find, Document doc) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.updateOne(find, doc);
	}

	/**
	 * 批量更新数据
	 */
	public void batchUpdate(String collName, Document find, Document doc) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		collection.updateMany(find, doc);
	}

	/**
	 * 查询器(不分页)
	 */
	public MongoCursor<Document> find(Document doc, String collName) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		FindIterable<Document> findIterable = collection.find(doc);
		// System.out.println(collection.count());
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		return mongoCursor;
	}

	/**
	 * 查询器(分页,排序)
	 */
	public MongoCursor<Document> find(Document doc, String collName, Integer page, Integer size, Document sort) {
		// 1.得到集合
		MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		FindIterable<Document> findIterable = null;
		if (sort != null) {
			findIterable = collection.find(doc).limit(size).skip((page - 1) * size).sort(sort);
		} else {
			findIterable = collection.find(doc).limit(size).skip((page - 1) * size);
		} // System.out.println(collection.count());
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		return mongoCursor;
	}
}
