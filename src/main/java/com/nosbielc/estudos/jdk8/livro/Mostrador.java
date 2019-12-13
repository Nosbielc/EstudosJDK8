package com.nosbielc.estudos.jdk8.livro;

import java.util.function.Consumer;

class Mostrador implements Consumer<Usuario> {
    @Override
    public void accept(Usuario u) {
        System.out.println(u.getNome());
    }
}
