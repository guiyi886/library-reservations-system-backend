package com.manager.entity.VO;

import com.manager.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentList {
    public Integer number;
    public List<Student> list;
}
