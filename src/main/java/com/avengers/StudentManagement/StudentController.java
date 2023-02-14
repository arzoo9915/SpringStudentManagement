package com.avengers.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody  Student student){
        String response= studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);


    }

    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo)
    {

        Student response= studentService.getStudent(admnNo);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int admnNo)
    {
        String response= studentService.deleteStudent(admnNo);
        if(response.equals("Invalid id"))
        {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PutMapping("/update_students")
    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age)
    {
        String response= studentService.updateStudents(id,age);
        if(response.equals("inavlid id"))
        {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


}
