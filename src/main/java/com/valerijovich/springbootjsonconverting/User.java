package com.valerijovich.springbootjsonconverting;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The @JsonPropertyOrder annotation allows you to sort fields alphabetically.
 * Using the @JsonInclude annotation, we indicate at the level of the entire class that only fields with
 * not-null values are included in json. This option is preferable to @JsonIgnore,
 * because it sets the uniform behavior of all fields of the object.
 * The User class is a class that contains some information about the user.
 */
@JsonPropertyOrder(alphabetic = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    /**
     * The @JsonProperty annotation allows you to change the field name in json without changing the field name in java.
     */
    @JsonProperty("Person name")
    private String firstName;

    @JsonProperty("Person surname")
    private String lastName;

    @JsonProperty("Person age")
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}