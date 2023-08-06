package com.military.jobfinder.controller;

import com.military.jobfinder.entity.Api;
import com.military.jobfinder.repository.ApiRepository;
import com.military.jobfinder.service.DatabaseInitializer;
import com.military.jobfinder.service.JobFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class JobFinderController {

    private final JobFinderService jobFinderService;
    private final ApiRepository apiRepository;

    @Autowired
    public JobFinderController(JobFinderService jobFinderService, ApiRepository apiRepository) {
        this.jobFinderService = jobFinderService;
        this.apiRepository = apiRepository;
    }

    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }

    @GetMapping("/getRecruitInfo")
    @ResponseBody
    public List<Api> tempName(
            @RequestParam(value = "companyName", required = false) String companyName,
            @RequestParam(value = "recruitTitle", required = false) String recruitTitle) {
        return apiRepository.findByParams(companyName, recruitTitle);
    }
    @GetMapping("/api/getJobData")
    @ResponseBody
    public String apiData() throws Exception {
        String data = jobFinderService.getApiData();
        return data;
    }
}
