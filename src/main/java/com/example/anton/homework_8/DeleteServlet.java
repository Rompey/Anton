package com.example.anton.homework_8;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        EmployeeRepository employeeRepository = new EmployeeRepository();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        employeeRepository.delete(id);
        response.sendRedirect("viewServlet");
    }
}