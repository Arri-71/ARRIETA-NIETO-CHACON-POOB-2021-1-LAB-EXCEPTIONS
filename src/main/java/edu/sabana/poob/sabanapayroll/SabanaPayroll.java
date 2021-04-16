package edu.sabana.poob.sabanapayroll;

import java.util.*;

public class SabanaPayroll {

    private ArrayList<Object> department;
    private Collection<Employee> employees;
    private Map<String, IFamilyCompensationFund> compensationFunds;
    private static ArrayList<Department> arrDeptos;
    private static ArrayList<BankAccount> arrAccounts;

    public SabanaPayroll() {
    }

    public SabanaPayroll(ArrayList<Department> arrDeptos) {
        this.arrDeptos = arrDeptos;
    }

    public double calculateEmployeeSalary(UUID employeeId) {
        double salary = 0.0;
        boolean hallado = false;
        for (int i = 0; i < arrDeptos.size() && !hallado; i++) {   // recorre ArrayList Department

            for (int j = 0; j < arrDeptos.get(i).getEmployees().size() && !hallado; j++) {   // recorre ArrayList Employee
                if (arrDeptos.get(i).getEmployees().get(j).getId().equals(employeeId)) {
                    hallado = true;
                    salary = arrDeptos.get(i).getEmployees().get(j).calculateSalary();
                }
            }
        }
        if (!hallado)
            System.out.println("Empleado con UUID: " + employeeId + " no hallado.\n");
        return salary;
    }

    public double calculateDepartmentSalaries(UUID departmentId) {
        double salary = 0.0;
        boolean hallado = false;
        for (int i = 0; i < arrDeptos.size() && !hallado; i++) {   // recorre ArrayList Department

            if (arrDeptos.get(i).getId().equals(departmentId)) {
                hallado = true;
                salary = arrDeptos.get(i).calculateDepartmentSalaries();
            }
        }
        if (!hallado)
            System.out.println("Departamento con UUID: " + departmentId + " no hallado.\n");
        return salary;
    }

    public double calculateUniversitySalaries() {
        double totalSalarios = 0.0;

        for (Department arrDepto : arrDeptos) {
            totalSalarios += arrDepto.calculateDepartmentSalaries();
        }

        return totalSalarios;
    }

    public static String getDepartmentName(UUID id) {
        String deptName = "";
        boolean hallado = false;
        for (int i = 0; i < arrDeptos.size() && !hallado; i++) {   // recorre ArrayList Department

            if (arrDeptos.get(i).getId().equals(id)) {
                hallado = true;
                deptName = arrDeptos.get(i).getNombre();
            }
        }
        if (!hallado)
            System.out.println("Departamento con UUID: " + id + " no hallado.\n");
        return deptName;
    }

    public Department getDeptoByPos(int n) {
        return arrDeptos.get(n);
    }

    public void printPayroll() {
        for (int i = 0; i < arrDeptos.size(); i++) {
            for (int j = 0; j < arrDeptos.get(i).getEmployees().size(); j++) {
                System.out.println(arrDeptos.get(i).getEmployees().get(j).toString());
            }
        }

    }

    public boolean depositToEmployee(UUID employeeId, double deposit, char accType) {
        boolean hallado = false;
        for (int i = 0; i < arrDeptos.size() && !hallado; i++) {   // recorre ArrayList Department

            for (int j = 0; j < arrDeptos.get(i).getEmployees().size() && !hallado; j++) {   // recorre ArrayList Employee
                if (arrDeptos.get(i).getEmployees().get(j).getId().equals(employeeId)) {
                    hallado = true;
                }
            }
        }
        if (!hallado) {
            System.out.println("Empleado con UUID: " + employeeId + " no hallado.\n");
            return false;
        }
        // Paso 1: Validar que el empleado exista
        int pos = 0;
        if ((pos = accountPosition(employeeId)) < 0) {
            if (accType == 'C')
                arrAccounts.add(new Checking(employeeId));
            else
                arrAccounts.add(new Savings(employeeId));
        }

        // Paso 2: Verificada la cuenta del empleado, se realiza el depósito
        if (pos < 0)  pos = arrAccounts.size() - 1;
        return arrAccounts.get(pos).deposit(deposit);
    }

    public double calculateEmployeeBalance(UUID employeeId) {
        // Paso 1: Validar que el empleado exista
        int  pos = 0;
        if ((pos = accountPosition(employeeId)) < 0) {
            return 0.0;
        }
        // Verificar que exista la cuenta (si no existe retorno 0, si existe retorna getBalance())
        return arrAccounts.get(pos).getBalance();
    }

    public double calculateAllEmployeesBalance() {
        // recorre todos los empleados de todos los deptos y calcula la sumatoria de sus balances
        double balance = 0.0;
        for (int j = 0; j < arrAccounts.size(); j++) {   // recorre ArrayList arrAccounts
            balance += arrAccounts.get(j).getBalance();
        }
        return balance;
    }

    public int accountPosition(UUID employeeId) {
        if (arrAccounts == null) {
            arrAccounts = new ArrayList<BankAccount>();
        }
        int i = 0;
        for (; i < arrAccounts.size() && !arrAccounts.get(i).getEmployee().equals(employeeId); i++) {
        }
        return (i < arrAccounts.size() ? i : -1);
    }


    public SabanaPayroll(Collection<Employee> employees) {
        this.employees = employees;
        this.compensationFunds = new HashMap<>();
        this.department = new ArrayList<>();

        this.compensationFunds.put(ColsubsidioFund.class.getSimpleName(), new ColsubsidioFund());
        this.compensationFunds.put(CompensarFund.class.getSimpleName(), new CompensarFund());
        this.compensationFunds.put(CafamFund.class.getSimpleName(), new CafamFund());
    }

    public boolean assigneFamilyCompensation(String IFamilyCompensationFund, UUID employeeId) {

        boolean resultado1 = false;
        boolean resultado2 = false;


        Employee employee = null;
        Iterator<Employee> it = employees.iterator();

        while (!resultado2 && it.hasNext()) {
            Employee employee1 = it.next();
            if (employee1.getId() == employeeId) {
                employee = employee1;
                resultado2 = true;
            }
        }
        resultado1 = compensationFunds.get(IFamilyCompensationFund).registerEmployee(employee);
        return resultado1;
    }

    }

