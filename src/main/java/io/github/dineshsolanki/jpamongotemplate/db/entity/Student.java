package io.github.dineshsolanki.jpamongotemplate.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Entity
@Getter
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter(AccessLevel.PRIVATE)
    private Long sqlId;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    @Transient
    @org.springframework.data.annotation.Id
    private String mongoId;

    @Column(name = "name")      //jpa annotation
    @Field(name = "name")       //mongo annotation
    private String name;

    @org.springframework.data.annotation.Id
    public String getId() {
        return Objects.nonNull(sqlId) ? sqlId.toString() : mongoId;
    }

    /**
     * Sets the ID of the Student.
     *
     * @param id the ID of the Student, which can be either a SQL ID or a MongoDB ID
     *
     */
    public void setId(@NonNull String id) {
        try {
            sqlId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            mongoId = id;
        }
    }
}