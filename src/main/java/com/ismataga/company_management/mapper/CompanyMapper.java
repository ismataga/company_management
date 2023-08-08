package com.ismataga.company_management.mapper;

import com.ismataga.company_management.dto.CompanyDTO;
import com.ismataga.company_management.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;


@Mapper(imports = LocalDateTime.class)
public interface CompanyMapper {


    Company mapToCompanyEntity(CompanyDTO companyDTO);

    List<CompanyDTO> mapToCompanyDTOList(List<Company> company);

    @Mapping(target="activeDate",expression = "java(duration.getYears())")
    CompanyDTO mapToCompanyDTO(Company company);


        LocalDate createDate = LocalDate.of(2000, 5, 20);
        LocalDate today = LocalDate.now();
        Period duration = Period.between(createDate, today);

}
