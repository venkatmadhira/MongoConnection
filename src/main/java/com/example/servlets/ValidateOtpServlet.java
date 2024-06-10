package com.example.servlets;

import com.example.utils.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

public class ValidateOtpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mobileNumber = req.getParameter("mobileNumber");
        String otp = req.getParameter("otp");

        System.out.println("Received request for mobileNumber: " + mobileNumber + " with OTP: " + otp);

        MongoDatabase database = MongoDBUtil.getDatabase();
        MongoCollection<Document> collection = database.getCollection("users");

        Document user = collection.find(eq("mobileNumber", mobileNumber)).first();

        String message;
        if (user != null) {
            String storedOtp = user.getString("otp");
            System.out.println("Stored OTP for mobileNumber " + mobileNumber + " is: " + storedOtp);
            if (otp.equals(storedOtp)) {
                message = "OTP validated successfully.";
            } else {
                message = "Invalid OTP.";
            }
        } else {
            System.out.println("User with mobileNumber " + mobileNumber + " not found.");
            message = "User not found.";
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
