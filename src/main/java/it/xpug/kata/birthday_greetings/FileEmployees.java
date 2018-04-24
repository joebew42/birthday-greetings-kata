package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileEmployees implements Employees {
    private String filename;

    public FileEmployees(String filename) {
        this.filename = filename;
    }

    public List<Employee> all() {
        try {
            return readEmployees();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private List<Employee> readEmployees() throws IOException, ParseException {
        List<Employee> employees = new ArrayList<Employee>();
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String str = "";
        str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            employees.add(employee);
        }
        return employees;
    }
}
