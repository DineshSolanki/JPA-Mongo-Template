package io.github.dineshsolanki.jpamongotemplate.db.repository;

import io.github.dineshsolanki.jpamongotemplate.db.entity.Student;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StudentRepository {
    Student findStudentByNameIgnoreCase(String name);
}
