package com.nosbielc.estudos.jdk8.livro;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 09/01/2020
 * @project EstudosJDK8
 */
public class FilesNio {

    private static final String PATH = "./src/main/java/com/nosbielc/estudos/jdk8/livro";
    private static final String TYPE_FILE = ".java";

    public static void main(String[] args) throws IOException {

        // Listando arquivos
        Files.list(Paths.get(PATH))
                .forEach(System.out::println);

        // Listando arquivos com filtros
        Files.list(Paths.get(PATH))
                .filter(p -> p.toString().endsWith(TYPE_FILE))
                .forEach(System.out::println);

        // Listando arquivos com filtros e apresentando conteudo
        Files.list(Paths.get(PATH))
                .filter(p -> p.toString().endsWith(TYPE_FILE))
                .map(p -> lines(p))
                .forEach(System.out::println);

        // Listando arquivos com filtros e apresentando conteudo
        Stream<Stream<String>> strings =
                Files.list(Paths.get(PATH))
                        .filter(p -> p.toString().endsWith(TYPE_FILE))
                        .map(p -> lines(p));

        strings.forEach(stringStream -> stringStream.forEach(System.out::println));

        // Achatando todas linhas dos arquivos em um stream
        Stream<String> stringsAchatados =
                Files.list(Paths.get(PATH))
                        .filter(p -> p.toString().endsWith(TYPE_FILE))
                        .flatMap(p -> lines(p));

        IntStream chars =
                Files.list(Paths.get(PATH))
                        .filter(p -> p.toString().endsWith(TYPE_FILE))
                        .flatMap(p -> lines(p))
                        .flatMapToInt((String s) -> s.chars());

        // Stream com a quantidade de linhas em cada arquivo
        LongStream longStream =
                Files.list(Paths.get(PATH))
                        .filter(p -> p.toString().endsWith(TYPE_FILE))
                        .mapToLong(p -> lines(p).count());

        System.out.println("longStream : " + longStream.count());

        // List com a quantidade de linhas em cada arquivo
        List<Long> longLis =
                Files.list(Paths.get(PATH))
                        .filter(p -> p.toString().endsWith(TYPE_FILE))
                        .map(p -> lines(p).count())
                        .collect(Collectors.toList());

        System.out.println("longLis : " + longLis.size());

        // Entregando resultado mais eficaz, pois mostra qual arquivo que contem os valores calculados
        Map<Path, Long> linesPerFile = new HashMap<>();
        Files.list(Paths.get(PATH))
                .filter(p -> p.toString().endsWith(TYPE_FILE))
                .forEach(
                        p -> linesPerFile.put(p, lines(p).count())
                );

        System.out.println("linesPerFile: " + linesPerFile.toString());

        // Melhoria no resultado
        Map<Path, List<String>> content =
                Files.list(Paths.get(PATH))
                        .filter(p -> p.toString().endsWith(TYPE_FILE))
                        .collect(
                                Collectors.toMap(Function.identity(),
                                        p -> lines(p).collect(Collectors.toList())));

        System.out.println("content: " + content);


        // Gerando agrupamentos
        BiFunction<String, Integer, Usuario> users = Usuario::new;
        List<Usuario> usuarios = Arrays.asList(
                users.apply("Fulano 1", 100).tornaModerador(),
                users.apply("Fulano 2", 150).tornaModerador(),
                users.apply("Fulano 3", 200),
                users.apply("Fulano 4", 120),
                users.apply("Fulano 5", 150)

        );

        Map<Integer, List<Usuario>> pontuacaoExe1 = new HashMap<>();
        for (Usuario u : usuarios) {
            pontuacaoExe1
                    .computeIfAbsent(u.getPontos(), user -> new ArrayList<>())
                    .add(u);
        }

        System.out.println("pontuacaoExe1: " + pontuacaoExe1);

        Map<Integer, List<Usuario>> pontuacaoMelhorExe =
                usuarios.stream().collect(Collectors.groupingBy(Usuario::getPontos));

        System.out.println("pontuacaoMelhorExe: " + pontuacaoMelhorExe);

        Map<Boolean, List<Usuario>> moderadores =
                usuarios.stream().collect(Collectors.partitioningBy(Usuario::isModerador));

        System.out.println("moderadores: " + moderadores);

        Map<Boolean, List<String>> nomesPorTipo =
                usuarios.stream().collect(
                        Collectors.partitioningBy(Usuario::isModerador,
                                Collectors.mapping(Usuario::getNome, Collectors.toList()))
                );

        System.out.println("nomesPorTipo: " + nomesPorTipo);

        Map<Boolean, Integer> pontuacaoPorTipo =
                usuarios.stream().collect(
                        Collectors.partitioningBy(
                            Usuario::isModerador,
                            Collectors.summingInt(Usuario::getPontos)
                        )
                );

        System.out.println("pontuacaoPorTipo: " + pontuacaoPorTipo);

        // Concatenando String's
        String nomes = usuarios.stream().map(Usuario::getNome)
                .collect(Collectors.joining(", "));

        System.out.println("nomes: " + nomes);

    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
