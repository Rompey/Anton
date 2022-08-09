package com.example.anton.homework_8;

import com.example.anton.homework_8.config.DatabaseConfiguration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/putServlet")
public class PutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        EmployeeRepository employeeRepository = new EmployeeRepository(new DatabaseConfiguration());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        String uuid = String.valueOf(sid);

        String name = request.getParameter("name");
        double account = Double.parseDouble(request.getParameter("account"));

        Customer customer = new Customer();
        customer.setUuid(uuid);
        customer.setName(name);
        customer.setBirthday(new Timestamp(new Date().getTime()));
        customer.setAccount(new BigDecimal(account));

        int status = employeeRepository.update(customer);

        if (status > 0) {
            response.sendRedirect("viewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }
        out.close();
    }
}