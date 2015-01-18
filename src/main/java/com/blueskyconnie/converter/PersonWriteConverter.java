package com.blueskyconnie.converter;

import org.springframework.core.convert.converter.Converter;

import com.blueskyconnie.domain.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PersonWriteConverter implements Converter<Person, DBObject> {

	@Override
	public DBObject convert(Person source) {
		DBObject dbo = new BasicDBObject();
		
		dbo.put("_id", source.getId());
		dbo.put("firstname", source.getFirstname());
		dbo.put("lastname", source.getLastname());
		dbo.put("gender", source.getGender().toString());

		return dbo;
	}

}
