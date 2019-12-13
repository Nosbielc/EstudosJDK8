package com.nosbielc.estudos.jdk8.livro;

public class Capitulo3 {

    public static void main(String[] args) {
        Validador<String> validadorCEP = new Validador<String>() {
            @Override
            public boolean valiida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        Validador<String> validadorCEP2 =
                valor -> { return valor.matches("[0-9]{5}-[0-9]{3}");
        };

        System.out.println(validadorCEP.valiida("54325-222"));
        System.out.println(validadorCEP2.valiida("5432-222"));



    }
}
