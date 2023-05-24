package org.example.controllers;

import jakarta.validation.Valid;
import org.example.entities.Employee;
import org.example.entities.Job;
import org.example.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {

    @Autowired
    JobService jobService;

    @RequestMapping("/createJob")
    public String createJob(){
        return "CreateJob";
    }

    @RequestMapping("/saveJob")
    public String saveJob(
            @Valid Job job,
            BindingResult bindingResult,
            ModelMap modelMap
    ){
        if(bindingResult.hasErrors()) {
            modelMap.addAttribute("errorMessage", "Failed to add the employee. Please check the form and try again.");
            return "CreateJob";
        }
        jobService.saveJob(job);
        modelMap.addAttribute("successMessage", "Job added successfully");
        return "CreateJob";
    }

    @RequestMapping("/jobsList")
    public String jobsList(
            ModelMap modelMap, //Envoyer à la jsp
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "6") int size

    ){
        Page<Job> jobsController = jobService.getAllJobsByPage(page, size);
        modelMap.addAttribute("jobsJsp",jobsController);
        modelMap.addAttribute("pages",new int[jobsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "JobsList";
    }

    @RequestMapping("/deleteJob")
    public String deleteJob(
            @RequestParam("id") Long id,
            ModelMap modelMap,
            @RequestParam(name= "page", defaultValue = "0") int page,
            @RequestParam(name= "size", defaultValue = "6") int size
    ){
        jobService.deleteJobById(id);

        Page<Job> jobsController = jobService.getAllJobsByPage(page, size);
        modelMap.addAttribute("jobsJsp",jobsController);
        modelMap.addAttribute("pages",new int[jobsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "JobsList";
    }

    @RequestMapping("/showJob")
    public String showJob(
            @RequestParam("id") Long id,
            ModelMap modelMap
    ){
        Job jobsController = jobService.getJob(id);
        modelMap.addAttribute("jobJsp",jobsController);

        return "EditJob";
    }

    @RequestMapping("/updateJob")
    public String updateJob(
            @ModelAttribute("job") Job job,
            ModelMap modelMap,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            modelMap.addAttribute("errorMessage", "Failed to edit the job. Please check the form and try again.");
            return "CreateEmployee";
        }
        jobService.saveJob(job);
        modelMap.addAttribute("successMessage", "Job has been edited successfully");
        return "CreateJob";
    }


}
