	package br.com.richard.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.richard.data.vo.v1.PersonVO;
import br.com.richard.data.vo.v2.PersonVOV2;
import br.com.richard.exceptions.ResourceNotFoundException;
import br.com.richard.mapper.DozerMapper;
import br.com.richard.mapper.custom.PersonMapper;
import br.com.richard.model.Person;
import br.com.richard.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll(){
		logger.info("find all people!");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id){
		logger.info("finding one person!");
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		return DozerMapper.parseObject(entity,PersonVO.class);		
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("creating one person!");
		var entity =  DozerMapper.parseObject(person, Person.class);
		var vo =  DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("creating one person with V2!");
		var entity =  mapper.convertVoToEntityToVo(person);
		var vo =  mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("updating one person!");
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo =  DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		repository.delete(entity);
	}
}