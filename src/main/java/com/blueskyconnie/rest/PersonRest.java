package com.blueskyconnie.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.blueskyconnie.domain.Person;
import com.blueskyconnie.repository.PersonRepository;

@Component
@Path("/rest/persons")
public class PersonRest {

	@Inject
	private PersonRepository personRepository;
		
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(personRepository.findAll()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") String id) {
		
		ObjectId personId = new ObjectId(id);
		Person person = personRepository.findOne(personId);
		if (person == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(person).build();
	}
}
