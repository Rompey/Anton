package com.example.anton.homework_8;

import com.example.anton.homework_8.config.DatabaseConfiguration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/viewByIdServlet")
public class ViewByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        CustomerRepository customerRepository = new CustomerRepository(new DatabaseConfiguration());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("uuid");
        String uuid = String.valueOf(sid);

        Customer customer = customerRepository.getCustomerById(uuid);

        out.print(customer);
        out.close();
    }
}
