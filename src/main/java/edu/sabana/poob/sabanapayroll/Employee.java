package edu.sabana.poob.sabanapayroll;//package sabananominatest;

import java.util.UUID;

public class Employee {
   final double HOURVALUE = 45000;
   final double VALORCOMISION = 23000;
   private UUID id;
   private String nombre;
   private String apellido;
   private UUID idDepartment;

   public Employee() {
   }

   public Employee(UUID id, String nombre, String apellido, UUID idDepartment) {
      this.id = id;
      this.nombre = nombre;
      this.apellido = apellido;
      this.idDepartment = idDepartment;
   }

   public UUID getId() {
      return id;
   }

   public double calculateSalary() {
      return 0.0;
   }

   public String toString_0() {
      return id + "::" + nombre + " " + apellido + ", departamento " +
         SabanaPayroll.getDepartmentName(idDepartment) + ", salario $";
   }
}

class EmployeeSalary extends Employee {
   private double salarioFijoMensual;

   public EmployeeSalary(String s, String lastName, Department department, int i) {
      super();
   }

   public EmployeeSalary(UUID id, String nombre, String apellido, UUID idDepartment, double salarioFijoMensual) {
      super(id, nombre, apellido, idDepartment);
      this.salarioFijoMensual = salarioFijoMensual;
   }

   @Override
   public double calculateSalary() {
      //return salarioFijoMensual * (1 - 0.04 - 0.04);
      return salarioFijoMensual - desctoPrestac();
   }

   public double desctoPrestac() {
      return salarioFijoMensual * 0.08;  // 4% pension y 4% salud
   }

   public String toString() {
      return toString_0() + calculateSalary() + ", pago por salario.";
   }
}

class EmployeeCommissioned  extends Employee {
   private int prodVendidos;

   public EmployeeCommissioned(String s, String lastName, Department department, int i) {
      super();
   }

   public EmployeeCommissioned(UUID id, String nombre, String apellido, UUID idDepartment, int prodVendidos) {
      super(id, nombre, apellido, idDepartment);
      this.prodVendidos = prodVendidos;
   }

   @Override
   public double calculateSalary() {
      return VALORCOMISION * prodVendidos;
   }

   public String toString() {
      return toString_0() + calculateSalary() + ", pago por comision.";
   }
}

class EmployeebyHours  extends Employee {
   private int workedHours;  // Total horas trabajadas

   public EmployeebyHours(String s, String lastName, Department department, int i) {
      super();
   }

   public EmployeebyHours(UUID id, String nombre, String apellido, UUID idDepartment, int workedHours) {
      super(id, nombre, apellido, idDepartment);
      this.workedHours = workedHours;
   }

   @Override
   public double calculateSalary() {
      return HOURVALUE * workedHours;
   }

   public String toString() {
      return toString_0() + calculateSalary() + ", pago por horas.";
   }
}