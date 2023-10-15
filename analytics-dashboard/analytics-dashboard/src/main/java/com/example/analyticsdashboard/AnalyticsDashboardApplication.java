package com.example.analyticsdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class AnalyticsDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsDashboardApplication.class, args);
		String uri = "mongodb+srv://brunda:lpkojihu@insight-pulse.udmyfqn.mongodb.net/?retryWrites=true&w=majority";
		ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();

		try (MongoClient mongoClient = MongoClients.create(settings)) {
	        MongoDatabase database = mongoClient.getDatabase("insights-pulse");
	        MongoCollection<Document> collection = database.getCollection("subscribers");
	        Document doc = collection.find(eq("name", "Josh")).first();
	        if (doc != null) {
	            System.out.println(doc.toJson());
	        } else {
	            System.out.println("No matching documents found.");
	        }
	    }
	}

}
