// ДЗ

package ru.itis.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Driver {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String gender;
    private Integer experience;
}
