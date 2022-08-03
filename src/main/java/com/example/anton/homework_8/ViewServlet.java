package com.example.anton.homework_8;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<User> list = employeeRepository.getAllEmployees();

        for (User user : list) {
            out.print(user);
        }
        out.close();
    }
}