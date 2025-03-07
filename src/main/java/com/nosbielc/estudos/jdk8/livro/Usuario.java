package com.nosbielc.estudos.jdk8.livro;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.BiFunction;

public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = Boolean.FALSE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }

    public Usuario tornaModerador() {
        this.moderador = Boolean.TRUE;
        return this;
    }

    public static List<Usuario> usuarios() {
        BiFunction<String, Integer, Usuario> userFunction = Usuario::new;
        Usuario user1 = userFunction.apply("Primeiro", new Random().ints(50, (17323 + 1)).limit(1).findFirst().getAsInt());
        Usuario user2 = userFunction.apply("Segundo", new Random().ints(23, (1563 + 1)).limit(1).findFirst().getAsInt());
        Usuario user3 = userFunction.apply("Terceiro", new Random().ints(22, (179923 + 1)).limit(1).findFirst().getAsInt());
        Usuario user4 = userFunction.apply("Quarto", new Random().ints(1, (98700 + 1)).limit(1).findFirst().getAsInt());

        return Arrays.asList(user1, user2, user3, user4);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("pontos=" + pontos)
                .add("moderador=" + moderador)
                .toString();
    }
}
