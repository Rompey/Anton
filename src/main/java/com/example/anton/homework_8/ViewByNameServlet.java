package com.example.anton.homework_8;

import com.example.anton.homework_8.config.DatabaseConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerRepository customerRepository = new CustomerRepository(new DatabaseConfiguration());
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String s = req.getParameter("name");
        String name = String.valueOf(s);

        Customer customer = customerRepository.getCustomerByName(name);

        printWriter.print(customer);
        printWriter.close();
    }
}
