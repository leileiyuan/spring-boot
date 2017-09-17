package com.belongtou.service;

import com.belongtou.model.Person;

public interface DemoService {
	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);

}
