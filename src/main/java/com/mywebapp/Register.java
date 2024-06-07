package com.mywebapp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {
    private MongoClient mongoClient;

    @Override
    public void init() throws ServletException {
        super.init();

        String connectionString = "mongodb://localhost:27017";
        mongoClient = MongoClients.create(connectionString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("users");

        Document user = new Document("username", username)
                .append("email", email);

        collection.insertOne(user);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>User registered successfully!</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();

        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
