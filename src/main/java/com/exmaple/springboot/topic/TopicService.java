package com.exmaple.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java","core java","java version 1.8"),
			new Topic("spring","spring context","version 4.2")));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i< topics.size(); i++){
			Topic top = topics.get(i);
			if(top.getId().equals(id)){
				topics.add(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(p -> p.getId().equals(id));
	}

}
