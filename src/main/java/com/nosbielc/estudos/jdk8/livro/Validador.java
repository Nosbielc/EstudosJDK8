package com.nosbielc.estudos.jdk8.livro;

@FunctionalInterface
public interface Validador<T> {
    boolean valiida(T t);
}
