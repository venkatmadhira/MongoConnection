package com.example.utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
    private static final String DATABASE_NAME = "restaurantDB";
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }
}
