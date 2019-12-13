package com.nosbielc.estudos.jdk8.arquivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CargaHorariaServidores {

    // Pattern que será usado no arquivo
    private static final Pattern HORAS = Pattern
            .compile(".*([0-9]{2}(,[0-9])? HORAS SEMANAIS|DEDICACAO EXCLUSIVA).*");

    public static void main(String[] args) throws IOException {

        Path caminho = Paths.get(System.getProperty("user.home"),
                "Downloads/201901_Servidores/201901_Cadastro.csv");     // Carrega o arquivo .csv

        System.out.println(String.format("Linhas no Arquivo: %s",
                Files.lines(caminho, StandardCharsets.ISO_8859_1).count()));    // Exibe quantas linhas tem no arquivo

        //v1(caminho); // versão base para testes
        //v2(caminho); // versão base para testes
        //v3(caminho); // versão base para testes
        v4(caminho); // versão mais proxima do melhor resultado
    }

    /**
     * Metodo que pega os dados importantes do arquivo baseado em regex
     * @param caminho
     * @throws IOException
     */
    public static void v1(Path caminho) throws IOException {
        Stream<String> linhas = Files.lines(caminho,
                StandardCharsets.ISO_8859_1);

        Stream<String> horasSemanais = linhas.map(linha -> {
            Matcher matcher = HORAS.matcher(linha);
            return matcher.matches() ? matcher.group(1) : "";
        });

        horasSemanais.forEach(System.out::println);

    }

    /**
     * Metodo tem um acrescimo agora que retira as linhas vazias
     * @param caminho
     * @throws IOException
     */
    public static void v2(Path caminho) throws IOException {
        Stream<String> linhas = Files.lines(caminho,
                StandardCharsets.ISO_8859_1);

        Stream<String> horasSemanais = linhas.map(linha -> {
            Matcher matcher = HORAS.matcher(linha);
            return matcher.matches() ? matcher.group(1) : "";
        });

        Stream<String> horasSemanaisNaoVazias = horasSemanais
                .filter(horaSemanal -> !horaSemanal.isEmpty());

        horasSemanaisNaoVazias.forEach(System.out::println);

    }

    /**
     * Metodo adiciona o agrupamento como resultado final
     * @param caminho
     * @throws IOException
     */
    public static void v3(Path caminho) throws IOException {
        Stream<String> linhas = Files.lines(caminho,
                StandardCharsets.ISO_8859_1);

        Stream<String> horasSemanais = linhas.map(linha -> {
            Matcher matcher = HORAS.matcher(linha);
            return matcher.matches() ? matcher.group(1) : "";
        });

        Stream<String> horasSemanaisNaoVazias = horasSemanais
                .filter(horaSemanal -> !horaSemanal.isEmpty());

        Map<String, Long> horasSemanaisAgrupadas = horasSemanaisNaoVazias
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(horasSemanaisAgrupadas);

    }

    /**
     * Processo completo com simplificações pontuais em cada metodo
     * @param caminho
     * @throws IOException
     */
    public static void v4(Path caminho) throws IOException {
        Files.lines(caminho, StandardCharsets.ISO_8859_1)       // Executa a leitura das linhas do arquivo
                // Extrai a linha relevante
                .map(linha -> {
                    Matcher matcher = HORAS.matcher(linha);
                    return matcher.matches() ? matcher.group(1) : "";
                })
                // aplica o filtro para retirar linhas em branco
                .filter(horaSemanal -> !horaSemanal.isEmpty())
                // ordena o resultado
                .sorted()
                // Realiza o agrupamento dos dados
                .collect(
                        Collectors.groupingBy(Function.identity(),
                                LinkedHashMap::new, Collectors.counting()))
                // Imprime resultado de forma amigavél
                .forEach((k, v) -> System.out.println(v + "\t" + k));
    }

    @Deprecated
    public static Stream<String> chunks(Path path, int chunkSize) throws IOException {
        return chunks(path, chunkSize, StandardCharsets.UTF_8);
    }

    @Deprecated
    public static Stream<String> chunks(Path path, int chunkSize, Charset cs)
            throws IOException {
        Objects.requireNonNull(path);
        Objects.requireNonNull(cs);
        if(chunkSize<=0) throw new IllegalArgumentException();

        CharBuffer cb = CharBuffer.allocate(chunkSize);
        BufferedReader r = Files.newBufferedReader(path, cs);
        return StreamSupport.stream(
                new Spliterators.AbstractSpliterator<String>(
                        Files.size(path)/chunkSize, Spliterator.ORDERED| Spliterator.NONNULL) {
                    @Override public boolean tryAdvance(Consumer<? super String> action) {
                        try { do {} while(cb.hasRemaining() && r.read(cb)>0); }
                        catch (IOException ex) { throw new UncheckedIOException(ex); }
                        if(cb.position()==0) return false;
                        action.accept(cb.flip().toString());
                        return true;
                    }
                }, false).onClose(() -> {
            try { r.close(); } catch(IOException ex) { throw new UncheckedIOException(ex); }
        });
    }
}
