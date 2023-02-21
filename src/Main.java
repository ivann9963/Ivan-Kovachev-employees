import models.Employee;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javafx.util.Pair;

public class Main {

    public static Integer calculateTime(Employee firstEmployee, Employee secondEmployee){
        Date firstStartTime = firstEmployee.getDateFrom();
        Date firstEndTime = firstEmployee.getDateTo();

        Date secondStartTime = secondEmployee.getDateFrom();
        Date secondEndTime = secondEmployee.getDateTo();

        Integer calcOverlappingTime = calculateOverlappingTime(firstStartTime, firstEndTime, secondStartTime, secondEndTime);
        return calcOverlappingTime;
    }

    public static Integer calculateOverlappingTime(Date s1, Date e1, Date s2, Date e2){
        Date diff;
        if(s1.before(s2) && e1.after(e2)) {
            //4th case from paint image
            diff = new Date(e2.getTime() - s2.getTime());
        } else if(s1.before(e2) && e1.after(e2)) {
            //2nd case from paint image
            diff = new Date(e2.getTime() - s1.getTime());
        } else if(s1.after(s2) && e1.before(e2)){
            //1st case from paint image
            diff = new Date(e1.getTime() - s1.getTime());
        } else if(s1.before(s2) && e1.before(e2)){
            //3rd case from paint image
            diff = new Date(e1.getTime() - s2.getTime());
        } else {
            return 0;
        }
        return (int) diff.getTime();
    }


    public static Map<String, List<Employee>> loadData() throws Exception {
        Map<String, List<Employee>> projects = new HashMap<>();
        try{
            Scanner sc = new Scanner(new File("inputData.csv"));
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                String metaData = sc.next();
                String[] words = metaData.split(",");
                Employee employee = new Employee(words[0], words[2], words[3]);
                if (projects.containsKey(words[1])) {
                    // if the project already exists in the map
                    projects.get(words[1]).add(employee);
                } else {
                    // if this is the first time we are having this project
                    List<Employee> projectEmployees = new ArrayList<>();
                    projectEmployees.add(employee);
                    projects.put(words[1], projectEmployees);
                }
            }
        } catch(FileNotFoundException e){
            throw e;
        }
        return projects;
    }

    public static void printProjects(Map<String, List<Employee>> projects){
        Iterator<Map.Entry<String, List<Employee>>> itr = projects.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, List<Employee>> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
    }
    public static void printEmployeePairs(Map<Pair<Employee, Employee>, Integer> employeePairs){
        // getting the longest time a pair has worked together
        Integer max = employeePairs.values().stream().sorted(Comparator.reverseOrder()).findFirst().get();
        Iterator<Map.Entry<Pair<Employee, Employee>, Integer>> itr2 = employeePairs.entrySet().iterator();
        while (itr2.hasNext()) {
            Map.Entry<Pair<Employee, Employee>, Integer> entry = itr2.next();
            if(entry.getValue().equals(max)){
                System.out.println("Pair of employees who have worked longest together => " + entry.getKey().getKey().getEmpId() +
                        " " + entry.getKey().getValue().getEmpId());
            }
        }
    }


    public static void main(String[] args) throws Exception {

        // load data from file
        Map<String, List<Employee>> projects = loadData();

        Map<Pair<Employee, Employee>, Integer> employeePairs = new HashMap<>();
        projects.values().stream().filter(employeeList -> employeeList.size() >= 2).forEach(employeeList -> {
            for(int i = 0; i < employeeList.size() - 1; i++){
                for(int j = i+1; j < employeeList.size(); j++){
                    Employee firstEmployee = employeeList.get(i);
                    Employee secondEmployee = employeeList.get(j);
                    Pair<Employee, Employee> employeePair= new Pair<>(firstEmployee, secondEmployee);
                    Integer daysTogether = calculateTime(firstEmployee, secondEmployee);
                    employeePairs.put(employeePair, daysTogether);
                }
            }
        });

        //printProjects(projects);
        printEmployeePairs(employeePairs);

    }
}

