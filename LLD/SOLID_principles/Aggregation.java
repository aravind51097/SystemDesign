package LLD.SOLID_principles;

import java.util.*;

// Department Class
class Department {
    private List<Employee> employees;

    public Department(List<Employee> employees) {
        this.employees = employees;
    }
}

// Employee Class
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}

class Aggregation {
    public static void main(String[] args) {
        System.out.println("Aggregation :: ");
    }
}
