package by.academy.it.rest;

import by.academy.it.dao.PersonDao;
import by.academy.it.parking.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonController {

    @Autowired
    PersonDao personDao;

    @GetMapping("person/{id}")
    public ResponseEntity<Person> getPerson(
            @PathVariable("id") Long id) {
        Person person = personDao.readPerson(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons() {

        final List<Person> people = personDao.readPersons();
        if (people.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        final Serializable personId = personDao.savePerson(person);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final Person savedPerson = personDao.readPerson((Long) personId);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @DeleteMapping("person/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id){
        Person person = personDao.readPerson(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personDao.deletePerson(person);
        return new ResponseEntity<>(person, HttpStatus.NO_CONTENT);
    }
}
