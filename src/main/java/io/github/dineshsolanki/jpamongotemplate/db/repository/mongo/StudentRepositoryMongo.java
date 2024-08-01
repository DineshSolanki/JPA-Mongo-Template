package io.github.dineshsolanki.jpamongotemplate.db.repository.mongo;

import io.github.dineshsolanki.jpamongotemplate.db.entity.Student;
import io.github.dineshsolanki.jpamongotemplate.db.repository.StudentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
public interface StudentRepositoryMongo extends StudentRepository, MongoRepository<Student, String> {
    @Override
    Student findStudentByNameIgnoreCase(String name);

}
