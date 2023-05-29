package net.learner.springboot.controller;

import net.learner.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Prateek","Chhibber");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header","prateek").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Maggie","Kothari"));
        students.add(new Student(2,"Vishtu","Kothari"));
        students.add(new Student(3,"Prateek","Chhibber"));
        return ResponseEntity.ok(students);
    }

//    Spring boot REST Api with Path Variable
//    {id} - URI template variable
    @GetMapping("{id}/{first-Name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id,
                                       @PathVariable("first-Name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

//    Spring boot REST API with request param
//    http://localhost:8080/students/query?id=1&firstName=Prateek&lastName=Megha
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student(id, firstName,lastName);
        return ResponseEntity.ok(student);
    }

//    Spring boot REST Api that handles post request - create new resource
//    @PostMapping and @RequestBody
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    Spring boot REST Api that handles HTTP PUT request - updating existing resource
    @PutMapping("{id}/update")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

//    Spring Boot REST Api that handles HTTP Delete request - deleting existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println("id = "+studentId);
        return ResponseEntity.ok("Successfully deleted student");
    }

}
