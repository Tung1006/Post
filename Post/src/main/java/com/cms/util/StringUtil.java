package com.cms.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {


    public static Object clone(Object object) {
        try {
            Class<?> myClass = object.getClass();
//            Object newObject = myClass.newInstance();
      Object newObject = myClass.getConstructor().newInstance();
            Field[] allFields = myClass.getDeclaredFields();
            for (Field field : allFields) {
                field.setAccessible(true);

                field.set(newObject, field.get(object));
            }

            return newObject;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Pageable getPageable(Integer page, Integer size, String[] textSort) {
        List<Sort.Order> list = new ArrayList<Sort.Order>();

        String[] sortDefault = { "id@asc" };
        if (textSort == null || textSort.length == 0) {
            textSort = sortDefault;
        }
        for (String orderSort : textSort) {
            if (orderSort.contains("@")) {
                String[] sortSplitStrings = orderSort.split("@");
                list.add(new Sort.Order(sortDirection(sortSplitStrings[1]), sortSplitStrings[0]));
            } else {
                list.add(new Sort.Order(sortDirection(""), orderSort));
            }
        }
        return PageRequest.of(page, size, Sort.by(list));
    }

    public static Sort.Direction sortDirection(String direction) {
        if (direction.equals("desc") || direction.equals("DESC")) {
            return Sort.Direction.DESC;
        } else
            return Sort.Direction.ASC;
    }
}
