/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamch3ass3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import java.util.stream.Stream;
/**
 *
 * @author RazanIT
 */

public class StreamCh3Ass3{
    public static void main(String[] args) {
//  Q1: A)
//          value -> System.out.printf("%d ", value)
//          value -> {System.out.printf("%d ", value)}
//  Q1: B)
//        String::toUpperCase
//  Q1: C)
//        () -> "Welcome to lambdas!" 
//  Q1: D)
//         value -> value * value * value
//         (value) -> value * value * value

//Q2:
        String text = "";
        try {
            Scanner s = new Scanner(new File("src/StreamCh3Ass3/text.txt"));
            while (s.hasNext()) {
                text += s.nextLine();
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }

        //
        Stream.of(text.split(""))
                .collect(groupingBy(s -> s,
                        mapping(s -> s, Collectors.counting())))
                .forEach((key, value) -> System.out.println("The occurrences of [ " + key +
                        " ] character is : " + value));
        
//Q3:
        /*listEmployees     
        .stream()     
        .filter(e-> e.getSalary() >=800 && e.getSalary() <1200)     
        .map(e-> new Employee (e.getId(), e.getName(), e.getDepartment(), getSalary()*1.02))     
        .collect(Collectors. groupingBy(Employee::getDepartment, Collectors.counting()))     
        .forEach((d, c) -> System.out.println("Dept: "+ d + ", Count: " + c))
         */
        
        // A brief summary
        
        //listEmployees a pipeline stream filter its elements to have only employees their
        //salary between 800 and 1200 to have update 2% plus then collecting as groups each departments and its count of employees 
        //,finally print tie result of each department and the count of updated employees belong to.
        
        //The Detailed explanation

        //listEmployees => have objects of Employee (the data source of stream pipeline)
        //.stream => to have stream of these employees move through a sequence of processing steps - pipeline-
        //.filter => filter the stream to have only elements that satisfy the condition
        //only employees they have salary between >=800 and <1200
        //.map => maps each element in the stream to a new value (each -e- employee will refere to 
        //a new Employee object that have replacment’s data -- id ,name , department --
        //and update new salary by 2% plus) (plus 2% at salary to each employee)
        //.collect => collecting the results elements of the previous opreations each according to its
        //department in a group and its counting
        //.forEach => print each department with its count of employees 
        

    }
    
}
