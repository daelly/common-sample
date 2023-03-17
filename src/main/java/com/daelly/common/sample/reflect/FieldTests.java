package com.daelly.common.sample.reflect;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.Field;
import java.util.List;

public class FieldTests {

    public static void main(String[] args) throws Exception {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setName("daelly");
        bean.setTagIds(ImmutableList.of(3, 34, 54));

        Field field = bean.getClass().getDeclaredField("tagIds");
        field.setAccessible(true);
        System.out.println(field.get(bean));

    }

    static class Bean {
        private int id;

        private String name;

        private List<Integer> tagIds;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getTagIds() {
            return tagIds;
        }

        public void setTagIds(List<Integer> tagIds) {
            this.tagIds = tagIds;
        }
    }
}
