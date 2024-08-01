package io.github.dineshsolanki.jpamongotemplate.db.repository.jpa;

import io.github.dineshsolanki.jpamongotemplate.db.entity.Student;
import io.github.dineshsolanki.jpamongotemplate.db.repository.StudentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "jpa", matchIfMissing = true)
public interface StudentRepositoryJPA extends StudentRepository, JpaRepository<Student, Long> {

}