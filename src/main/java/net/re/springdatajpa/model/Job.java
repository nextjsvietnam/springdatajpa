package net.re.springdatajpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String description;
    List<String> skills;
    int requiredYearsOfExperience;

    @Override
    public String toString() {
        return "{job:{" + id + " " + name + " " + description + " " + skills + " " + requiredYearsOfExperience + "}";
    }
}
