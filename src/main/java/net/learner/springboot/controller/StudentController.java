package net.learner.springboot.controller;

import net.learner.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

//    Spring boot REST Api that handles post request - create new resource
//    @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

//    Spring boot REST Api that handles HTTP PUT request - updating existing resource
    @PutMapping("students/{id}/update")
//    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

//    Spring Boot REST Api that handles HTTP Delete request - deleting existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println("id = "+studentId);
        return "Student Deleted successfully";
    }

}
