package tp6;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class TestMongoDB {

	private MongoClient mongoClient = new MongoClient();
	private DB db = mongoClient.getDB("mydb");
	
	public TestMongoDB()throws UnknownHostException{
		super();
	}
	
	public void retCollections(){
		Set<String> colls = db.getCollectionNames();

		for (String s : colls) {
		    System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws UnknownHostException {
		
			TestMongoDB test = new TestMongoDB();
			test.mongoClient.dropDatabase("mydb");
			
			//-----------
			DBCollection coll = test.db.getCollection("testCollection");			
			BasicDBObject doc = new BasicDBObject("name", "MongoDB")
	        	.append("type", "database")
	        	.append("count", 1)
	        	.append("info", new BasicDBObject("x", 203).append("y", 102));
			coll.insert(doc);			
			//------------
			
			//test.retCollections();
			
			//------------
			
			DBObject myDoc = coll.findOne();
			System.out.println(myDoc);
			
			//------------
			
			for (int i=0; i < 100; i++) {
			    coll.insert(new BasicDBObject("i", i));
			}
			
			//------------
			
			System.out.println(coll.getCount());
			
			//------------
			
			DBCursor cursor = coll.find();
			try {
			   while(cursor.hasNext()) {
			       System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
			
			//------------
			
			BasicDBObject query = new BasicDBObject("i", 71);

			cursor = coll.find(query);

			try {
			   while(cursor.hasNext()) {
			       System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
			
			//------------
			
			//---------------------------------------
			test.mongoClient.close();

	}

}
