package dto;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBDao {
	private static MongoDBDao mongo=new MongoDBDao();
	private MongoDBDao() {}
	
	public static MongoDBDao getMongo() {
		return mongo;
	}
	
	public ArrayList<Employee> find(){
		MongoClient mongoClient=new MongoClient( "localhost" , 27017 );
		ArrayList<Employee> list=new ArrayList<Employee>();
		MongoDatabase db=mongoClient.getDatabase("test");
		MongoCollection<Document>collection=db.getCollection("employees");
		MongoCursor<Document> cursor=collection.find().iterator();
		
		while(cursor.hasNext()) {
			Employee emp=new Employee();
			Document doc=cursor.next();
			//String JsonResult=doc.toJson();
			emp.setEmpno(doc.getDouble("empno"));
			emp.setEname(doc.getString("ename"));
			emp.setJob(doc.getString("job"));
			emp.setHiredate(doc.getDate("hiredate"));
			emp.setDeptno(doc.getDouble("deptno"));
			list.add(emp);
		}
		mongoClient.close();
		return list;
	}
	public void insert(Employee emp){
		MongoClient mongoClient=new MongoClient( "localhost" , 27017 );
		MongoDatabase db=mongoClient.getDatabase("test");
		MongoCollection<Document>collection=db.getCollection("employees");
		Document doc = new Document("empno",emp.getEmpno())
				.append("ename", emp.getEname())
				.append("job", emp.getJob())
				.append("hiredate", emp.getHiredate())
				.append("deptno", emp.getDeptno());
		collection.insertOne(doc);
		mongoClient.close();
	}
	public Employee findOne(double empno){
		Employee emp = new Employee();
		MongoClient mongoClient=new MongoClient( "localhost" , 27017 );
		MongoDatabase db=mongoClient.getDatabase("test");
		MongoCollection<Document>collection=db.getCollection("employees");
		BasicDBObject inQuery = new BasicDBObject();
		inQuery.put("empno", empno);
		MongoCursor<Document> cursor=collection.find(inQuery).iterator();

		if(cursor.hasNext()) {
			emp=new Employee();
			Document doc = cursor.next();
			emp.setEmpno(doc.getDouble("empno"));
			emp.setEname(doc.getString("ename"));
			emp.setJob(doc.getString("job"));
			emp.setHiredate(doc.getDate("hiredate"));
			emp.setDeptno(doc.getDouble("deptno"));
		}
		mongoClient.close();
		return emp;
	}
	public void update(Employee emp){
		MongoClient mongoClient=new MongoClient( "localhost" , 27017 );
		MongoDatabase db=mongoClient.getDatabase("test");
		MongoCollection<Document>collection=db.getCollection("employees");

		BasicDBObject inQuery = new BasicDBObject();
		inQuery.put("empno", emp.getEmpno());
		System.out.println(emp.getJob());
		BasicDBObject newDoc = new BasicDBObject()
				.append("$set", new BasicDBObject("ename",emp.getEname())
						.append("job",emp.getJob())
						.append("deptno",emp.getDeptno()));
//		newDoc.put("ename", emp.getEname()
		collection.updateOne(inQuery, newDoc);
		mongoClient.close();
	}
	public void delete(Double empno){
		MongoClient mongoClient=new MongoClient( "localhost" , 27017 );
		MongoDatabase db=mongoClient.getDatabase("test");
		MongoCollection<Document>collection=db.getCollection("employees");
		
		BasicDBObject inQuery = new BasicDBObject();
		inQuery.put("empno", empno);
		collection.deleteOne(inQuery);
		mongoClient.close();
	}
}