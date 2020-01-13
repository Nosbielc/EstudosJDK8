package com.nosbielc.estudos.jdk8.livro.base;

@FunctionalInterface
interface Validador<T> {
	
	boolean valida(T t);
}