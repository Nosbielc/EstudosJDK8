package com.nosbielc.estudos.jdk8.livro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.nosbielc.estudos.jdk8.livro.Usuario.usuarios;

public class PipelineParalelo {

    public static void main(String[] args) {
        List<Usuario> usuarios = usuarios();

        List<Usuario> filtradosOrdenados = usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());

        System.out.println("filtradosOrdenados: " +filtradosOrdenados);

        // Teste parelelo
        long sum = LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();

        System.out.println("sum : " + sum);

    }

}
