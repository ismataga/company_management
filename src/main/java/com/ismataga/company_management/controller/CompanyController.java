package com.ismataga.company_management.controller;
import com.ismataga.company_management.dto.CompanyDTO;
import com.ismataga.company_management.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService CompanyService;



    @PostMapping
    public void createTask(@RequestBody @Valid CompanyDTO companyDTO) {
        CompanyService.createTask(companyDTO);
    }


    @GetMapping
    public List<CompanyDTO> getAllTasks() {
        return CompanyService.getAllTask();
    }


    @GetMapping("{id}")
    public CompanyDTO getTask(@PathVariable Long id) {
        return CompanyService.getTaskById(id);
    }


    @PutMapping("{id}")

    public void updateTask(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        CompanyService.updateTask(id, companyDTO);

    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) { CompanyService.deleteTask(id);
    }



}
