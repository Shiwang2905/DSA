package com.shiwang.challenges;

import java.util.Objects;
import java.util.Random;

public class Employee {

    private String employeeName;
    private int employeeId;

    public Employee(String employeeName, int employeeId) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee differentemployee = (Employee) o;
        return employeeId == differentemployee.employeeId && employeeName.equals(differentemployee.getEmployeeName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeName, employeeId)+employeeId;
    }
}
