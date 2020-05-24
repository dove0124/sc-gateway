package cn.springcloud.book.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.springcloud.book.Person;
import cn.springcloud.book.dao.PersonRepository;
import cn.springcloud.book.service.PersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chujingnian
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Flux<Person> findAllById(Integer id) {
        return personRepository.findAllById(Mono.just(id));
    }

    @Override
    public Flux<Person> findAllByName(String name) {
        return personRepository.findAllByName(name);
    }

    @Override
    public Flux<Person> findAllByAge(Integer age) {
        return personRepository.findAllByAge(age);
    }
}
