package com.daelly.common.sample.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.Map;

public class GsonTest {

    public static void main(String[] args) {
        String content = "{\"name\":\"Daelly\",\"age\":18,\"gender\":true,\"attribute\":{\"sport\":\"basketball\",\"art\":\"drawing\",\"ent\":\"game\"}}";
        Gson gson = new Gson();
        JsonElement element = JsonParser.parseString(content);
        System.out.println(element.isJsonObject());
    }

    public String function(String name, int age, boolean gender, Map<String, Object> attribute) {
        return name + " with age " + age + " and gender " + gender + " has attribute " + attribute;
    }
}
