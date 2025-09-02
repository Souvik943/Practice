package practice.Sept022025.StreamsAPI.EmployeeBased;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }

    public static List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new Employee(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new Employee(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new Employee(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new Employee(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new Employee(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new Employee(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new Employee(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new Employee(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new Employee(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new Employee(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new Employee(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));

        return employeeList;
    }

    // ---------------------- Questions -----------------------------
    public static int totalEmployees() {
        return getEmployeeList()
                .stream()
                .toList().size();
    }

    public static List<Employee> sortAscBySalary() {
        return getEmployeeList()
                .stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary()))
                .toList();
    }

    public static List<Employee> sortDescBySalary() {
        return getEmployeeList()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
    }

    public static Map<String, Long> countGenders() {
        return getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
    }

    public static Map<String, Long> countByDepartment() {
        return getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public static Set<String> getAllDepartments() {
        return getEmployeeList()
                .stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> avgSalaryByDept() {
        return getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static Map<String, Optional<Employee>> highestSalaryByGender() {
        return getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public static Map<String, Optional<Employee>> lowestSalaryByGender() {
        return getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public static Map<String, Optional<Employee>> highestSalaryByDepartment() {
        return getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public static Optional<Employee> employeeWithHighestSalary() {
        return getEmployeeList()
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    public static Optional<Employee> youngestEmployeeByDept() {
        return getEmployeeList()
                .stream()
                .filter(e -> e.getDepartment().equals("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge));
    }

    public static Optional<Employee> secondHighestSalaryEmployee() {
        return getEmployeeList()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
    }


}
