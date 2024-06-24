package net.re.springdatajpa.repository;

import net.re.springdatajpa.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("select j from Job as j where j.name ilike %?1%")
    public List<Job> findByName(String name);

    @Query("SELECT j from Job as j where j.requiredYearsOfExperience > ?1")
    public List<Job> findByExperienceGreaterThan(int experience);

    @Query("SELECT j from Job as j where j.name ilike %?1% or j.description like %?1%")
    public List<Job> findByKeyword(String keyword);
}
