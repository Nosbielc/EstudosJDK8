package com.nosbielc.estudos.jdk8.livro;

import java.util.List;
import java.util.function.Consumer;

import static com.nosbielc.estudos.jdk8.livro.Usuario.usuarios;

public class Capitulo2 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();
        //metodos antivos
        for (Usuario u : usuarios)
            System.out.println(u.getNome());
        // Usando consumer
        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        // usando classe anônima
        Consumer<Usuario> mostrador2 = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };
        usuarios.forEach(mostrador2);

        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        Consumer<Usuario> mostrador3 = (Usuario u) -> {
            System.out.println(u.getNome());
        };

    }

}
