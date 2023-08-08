package com.ismataga.company_management.service;

import com.ismataga.company_management.dto.CompanyDTO;


import java.util.List;

public interface CompanyService {
    void createTask(CompanyDTO companyDTO);

    List<CompanyDTO> getAllTask();

    CompanyDTO getTaskById(Long id);

    void updateTask(Long id, CompanyDTO companyDTO);

    void deleteTask(Long id);

}
