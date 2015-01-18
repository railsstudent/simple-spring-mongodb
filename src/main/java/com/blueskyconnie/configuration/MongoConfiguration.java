package com.blueskyconnie.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.blueskyconnie.converter.PersonReadConverter;
import com.blueskyconnie.converter.PersonWriteConverter;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

//http://stackoverflow.com/questions/14930933/spring-not-using-mongo-custom-converters
@Component
@Configuration
@EnableMongoRepositories(basePackages={"com.blueskyconnie.repository"})
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Bean 
	public MongoDbFactory mongoDbFactory() throws Exception {
	    return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "mydb");
    }
	
	@Bean 
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
    }
	
	@Override
	protected String getMappingBasePackage() {
		return "com.blueskyconnie.domain";
	}

	@Override
	@Bean
	public MappingMongoConverter mappingMongoConverter() throws Exception {
	    MappingMongoConverter converter = new MappingMongoConverter(
	    		new DefaultDbRefResolver(mongoDbFactory()), mongoMappingContext());
	    converter.setCustomConversions(customConversions());
	    return converter;
	}
	
	@Override
	@Bean
	public CustomConversions customConversions() {
		List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
	    converterList.add(new PersonReadConverter());
	    converterList.add(new PersonWriteConverter());
	    return new CustomConversions(converterList);
	}

	@Override
	protected String getDatabaseName() {
		return "mydb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost", 27017);
	}
	
}
