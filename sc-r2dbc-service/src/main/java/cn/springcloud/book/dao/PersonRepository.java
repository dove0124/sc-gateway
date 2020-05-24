package cn.springcloud.book.dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import cn.springcloud.book.Person;
import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Integer> {

    //  @Query("SELECT * FROM people WHERE name = $1")
    @Query("SELECT * FROM people WHERE name = :name")
    Flux<Person> findAllByName(String name);

    //  @Query("SELECT * FROM people WHERE age = $1")
    @Query("SELECT * FROM people WHERE age = :age")
    Flux<Person> findAllByAge(Integer age);
}
