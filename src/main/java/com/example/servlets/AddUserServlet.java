package com.example.servlets;

import com.example.models.User;
import com.example.utils.MongoDBUtil;
import com.example.utils.OtpUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mobileNumber = req.getParameter("mobileNumber");

        System.out.println("Received request to add user with name: " + name + " and mobileNumber: " + mobileNumber);

        String otp = OtpUtil.generateOtp();
        System.out.println("Generated OTP: " + otp);

        User user = new User(name, mobileNumber);
        user.setOtp(otp);

        MongoDatabase database = MongoDBUtil.getDatabase();
        MongoCollection<Document> collection = database.getCollection("users");

        Document userDoc = new Document("name", name)
                .append("mobileNumber", mobileNumber)
                .append("otp", otp);

        collection.insertOne(userDoc);

        System.out.println("User with mobileNumber " + mobileNumber + " added to database with OTP: " + otp);

        req.setAttribute("message", "User added successfully. OTP sent to: " + mobileNumber);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
