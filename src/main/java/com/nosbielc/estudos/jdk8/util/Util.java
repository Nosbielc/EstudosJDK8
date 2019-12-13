package com.nosbielc.estudos.jdk8.util;

import com.nosbielc.estudos.jdk8.livro.Usuario;

import java.util.Collections;
import java.util.List;

public abstract class Util {

    public static List<Usuario> shift(List<Usuario> usuarios, Boolean print) {
        Collections.shuffle(usuarios);

        if (print) {
            System.out.println(" ------ Embaralhando a coleção ------ ");
            usuarios.forEach(System.out::println);
            System.out.println(" ------ --------------------- ------ ");
        }

        return usuarios;
    }

}
