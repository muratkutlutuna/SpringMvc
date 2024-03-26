package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@ResponseBody
//@RestController // used if we need Restful API
//@RestController = @ResponseBody + @Controller
@RequestMapping("/students") //https://localhost:8080/SpringMvc/students
//@RequestMapping can be used in class level and method level
//when we @RequestMapping on a class level path will be applied for all the methods inside the class
public class StudentController {

    @Autowired
    private StudentService service;

    /**
     * ModelANdView = Holder for both Model and View in the MVC framework
     *
     * @return it returns either ModelAndView obj (data+view) or String view name
     */
    @GetMapping("/hi") //https://localhost:8080/SpringMvc/students/hi
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","Hello");
        mav.addObject("messagebody", "I am a Student Management System");
        mav.setViewName("hi"); //hi.jsp
        return mav;
        //ViewResolver will find hi.jsp file from location we have set
        //and binds data from mav to jps
    }

    //1 - Create Student
    @GetMapping("/new") //https://localhost:8080/SpringMvc/students/new
    public String sendStudentForm(@ModelAttribute("student") Student student){

        return "studentForm";

        //@ModelAttribute--used to bind data from file to model
    }

//    @PostMapping("/saveStudent") //https://localhost:8080/SpringMvc/students/saveStudent
//    public String createStudent(@Valid @ModelAttribute Student student) {
//        service.saveStudent(student);
//        return "redirect:/students";
//    }

    /**
     * if we want to see validation messages on the form page
     * @param student
     * @param bindingResult
     * @return
     */
    @PostMapping("/saveStudent") //https://localhost:8080/SpringMvc/students/saveStudent
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "studentForm";
        }
        service.saveStudent(student);
        return "redirect:/students";
    }

    //2 - to get all students
    @GetMapping //https://localhost:8080/SpringMvc/students
    public ModelAndView getAllStudents(){
        List<Student> list = service.getAllStudents();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",list);
        mav.setViewName("students"); //students.jsp

        return mav;
    }
}
