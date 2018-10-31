package com.jnit.practice.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicrepository;

	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("One",
	 * "Java", "Java Technology"), new Topic("Two", "Spring", "Spring Framework"),
	 * new Topic("Three", "JavaScript", "JavaScript Technology")));
	 */
	// just one copy of topic list, not creating new one every time
	public List<Topic> getAllTopics() {
		// return topics;
		List<Topic> topics = new ArrayList<>();
		topicrepository.findAll().forEach(topics::add);
		{
			return topics;
		}

	}

	public Optional<Topic> getTopic(String id) {
		return topicrepository.findById(id); 
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		// lambda expression; for a given topic, get the id of the topic and check if it
		// equals
		// to the id that is being passed

	}

	public void addTopic(Topic topic) {
		// topics.add(topic);
		topicrepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic t = topics.get(i); if
		 * (t.getId().equals(id)) { topics.set(i, topic); return;
		 */
		topicrepository.save(topic);

	}

	public void deleteTopic(String id) {
		topicrepository.deleteById(id);
	}
}
