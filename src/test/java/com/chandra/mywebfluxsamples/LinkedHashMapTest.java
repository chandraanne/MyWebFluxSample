package com.chandra.mywebfluxsamples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedHashMapTest {
    private Map<String, String> linkedHashMap = new LinkedHashMap<>();
    private Map<String, String> normalHashMap = new HashMap<>();

    @BeforeEach
    public void initialize() {
        linkedHashMap.put("Orange", "Mandarin");
        linkedHashMap.put("Apple", "Fiji");

        normalHashMap.put("Orange", "Mandarin");
        normalHashMap.put("Apple", "Fiji");
    }

    @Test
    public void testOrderOfTheKeys() {
        //Keys sorted by Hashcode, hence Apple is first
        assertEquals("Apple",normalHashMap.keySet().stream().findFirst().get());

        //Order of the keys in maintained. Hence Orange is first
        assertEquals("Orange",linkedHashMap.keySet().stream().findFirst().get());
    }
}
