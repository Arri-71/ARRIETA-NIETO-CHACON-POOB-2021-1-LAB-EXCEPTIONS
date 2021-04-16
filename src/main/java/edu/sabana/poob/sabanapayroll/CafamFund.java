package edu.sabana.poob.sabanapayroll;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class CafamFund implements IFamilyCompensationFund {

    public static final Set<Employee> registeredEmployees = new HashSet<Employee>();

    @Override
    public boolean registerEmployee(Employee employee) {
        boolean resultado = false;

        if (employee.getClass() != EmployeeCommissioned.class) {
            if (!isEmployeeRegistered(employee.getId())) {
                resultado = registeredEmployees.add(employee);
            }
        }

        return resultado;
    }

    @Override

    public boolean deleteEmployee(UUID id) {

        boolean resultado = false;
        Iterator<Employee> it = null;

        try {
            if (registeredEmployees.iterator() != null) {
                it = registeredEmployees.iterator();
            }

            while (!resultado && it.hasNext()) {
                Employee employee1 = it.next();
                if (employee1.getId() == id) {
                    registeredEmployees.remove(employee1);
                    resultado = true;
                }
            }
        } catch(Exception ex) { }
        return resultado;
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) {
        boolean resultado = false;
        Iterator<Employee> it = null;

        try {
            if (registeredEmployees.iterator() != null) {
                it = registeredEmployees.iterator();
            }

            while (!resultado && it.hasNext()) {
                Employee employee1 = it.next();
                if (employee1.getId() == id) {
                    resultado = true;
                }
            }
        } catch(Exception ex) { }

        return resultado;
    }

    @Override
    public String printBenefits() {
            return ""+("");
        }
    }
