package edu.sabana.poob.sabanapayroll;//package sabananominatest;

import java.util.ArrayList;
import java.util.UUID;

public class Department {
    private UUID id;
    private String nombre;
    private ArrayList<Employee> arrEmpleado;

    public Department() {}

    public Department(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.arrEmpleado = arrEmpleado;
    }

    public Department(UUID id, String nombre, ArrayList<Employee> arrEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.arrEmpleado = arrEmpleado;
    }

    public Department(String engineering) {
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setArrEmpleado(ArrayList<Employee> arrEmpleado) {
        this.arrEmpleado = arrEmpleado;
    }

    public double calculateDepartmentSalaries() {
        double totalSalarios = 0.0;

        for (int i = 0; i < arrEmpleado.size(); i++)
            totalSalarios += arrEmpleado.get(i).calculateSalary();

        return totalSalarios;
    }

    public ArrayList<Employee> getEmployees() {
        return arrEmpleado;
    }
    }
