package com.nosbielc.estudos.jdk8.lombok;

import lombok.Builder;
import lombok.Singular;

import java.util.Set;

@Builder
public class BuilderExample {
    @Builder.Default private long created = System.currentTimeMillis();
    private String name;
    private int age;
    @Singular
    private Set<String> occupations;
}
