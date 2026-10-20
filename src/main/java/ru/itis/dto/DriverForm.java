// ДЗ

package ru.itis.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DriverForm {
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String gender;
    private Integer experience;
}
