package com.jnit.practice.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courserepository;

	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("One",
	 * "Java", "Java Technology"), new Topic("Two", "Spring", "Spring Framework"),
	 * new Topic("Three", "JavaScript", "JavaScript Technology")));
	 */
	// just one copy of topic list, not creating new one every time
	public List<Course> getAllCourses(String topicId) {
		// return topics;
		List<Course> courses = new ArrayList<>();
		//courserepository.findAll().forEach(courses::add);
		courserepository.findByTopicId(topicId).forEach(courses::add);
		{
			return courses;
		}

	}

	public Optional<Course> getCourse(String id) {
		return courserepository.findById(id);
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		// lambda expression; for a given topic, get the id of the topic and check if it
		// equals
		// to the id that is being passed

	}

	public void addCourse(Course course) {
		// topics.add(topic);
		courserepository.save(course);
	}

	public void updateCourse(Course course) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic t = topics.get(i); if
		 * (t.getId().equals(id)) { topics.set(i, topic); return;
		 */
		courserepository.save(course);

	}

	public void deleteCourse(String id) {
		courserepository.deleteById(id);
	}
}
