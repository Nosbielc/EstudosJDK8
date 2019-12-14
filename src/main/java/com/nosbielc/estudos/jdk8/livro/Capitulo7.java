package com.nosbielc.estudos.jdk8.livro;

import com.nosbielc.estudos.jdk8.util.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static com.nosbielc.estudos.jdk8.livro.Usuario.usuarios;
import static java.util.stream.Collectors.toList;

public class Capitulo7 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        System.out.println(" ------ coleção simples ------ ");
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ Sublist ------ ");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        usuarios.subList(0, 2)
                .forEach(Usuario::tornaModerador);
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios = Util.shift(usuarios, Boolean.TRUE);

        System.out.println(" ------ Media ------ ");
        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();
        System.out.println("Media da lista: " + pontuacaoMedia);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ Como obter de volta uma lista? ------ ");
        List<Usuario> masQue20000 = new ArrayList<>();

        usuarios.stream()
                .filter(u -> u.getPontos() > 20000)
                .forEach(u -> masQue20000.add(u));
        masQue20000.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ Collectors ------ ");

        Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
        BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner = ArrayList::addAll;

        List<Usuario> masQue10000 = usuarios.stream()
                .filter(u -> u.getPontos() > 10000)
                .collect(supplier, accumulator, combiner);

        masQue10000.forEach(System.out::println);

        System.out.println(" ------ --------------------- ------ ");

        List<Usuario> masQue5000 = usuarios.stream()
                .filter(u -> u.getPontos() > 5000)
                .collect(supplier, accumulator, combiner);

        masQue5000.forEach(System.out::println);

        System.out.println(" ------ --------------------- ------ ");

        List<Usuario> masQue5999 = usuarios.stream()
                .filter(u -> u.getPontos() > 5999)
                .collect(toList());

        masQue5999.forEach(System.out::println);

        System.out.println(" ------ --------------------- ------ ");

        List<Usuario> masQue6999 = usuarios.stream()
                .filter(u -> u.getPontos() > 6999)
                .collect(toList());

        masQue6999.forEach(System.out::println);

        System.out.println(" ------ --------------------- ------ ");

        List<Integer> pontos = usuarios.stream()
                .map(Usuario::getPontos)
                .collect(toList());

        pontos.forEach(System.out::println);

        System.out.println(" ------ --------------------- ------ ");
    }



}
