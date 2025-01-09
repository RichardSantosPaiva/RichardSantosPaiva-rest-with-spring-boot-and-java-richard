package br.com.richard.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.richard.data.vo.v1.PersonVO;
import br.com.richard.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonVO mockVO() {
        return mockVO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setFirstName("Fist name Test" + number);
        person.setLastName("Last name Test" + number);
        person.setAddress("address"+ number);;
        person.setId(number.longValue());
        person.setGender("gender" + number);
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setFirstName("Fist name Test" + number);
        person.setLastName("Last name Test" + number);
        person.setAddress("address"+ number);;
        person.setKey(number.longValue());
        person.setGender("gender" + number);
        return person;
    }

}
