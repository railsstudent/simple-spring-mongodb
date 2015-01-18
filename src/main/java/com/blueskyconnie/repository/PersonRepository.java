package com.blueskyconnie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blueskyconnie.domain.Person;

public interface PersonRepository extends MongoRepository<Person, ObjectId> {

}
