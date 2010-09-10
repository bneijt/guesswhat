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
	private final Mongo mongo;

	public MongoDBSecretNumberRepository() throws MongoException,
			UnknownHostException {
		mongo = new Mongo();
	}

	private DBCollection secretNumbers() {
		DB db = mongo.getDB("guesswhat");
		return db.getCollection("sercretNumbers");
	}

	@Override
	public SecretNumber secretOf(String name) {
		BasicDBObject query = new BasicDBObject();
		query.put("name", name);
		DBCursor cur = secretNumbers().find(query);
		if (!cur.hasNext())
			return new ImpossiblySecretNumber();
		DBObject document = cur.next();
		return new LongSecretNumber((Long) document.get("number"));
	}

	@Override
	public SecretNumber rememberSecret(String name,
			SecretNumber secretNumber) {
		if(name.isEmpty())
			throw new IllegalArgumentException("The given name is empty.");

		BasicDBObject doc = new BasicDBObject();

		doc.put("name", name);
		doc.put("number", secretNumber.getValue()); // /TODO UGLY! I should
													// actually use a good way to
													// serialize the
													// secretNumber or something
													// like that.

		secretNumbers().insert(doc);

		return secretNumber;
	}

	@Override
	public Set<String> people() {
		Set<String> p = new HashSet<String>();
		DBCursor cur = secretNumbers().find();

		while (cur.hasNext()) {
			DBObject document = cur.next();
			p.add((String) document.get("name"));
		}
		return p;
	}

}
