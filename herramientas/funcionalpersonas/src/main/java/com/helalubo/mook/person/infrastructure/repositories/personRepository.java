package com.helalubo.mook.person.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helalubo.mook.person.model.Person;
import com.helalubo.util.Json;

import org.json.simple.JSONArray;

public class personRepository {

    public List<Person> findAllPerson() throws JsonMappingException, JsonProcessingException {
        JSONArray data = null;
        List<Person> people = new ArrayList<Person>();
        data = Json.LeerArrayJson("/src/main/java/com/helalubo/database/people.json");
        ObjectMapper mapper = new ObjectMapper();
        people = mapper.readValue(data.toJSONString(), new TypeReference<List<Person>>() {
        });

        return people;
    }

}
