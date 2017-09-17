package com.belongtou.service;

import com.belongtou.dao.PersonRepository;
import com.belongtou.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Cacheable(value = "person",key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("保存了id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "person")
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @Cacheable(value = "person",key = "#person.id")
    public Person findOne(Person person) {
        Person person1 = (Person) personRepository.findOne(person.getId());
        System.out.println("为id、key为:" + person1.getId() + "数据做了缓存");
        return person1;
    }

}
