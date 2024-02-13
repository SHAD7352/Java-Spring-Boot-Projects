package com.dillutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dillutech.entity.Employee;
import com.dillutech.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String index(Model m) {
        List<Employee> list = empService.getAllEmployees();
        m.addAttribute("empList", list);
        return "index";
    }

    @GetMapping("/loadSaveEmp")
    public String loadSaveEmp() {
        return "empsave";
    }

    @GetMapping("/editEmp/{id}")
    public String editEmp(@PathVariable int id, Model m) {
        // System.out.println(id);
        Employee emp = empService.getEmployeeById(id);
        m.addAttribute("emp", emp);
        return "empedit";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
        Boolean f = empService.deleteEmpById(id);
        if (f == true) {
            session.setAttribute("msg", "Deleted Successfully");
        } else {
            session.setAttribute("msg", "Failed to Delete!");
        }
        return "redirect:/";
    }

    @PostMapping("/saveEmp")
    public String saveEmp(@ModelAttribute Employee employee, HttpSession session) {
        // System.out.println(employee);
        Employee newEmp = empService.saveEmployee(employee);
        if (newEmp != null) {
            session.setAttribute("msg", "Register Sucessfully");
        } else {
            session.setAttribute("msg", "Something wrong on server");

        }
        return "redirect:/loadSaveEmp";
    }

    @PostMapping("/updateEmpDtls")
    public String updateEmp(@ModelAttribute Employee employee, HttpSession session) {
        // System.out.println(employee);
        Employee updateEmp = empService.saveEmployee(employee);
        if (updateEmp != null) {
            session.setAttribute("msg", "Update Sucessfully");
        } else {
            session.setAttribute("msg", "Something wrong on server");

        }
        return "redirect:/";
    }

}
