package com.valerijovich.springbootjsonconverting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController is a convenience annotation for creating Restful controllers.
 * The JsonController will return our User class.
 * Here we do the transformation to json explicitly. This is useful if the json representation of an object needs
 * to be written to a database or log. To do this, you just need to inject an instance of the ObjectMapper class
 * into our controller and use its writeValuesAsString() method.
 */
@RestController
public class JsonController {

    /**
     * LoggerFactory is a special class for creating loggers, and getLogger is its static method.
     */
    private static final Logger log = LoggerFactory.getLogger(JsonController.class);

    /**
     * The ObjectMapper class provides functionality for reading and writing JSON,
     * and related functions for performing transformations.
     */
    private final ObjectMapper mapper;

    /**
     * We have one constructor in the controller, so we can omit the @Autowired annotation in front of the constructor.
     * Spring Boot sees the dependency on ObjectMapper and loads its instance into the controller.
     */
    public JsonController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * @GetMapping annotation is used to map web requests to Spring Controller methods.
     */
    @GetMapping
    public User getUser() throws JsonProcessingException {
        var user = new User();
        user.setFirstName("Neil");
        user.setLastName("deGrasse Tyson");
        user.setAge(62);
        log.info("Json: {}", mapper.writeValueAsString(user));
        return user;
    }
}