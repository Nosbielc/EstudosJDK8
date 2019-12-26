package com.nosbielc.estudos.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/12/2019
 * @project EstudosJDK8
 */
public class MetodoPeek {

    public static void main(String... args) {

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////\n");

        List linguagens = Arrays.asList("Java", "C", "PHP", "Scala", "Go");
        // O codigo não imprime nada
        linguagens.stream().peek(System.out::println);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////\n");

        List<String> linguagens2 = linguagens;
        // O codigo imprime os dados da lista
        List<String> newLinguagens = linguagens2.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////\n");

        List<String> linguagensFullTest = Stream.of("Java", "C", "PHP", "Scala", "Go", "C#", "Ruby", "Python",
                "R", "Object-C", "Swift", "TypeScript", "C++", "JavaScript")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Valor Filtrado: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println(String.format("Mapeando Valor: %s \n", e)))
                .collect(Collectors.toList());

        linguagensFullTest.forEach(System.out::println);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////\n");

        Stream.of("Renout", "Fiat", "Volkswagen" , "Chevrolet", "Hyndai", "Caoa Chery", "Ford", "Aston Martin", "Audi",
                "Bentley", "BMW", "Chrysler", "Citroën", "Jeep")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Valor Filtrado: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println(String.format("Mapeando Valor: %s \n", e)))
                .collect(Collectors.toList());

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////\n");
    }

}
