package edu.sabana.poob.sabanapayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompensarFund implements IFamilyCompensationFund {

    private static List<Employee> registeredEmployees = new ArrayList<>();

    @Override
    public boolean registerEmployee(Employee employee) {

        boolean resultado = false;
        if (employee.getClass() != EmployeebyHours.class) {
            if (!isEmployeeRegistered(employee.getId())) {
                registeredEmployees.add(employee);
                resultado = true;
            }
        }
        return resultado;
    }


    @Override
    public boolean deleteEmployee(UUID id) {

    boolean isEmployee = false;

        for(int i = 0;i<registeredEmployees.size()&&!isEmployee;i++)

    {
        if (registeredEmployees.get(i).getId() == id) {
            registeredEmployees.remove(registeredEmployees.get(i));
            isEmployee = true;
        }
    }
        return isEmployee;
}

    @Override
    public boolean isEmployeeRegistered(UUID id) {

    boolean isEmployee = false;
        for(int i=0;i< registeredEmployees.size() && !isEmployee;i++){

            if(registeredEmployees.get(i).getId() == id) {

                isEmployee = true;
           }
         }
        return isEmployee;
    }

    @Override
    public String printBenefits() {

            return "\n"+("");
        }
    }

