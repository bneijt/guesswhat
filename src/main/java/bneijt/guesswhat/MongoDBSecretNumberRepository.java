package bneijt.guesswhat;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoDBSecretNumberRepository implements SecretNumberRespository {
	private DBCollection coll;

	public MongoDBSecretNumberRepository() throws MongoException, UnknownHostException {
		Mongo m = new Mongo();
		DB db = m.getDB( "guesswhat" );
		coll = db.getCollection("sercretNumbers");
	}
	
	@Override
	public SecretNumber secretOf(String name) {
		BasicDBObject query = new BasicDBObject();
        query.put("name", name);
        DBCursor cur = coll.find(query);
		if(!cur.hasNext())
			return new ImpossiblySecretNumber();
        DBObject document = cur.next(); 
		return new LongSecretNumber((Long) document.get("number"));
	}

	@Override
	public SecretNumber rememberSecret(String name,
			LongSecretNumber secretNumber) {
		BasicDBObject doc = new BasicDBObject();

        doc.put("name", name);
        doc.put("number", secretNumber);

        coll.insert(doc);

		return secretNumber;
	}

	@Override
	public Set<String> people() {
		Set<String> p = new HashSet<String>();
		 DBCursor cur = coll.find();

	        while(cur.hasNext()) {
	        	DBObject document = cur.next();
	            p.add((String) document.get("name"));
	        }
		return p;
	}

}
