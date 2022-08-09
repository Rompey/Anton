package com.example.anton.homework_8;

import com.example.anton.homework_8.config.DatabaseConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class EmployeeRepository {

    private final DatabaseConfiguration databaseConfiguration;

    public EmployeeRepository(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }


    public int save(Customer customer) {
        int status = 0;
        try {
            Connection connection = databaseConfiguration.getConnection();
            PreparedStatement ps =
                    connection.prepareStatement("insert into customers(birthday,account, uuid, name) values (?,?,?,?)");
            ps.setString(3, UUID.randomUUID().toString());
            ps.setString(4, customer.getName());
            ps.setTimestamp(1, customer.getBirthday());
            ps.setBigDecimal(2, customer.getAccount());

            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public int update(Customer customer) {

        int status = 0;

        try {
            Connection connection = databaseConfiguration.getConnection();
            PreparedStatement ps =
                    connection.prepareStatement("update customers set name=?,birthday=?,account=? where uuid=?");
            ps.setString(3, customer.getName());
            ps.setTimestamp(1, customer.getBirthday());
            ps.setBigDecimal(2, customer.getAccount());
            ps.setString(4, UUID.randomUUID().toString());

            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public int delete(String uuid) {

        int status = 0;

        try {
            Connection connection = databaseConfiguration.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from customers where uuid=?");
            ps.setString(1, UUID.randomUUID().toString());
            status = ps.executeUpdate();

            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return status;
    }

    public Customer getEmployeeById(String uuid) {

        Customer customer = new Customer();

        try {
            Connection connection = databaseConfiguration.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customers where uuid=?");
            ps.setString(1, UUID.randomUUID().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer.setUuid(rs.getString(3));
                customer.setName(rs.getString(4));
                customer.setBirthday(rs.getTimestamp(1));
                customer.setAccount(rs.getBigDecimal(2));
            }
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getAllEmployees() {

        List<Customer> customerList = new ArrayList<>();

        try {
            Connection connection = databaseConfiguration.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setUuid(rs.getString(3));
                customer.setName(rs.getString(4));
                customer.setBirthday(rs.getTimestamp(1));
                customer.setAccount(rs.getBigDecimal(2));

                customerList.add(customer);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}