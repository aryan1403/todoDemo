package com.aryan1403.DB;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class Service {
    MongoClient client = new MongoClient("localhost", 27017);
    MongoDatabase database = client.getDatabase("tododemo");
    MongoCollection<Document> collection = database.getCollection("testing");

    public void addTodo(int index, String todo) {
        collection.insertOne(new Document("id", index).append("todo", todo));
    }

    public FindIterable<Document> getAllTodo() {
        return collection.find();
    }

    public void delete(int index) {
        collection.deleteOne(Filters.eq("id", index));
    }
}
