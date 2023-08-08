package com.ismataga.company_management.dto;


import jakarta.validation.constraints.Past;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String name;
    @Past(message = "Keçmiş zaman daxil etməlisiz")
    private LocalDate createDate;
    private long employeeCount;
    private int activeDate;

}
