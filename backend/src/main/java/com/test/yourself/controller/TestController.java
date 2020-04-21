package com.test.yourself.controller;

import com.test.yourself.dto.TestDto;
import com.test.yourself.maper.TestMapper;
import com.test.yourself.model.test.Test;
import com.test.yourself.service.test.TestService;
import com.test.yourself.service.test.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private TestServiceImpl testService;

    private TestMapper testMapper;

    @Autowired
    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Autowired
    public void setTestService(TestServiceImpl testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/generate", params = {"id", "number"})
    public @ResponseBody TestDto generateRandomTest(
            @RequestParam("id") Long subjectID,
            @RequestParam("number") int amount) {
            Test randomTest = testService.getRandomTest(subjectID,amount);
            return  testMapper.toDto(randomTest);
    }

}
