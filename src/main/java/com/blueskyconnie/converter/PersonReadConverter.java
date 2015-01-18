package com.blueskyconnie.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.blueskyconnie.domain.Person;
import com.blueskyconnie.domain.Person.Gender;
import com.mongodb.DBObject;

@ReadingConverter
public class PersonReadConverter implements Converter<DBObject, Person>{

	@Override
	public Person convert(DBObject source) {
		Person p = new Person((ObjectId) source.get("_id"), (String) source.get("firstname"), 
				(String) source.get("lastname"), Gender.valueOf("" + source.get("gender")));
	    return p;	
	}

}
