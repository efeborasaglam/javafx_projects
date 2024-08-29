package _implementierung;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

public class MongoDBUtil {

    private static final String CONNECTION_STRING = "mongodb+srv://efeborasaglam:Efe05St_Gallen@restfullapi.tex7t7x.mongodb.net/";
    private static final String DATABASE_NAME = "java";
    private static final String COLLECTION_NAME = "register";

    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    static {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MongoCollection<Document> getUsersCollection() {
        return database.getCollection(COLLECTION_NAME);
    }

    public static void insertUser(String username, String password) {
        MongoCollection<Document> collection = getUsersCollection();
        Document user = new Document("username", username)
                        .append("password", password);
        collection.insertOne(user);
    }

    public static boolean verifyUser(String username, String password) {
        MongoCollection<Document> collection = getUsersCollection();
        Bson filter = Filters.and(Filters.eq("username", username), Filters.eq("password", password));
        Document user = collection.find(filter).first();
        return user != null;
    }
}
