package com.example.spring.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FamilyController {

    @Autowired
    JdbcOperations jdbcOperations;
    @RequestMapping(value = "/api/v1/member",method = RequestMethod.PUT)
    public ResponseEntity addMember(@RequestBody Map<String,Object> request) {

        String ADD_MEMBER_QUERY = "CREATE (a:Person {name:?,gender:?})";

        jdbcOperations.update(ADD_MEMBER_QUERY,new Object[]{request.get("name").toString(),request.get("gender").toString()});
        Map<String,Object> response = new HashMap<>();
        response.put("status",true);
        return  ResponseEntity.ok(response);
    }
}
