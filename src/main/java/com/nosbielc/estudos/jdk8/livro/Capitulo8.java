package com.nosbielc.estudos.jdk8.livro;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.nosbielc.estudos.jdk8.livro.Usuario.usuarios;

public class Capitulo8 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        System.out.println("Media : " + pontuacaoMedia);

        double pontuacaoMedia2 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .orElse(0);

        System.out.println("Media 2: " + pontuacaoMedia2);

        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparing(Usuario::getPontos));
        Usuario maximaPontuacao = max.get();

        System.out.println("Maxima Pontuação: " + maximaPontuacao);

        double sumPontuacao = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();

        int valorInicial = 0;
        IntBinaryOperator operacao = (a, b) -> a + b;

        int total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(valorInicial, operacao);

        int total2 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, (a, b) -> a + b);

        int total3 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, Integer::sum);

        int multiplicacao = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(1, (a, b) -> a * b);

        int total4 = usuarios.stream()
                .reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);

        boolean hasModerador = usuarios.stream()
                .anyMatch(Usuario::isModerador);
        System.out.println("hasModerador: " + hasModerador);

        boolean AllHasModerador = usuarios.stream()
                .allMatch(Usuario::isModerador);
        System.out.println("AllHasModerador: " + AllHasModerador);

        boolean NoneHasModerador = usuarios.stream()
                .noneMatch(Usuario::isModerador);
        System.out.println("NoneHasModerador: " + NoneHasModerador);

        Random random = new Random(0);
        Supplier<Integer> supplier = () -> random.nextInt();
        Stream<Integer> stream = Stream.generate(supplier);

        IntStream stream1 = IntStream.generate(() -> random.nextInt());

        IntStream stream2 = IntStream.generate(() -> random.nextInt());
        List<Integer> list =  stream2
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista gerada pelo Curto-circuito: " + list);

        List<Integer> list2 = IntStream
                .generate(() -> random.nextInt())
                .limit(1298)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista gerada pelo Curto-circuito: com interface Fluente: " + list);

    }
}
