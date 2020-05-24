package cn.springcloud.book.service;

import cn.springcloud.book.Person;
import reactor.core.publisher.Flux;

public interface PersonService {

    Flux<Person> findAll();

    Flux<Person> findAllById(Integer id);

    Flux<Person> findAllByName(String name);

    Flux<Person> findAllByAge(Integer age);
}
