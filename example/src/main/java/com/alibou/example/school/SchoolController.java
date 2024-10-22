package com.alibou.example.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {


    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private final SchoolService schoolService;


    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ){

        return schoolService.create(dto);

    }




    @GetMapping("/schools")
    public List<SchoolDto> findAll(){

        return schoolService.findAll();
    }
}
