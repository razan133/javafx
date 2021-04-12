/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3HW;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author RazanIT
 */
public class StudentScreenController implements Initializable {

    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldMajor;
    @FXML
    private TextField textFieldGrade;
    @FXML
    private ListView<Student> listViewStudents = new ListView<>();
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonClear;
    ArrayList<Student> studentArray = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // This is just a intitial data
        listViewStudents.getItems()
                .add(new Student(111, "Ahmad", "CS", 93.2));
        listViewStudents.getItems()
                .add(new Student(222, "Marwa", "EDUC", 87.9));
        //a) Use lambdas and streams to sort the Student objects by name, then show the results.
        textFieldName.appendText("Sorted Students by name :\n");
        listViewStudents.getItems().stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> {
                    textFieldName.appendText(s + "\n");
                });
        textFieldName.appendText("\n");
        //b) Use lambdas and streams to map each Student to its name and grade
            //, sort the results by grade (descending), then display the results.
            textFieldGrade.appendText( "Each Student to its name and grade, sorted by grade (descending) : "+ "\n");
            studentArray.stream()
                    .sorted(Comparator.comparing(Student::getGrade).reversed())
                    .map(s -> s.getName()+" - "+s.getGrade())
                    .forEach(s -> {
                        textFieldGrade.appendText( s + "\n");
                    });
            //c) Use lambdas and streams to map each Student to its name and grade, to select the Students
            //who have grade values in the range 80 to 90.
            //Sort the results by grade value (descending), then show the results. 
            textFieldGrade.appendText( "\nStudent name and grade at range 80 to 90. Sorted by grade value (descending) :"+ "\n");
            studentArray.stream()
                    .filter(s -> s.getGrade() >= 80 && s.getGrade() <= 90)
                    .sorted(Comparator.comparing(Student::getGrade).reversed())
                    .map(s -> s.getName()+" - "+s.getGrade())
//                    .map(s -> s.getNameGrade())
                    .forEach(s -> {
                        textFieldGrade.appendText( s + "\n");
                    });
            //d)Use lambdas and streams to calculate the total average of all Students grades, then show the result
            double avg = studentArray.stream()
                    .map(s -> s.getGrade())
                    .collect(Collectors.averagingDouble(num -> num));
            
            textFieldGrade.appendText("\nThe total average of all Students grades :  " + avg + "\n");
            //e) Use lambdas and streams to group Students by major, then show the results
            studentArray.stream()
                    .collect(Collectors.groupingBy(Student::getMajor))
                    .forEach((maj, stuList) -> {
                        textFieldMajor.appendText("Major:  " + maj + "\n");
                        stuList.forEach(std -> textFieldMajor.appendText(std + "\n"));
                    });
        };
        

    

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        try {

            Integer id = Integer.parseInt(textFieldID.getText());
            String name = textFieldName.getText();
            String major = textFieldMajor.getText();
            Double grade = Double.parseDouble(textFieldGrade.getText());

            Student input = new Student(id, name, major, grade);
            studentArray.add(input);
            listViewStudents.getItems().add(input);

            //a) Use lambdas and streams to sort the Student objects by name, then show the results AT LISTVIEW.
//            listViewStudents.getItems().setAll(
//                    listViewStudents.getItems()
//                            .stream()
//                            .sorted(Comparator.comparing(Student::getName))
//                            .collect(Collectors.toList()));
//            reset();

        } catch (NumberFormatException ex) {

        }
    }

   ;
    


    @FXML
    private void buttonClearHandle(ActionEvent event) {
        reset();
    }

    //for reste all textField’s content and become empty
    private void reset() {
        textFieldID.setText("");
        textFieldName.setText("");
        textFieldMajor.setText("");
        textFieldGrade.setText("");

    }

}
