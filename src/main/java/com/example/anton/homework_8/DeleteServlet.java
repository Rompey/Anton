package com.example.anton.homework_8;

import com.example.anton.homework_8.config.DatabaseConfiguration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        CustomerRepository customerRepository = new CustomerRepository(new DatabaseConfiguration());
        String sid = request.getParameter("uuid");
        String uuid = String.valueOf(sid);
        customerRepository.delete(uuid);
        response.sendRedirect("viewServlet");
    }
}