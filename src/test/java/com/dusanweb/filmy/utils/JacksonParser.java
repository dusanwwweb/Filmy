package com.dusanweb.filmy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonParser extends ObjectMapper {

    //Parsing the object to JSON
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
