package edu.sabana.poob.sabanapayroll;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ColsubsidioFund<resultado1> implements IFamilyCompensationFund {

    static Map<UUID, Employee> registeredEmployees = new HashMap<>();
    private  Employee employee;
    public ColsubsidioFund() {

    }

    @Override
    public boolean registerEmployee(Employee employee) {

        boolean resultado = false;
        if (employee.getClass() != EmployeeCommissioned.class) {
            if (!isEmployeeRegistered(employee.getId())) {
                registeredEmployees.put(employee.getId(), employee);
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public boolean deleteEmployee(UUID id) {

        boolean resultado = false;

        if(isEmployeeRegistered(id))
        {
            registeredEmployees.remove(id);
            resultado = true;
        }
        return resultado;
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) {

        boolean resultado = false;
        if(registeredEmployees.containsKey(id))
        {
            resultado = true;
        }
        return resultado;
    }

    @Override
    public String printBenefits() {

            return "\n"+("");
        }
    }

