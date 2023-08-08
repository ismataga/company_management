package com.ismataga.company_management.dto;
import com.ismataga.company_management.entity.Company;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String  email;
    private CompanyDTO company;
}
