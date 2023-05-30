package trabajo3bases;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	public void mongoConn() {
		// Create a MongoClient using the URI
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		// Access the MongoDB database
		MongoDatabase database = mongoClient.getDatabase("trabajo3");

		// Access the collection
        MongoCollection<Document> collection = database.getCollection("totalventasporpais");

        // Create the filter
        Document filter = new Document("totalvendido", 200);

        // Execute the query
        List<Document> results = collection.find(filter).into(new ArrayList<>());
        
        // Process the results
        for (Document document : results) {
            System.out.println(document);
        }

        // Close the connection
        mongoClient.close();
	}
}
