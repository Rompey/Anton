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

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        EmployeeRepository employeeRepository = new EmployeeRepository(new DatabaseConfiguration());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        double account = Double.parseDouble(request.getParameter("account"));

        Customer customer = new Customer();

        customer.setName(name);
        customer.setAccount(new BigDecimal(account));
        customer.setBirthday(new Timestamp(new Date().getTime()));

        int status = employeeRepository.save(customer);

        if (status > 0) {
            out.print("Record saved successfully!");
        } else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}
