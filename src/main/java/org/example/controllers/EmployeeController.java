package org.example.controllers;

import jakarta.validation.Valid;
import org.example.entities.Employee;
import org.example.entities.Job;
import org.example.respository.JobRepository;
import org.example.services.EmployeeService;
import org.example.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    JobService jobService;





    @RequestMapping("/createEmployee")
    public String createEmployee(ModelMap modelMap) {
        List<Job> jobsList = jobService.getAllJobs();
        modelMap.addAttribute("jobJsp", jobsList);
        return "CreateEmployee";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(
            @Valid Employee employee,
            BindingResult bindingResult,
            @RequestParam("idJob") Long idJob,
            ModelMap modelMap
    ) {
        if(bindingResult.hasErrors()) {
            modelMap.addAttribute("errorMessage", "Failed to add the employee. Please check the form and try again.");
            return "CreateEmployee";
        }

        Job selectedjob = jobService.getJob(idJob);
        employee.setJob(selectedjob);
        // Save the employee
        employeeService.saveEmployee(employee);
        modelMap.addAttribute("successMessage", "Employee added successfully");
        return "CreateEmployee";
    }

    @RequestMapping("/employeesList")
    public String employeesList(
            ModelMap modelMap, //Envoyer à la jsp
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "6") int size

            ){
        Page<Employee> employeesController = employeeService.getAllEmployeesByPage(page, size);
        modelMap.addAttribute("employeesJsp",employeesController);
        modelMap.addAttribute("pages",new int[employeesController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "EmployeesList";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(
            @RequestParam("id") Long id,
           ModelMap modelMap,
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "6") int size
    ){
        employeeService.deleteEmployeeById(id);

        Page<Employee> employeesController = employeeService.getAllEmployeesByPage(page, size);
        modelMap.addAttribute("employeesJsp",employeesController);
        modelMap.addAttribute("pages",new int[employeesController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "EmployeesList";
    }

    @RequestMapping("/showEmployee")
    public String showEmployee(
            @RequestParam("id") Long id,
            ModelMap modelMap
    ){
        Employee employeesController = employeeService.getEmployee(id);
        modelMap.addAttribute("employeeJsp",employeesController);

        return "EditEmployee";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(
            @ModelAttribute("employee") Employee employee
    ) {
        employeeService.saveEmployee(employee);
        return "CreateEmployee";
    }



}
