package com.military.jobfinder.controller;

import com.military.jobfinder.service.DatabaseInitializer;
import com.military.jobfinder.service.JobFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JobFinderController {

    private final JobFinderService jobFinderService;

    @Autowired
    public JobFinderController(JobFinderService jobFinderService) {
        this.jobFinderService = jobFinderService;
    }

    @GetMapping("")
    @ResponseBody
    public String test() {
        return "TEST";
    }

    @GetMapping("/api/getJobData")
    @ResponseBody
    public String apiData() throws Exception {
        String data = jobFinderService.getApiData();
        return data;
    }
}
