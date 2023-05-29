package net.learner.springboot.controller;

import net.learner.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Prateek","Chhibber");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Maggie","Kothari"));
        students.add(new Student(2,"Vishtu","Kothari"));
        students.add(new Student(3,"Prateek","Chhibber"));
        return students;
    }

//    Spring boot REST Api with Path Variable
//    {id} - URI template variable
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id,"Tingu", "Pingu");
    }

//    Spring boot REST API with request param
//    http://localhost:8080/students/query?id=1&firstName=Prateek&lastName=Megha
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName,lastName);
    }

}
