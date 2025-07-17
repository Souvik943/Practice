package practice.July172025.StreamsAPI.EmployeeBased;

import java.util.*;
import java.util.stream.Collectors;

public class Employees {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employees(int id, String name, int age, String gender, String department, int yearOfJoining, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public String getDepartment()
    {
        return department;
    }

    public int getYearOfJoining()
    {
        return yearOfJoining;
    }

    public double getSalary()
    {
        return salary;
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

    public static List<Employees> getEmployeeList(){
        List<Employees> employeeList = new ArrayList<Employees>();

        employeeList.add(new Employees(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employees(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employees(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employees(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new Employees(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new Employees(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new Employees(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new Employees(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new Employees(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new Employees(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new Employees(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new Employees(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new Employees(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new Employees(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(new Employees(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new Employees(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new Employees(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));

        return employeeList;
    }

    // find total employees
    public static long findTotalSize() {
        return getEmployeeList().stream()
                .count();
    }

    // sort in ascending order based on salary
    public static List<Employees> sortAscending() {
        return getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary()))
                .collect(Collectors.toList());

    }

    // sort in descending order based on salary
    public static List<Employees> sortDescending() {
        return getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                .collect(Collectors.toList());

    }

    // count frequency of male and female employees
    public static Map<String, Long> countGenders() {
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));
    }

    // count frequency of employees in each dept.
    public static Map<String, Long> countEmployeesInDept() {
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
    }

    // get names of all dept
    public static Set<String> getAllDept() {
        return getEmployeeList().stream()
                .map(e -> e.department)
                .collect(Collectors.toSet());
    }

    // count avg salary of each gender
    public static Map<String, Double> getAverage() {
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(e -> e.gender, Collectors.averagingDouble(e -> e.salary)));
    }

    // male and female with highest salary
    public static Map<String, Optional<Employees>> getHighestSalary() {
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.maxBy(Comparator.comparing(e -> e.salary))));
    }

    // male and female with lowest salary
    public static Map<String, Optional<Employees>> getLowestSalary() {
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.minBy(Comparator.comparing(e -> e.salary))));
    }

    // highest salary of every dept
    public static Map<String, Optional<Employees>> getHighestSalaryByDept() {
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.maxBy(Comparator.comparing(e -> e.salary))));
    }

    // highest salary in the whole company
    public static Employees getHighestSalaryInAll() {
        return getEmployeeList().stream()
                .max(Comparator.comparing(e -> e.salary))
                .get();
    }

    // youngest employee of a specific department
    public static Employees youngestEmployeeOfSpecificDept() {
        return getEmployeeList().stream()
                .filter(e -> e.department.equals("Product Development"))
                .min(Comparator.comparingInt(e -> e.age))
                .get();
    }

    // employee with most yoe
    public static Employees emplyoeeWithMostExp() {
        return getEmployeeList().stream()
                .min(Comparator.comparingInt(e -> e.yearOfJoining))
                .get();
    }

    // employee with second highest salary
    public static Employees employeeWithSecondHighestSalary() {
        return getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                .skip(1)
                .findFirst()
                .get();
    }

    public static void main(String[] args) {
        System.out.println(findTotalSize());
        System.out.println(sortAscending());
        System.out.println(sortDescending());
        System.out.println(countGenders());
        System.out.println(countEmployeesInDept());
        System.out.println(getAllDept());
        System.out.println(getAverage());
        System.out.println(getHighestSalary());
        System.out.println(getLowestSalary());
        System.out.println(getHighestSalaryByDept());
        System.out.println(getHighestSalaryInAll());
        System.out.println(youngestEmployeeOfSpecificDept());
        System.out.println(emplyoeeWithMostExp());
        System.out.println(employeeWithSecondHighestSalary());
    }
}
