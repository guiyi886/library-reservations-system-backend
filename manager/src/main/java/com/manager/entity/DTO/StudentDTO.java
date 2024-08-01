package com.manager.entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    public Integer id;

    @JsonProperty("stu_id")
    public String stuId;

    public String name;

    public String sex;

    public String phone;

    public Integer score;
}
