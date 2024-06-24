package net.re.springdatajpa;

import net.re.springdatajpa.model.Job;
import net.re.springdatajpa.repository.JobRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringdatajpaApplication.class, args);

		Job job1 = context.getBean(Job.class);
		Job job2 = context.getBean(Job.class);
		Job job3 = context.getBean(Job.class);

		job1.setId(1);
		job2.setId(2);
		job3.setId(3);

		job1.setName("Java Developer Junior");
		job2.setName("Java Developer Middle");
		job3.setName("Java Developer Senior");

		job1.setDescription("Build web application with Java SpringBoot and ReactJS");
		job2.setDescription("Build web application with Java SpringBoot and ReactJS");
		job3.setDescription("Build web application with Java SpringBoot and ReactJS");

		job1.setSkills(List.of("Java", "Spring"));
		job2.setSkills(List.of("Java", "Spring", "React", "Postgresql", "Docker"));
		job3.setSkills(List.of("Java", "Spring", "React", "Postgresql", "Docker", "AWS"));

		job1.setRequiredYearsOfExperience(1);
		job2.setRequiredYearsOfExperience(3);
		job3.setRequiredYearsOfExperience(5);

		System.out.println(job1.toString());
		System.out.println(job2.toString());
		System.out.println(job3.toString());

		JobRepository jobRepository = context.getBean(JobRepository.class);
//		jobRepository.save(job1);
//		jobRepository.save(job2);
//		jobRepository.save(job3);
		System.out.println(jobRepository.findAll());
		System.out.println(jobRepository.findById(1));
		Optional<Job> job = jobRepository.findById(5);
		System.out.println(job);
		List<Job> javaJobs = jobRepository.findByName("Junior");
		System.out.println(javaJobs);
		List<Job> javaJobs2 = jobRepository.findByExperienceGreaterThan(1);
		System.out.println(javaJobs2);
	}

}
