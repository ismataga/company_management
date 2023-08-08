package com.ismataga.company_management.service.impl;

import com.ismataga.company_management.dto.CompanyDTO;
import com.ismataga.company_management.entity.Company;
import com.ismataga.company_management.exceptions.UserNotFoundException;
import com.ismataga.company_management.mapper.CompanyMapper;
import com.ismataga.company_management.repository.CompanyRepository;
import com.ismataga.company_management.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;

    private final CompanyRepository companyRepository;



    @Override
    public void createTask(CompanyDTO companyDTO) {
        log.info("createTask().start");
        Company company = companyMapper.mapToCompanyEntity(companyDTO);
        companyRepository.save(company);
        log.info("createdTask().end");
    }



    @Override
    public List<CompanyDTO> getAllTask() {

        log.info("getAllTask().start");
        List<Company> company = companyRepository.findAll();
        List<CompanyDTO> companyDTOList = companyMapper.mapToCompanyDTOList(company);
        log.info("getAllTask().end");
        return companyDTOList;
    }

    @Override
    public CompanyDTO getTaskById(Long id) {
        log.info("getTaskById().start id {}", id);
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Task not founded by id " + id));
        log.info("getToDoById().end id {}", id);
        return companyMapper.mapToCompanyDTO(company);
    }


    @Override
    public void updateTask(Long id, CompanyDTO companyDTO) {
        log.info("updateTask().start id {} ", id);

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Task not founded by id " + id));
        if (companyDTO.getName() != null)
            company.setName(companyDTO.getName());
        companyRepository.save(company);
        log.info("updateTask().end id {}", id);
    }

    @Override
    public void deleteTask(Long id) {
        log.info("deleteTask().start id ", id);
        companyRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Task not founded by id " + id));
        companyRepository.deleteById(id);
        log.info("deleteTask().end id ", id);

    }



}
