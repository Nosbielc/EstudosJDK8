package com.nosbielc.estudos.jdk8.livro;

import com.nosbielc.estudos.jdk8.util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;
import static com.nosbielc.estudos.jdk8.livro.Usuario.usuarios;

public class Capitulo6 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        System.out.println(" ------ coleção simples ------ ");
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios.forEach(Usuario :: tornaModerador);

        System.out.println(" ------ coleção que foram usados os methods references ------ ");
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ coleção com comparação mais enxuta ------ ");
        usuarios.sort(comparing(Usuario :: getNome));
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios = Util.shift(usuarios, Boolean.TRUE);

        System.out.println(" ------ coleção com comparação mais enxuta com metodos staticos ------ ");
        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios = Util.shift(usuarios, Boolean.TRUE);

        System.out.println(" ------ coleção com comparação usando o comparingInt ------ ");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios = Util.shift(usuarios, Boolean.TRUE);

        System.out.println(" ------ coleção com comparação usando o comparingInt e comparing forma 1------ ");
        Comparator<Usuario> comparatorCmplexo1 = Comparator.comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome);
        usuarios.sort(comparatorCmplexo1);
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios = Util.shift(usuarios, Boolean.TRUE);

        System.out.println(" ------ coleção com comparação usando o comparingInt e comparing forma 2 ------ ");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome));
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        usuarios = Util.shift(usuarios, Boolean.TRUE);

        System.out.println(" ------ coleção com comparação usando o comparingInt e reversed ------ ");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ Referenciando construtores ------ ");
        Supplier<Usuario> usuarioSupplier = Usuario::new;
        Usuario novoUsuario = usuarioSupplier.get();
        System.out.println(novoUsuario);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ Referenciando construtores com argumentos ------ ");
        Function<String, Usuario> usuarioFunction = Usuario::new;
        Usuario joao = usuarioFunction.apply("João");
        Usuario maria = usuarioFunction.apply("Maria");
        System.out.println(joao);
        System.out.println(maria);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ (BiFunction) Referenciando construtores com argumentos ------ ");
        BiFunction<String, Integer, Usuario> usuarioFunction2 = Usuario::new;
        Usuario joao2 = usuarioFunction2.apply("João", 100);
        Usuario maria2 = usuarioFunction2.apply("Maria", 200);
        System.out.println(joao2);
        System.out.println(maria2);
        System.out.println(" ------ --------------------- ------ ");
    }



}
