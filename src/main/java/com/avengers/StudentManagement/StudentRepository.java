package com.avengers.StudentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db=new HashMap<>();

    public Student getStudent(int id)
    {
        return db.get(id);
    }
    public String addStudent(Student student)
    {
        int id=student.getAdmNo();
        db.put(id,student);
        return "added successfully";
    }
    public String deleteStudent(int id)
    {
        if(!db.containsKey(id))
        {
            return "Invalid id";
        }
        db.remove(id);
        return "deleted";

    }

    public String updateStudents(int id,int age)
    {
        if(!db.containsKey(id))
        {
            return "inavlid id";
        }
        db.get(id).setAge(age);
        return "age updated";
    }
}
