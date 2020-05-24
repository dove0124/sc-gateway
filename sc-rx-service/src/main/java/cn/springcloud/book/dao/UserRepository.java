package cn.springcloud.book.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import cn.springcloud.book.model.document.UserPO;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserPO, Long> {

    Flux<UserPO> findByName(String name);
}
