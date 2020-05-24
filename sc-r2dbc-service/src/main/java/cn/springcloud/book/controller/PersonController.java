package cn.springcloud.book.controller;

import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.springcloud.book.Person;
import cn.springcloud.book.PersonDto;
import cn.springcloud.book.service.PersonService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonService personService;

    @GetMapping("/r2dbc")
    public void getPerson() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("findAll - $it");
        personService.findAll()
                     .log()
                     .subscribe();
        logger.info("findAllById - $it");
        personService.findAllById(1)
                     .log()
                     .subscribe();
        logger.info("findAllByName - $it");
        personService.findAllByName("Laura So")
                     .log()
                     .subscribe();
        logger.info("findAllByAge - $it");
        personService.findAllByAge(25)
                     .log()
                     .subscribe();
        Thread.sleep(5000);
    }

    @GetMapping("/findAll")
    public Flux<PersonDto> findPersons() {
        logger.info("findAll - $it");
        Flux<Person> personList = personService.findAll()
//                                               .log("findPersons", Level.ALL);
                                               .log();
        return personList.map(u -> translate(u));
    }

    private PersonDto translate(Person person) {
        PersonDto dto = new PersonDto();
        if (person != null) {
            BeanUtils.copyProperties(person, dto);
        }
        return dto;
    }
}
