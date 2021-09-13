package com.aryan1403.DB;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Service {
    // Creating a MongoClient to connect to the database
    MongoClient client = new MongoClient("localhost", 27017);
    // Creating a Database
    MongoDatabase database = client.getDatabase("tododemo");
    // Creating a Collection
    MongoCollection<Document> collection = database.getCollection("testing");

    /*
     * Adding Todo to the Databse
     * Params : index & Todo
     * return type : void
    */
    public void addTodo(int index, String todo) {
        collection.insertOne(new Document("id", index).append("todo", todo));
    }

    /*
     * Finding all the Documents from the Collection
     * Params : null
     * return type : Iterable
    */
    public FindIterable<Document> getAllTodo() {
        return collection.find();
    }

    /*
     * Delete a particular document inside a collection
     * params : index
     * return type : void
    */
    public void delete(int index) {
        collection.deleteOne(Filters.eq("id", index));
    }
}
