package livro;

import util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;
import static livro.Usuario.usuarios;

public class Capitulo7 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        System.out.println(" ------ coleção simples ------ ");
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");

        System.out.println(" ------ coleção simples ------ ");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        usuarios.subList(0, 10)
                .forEach(Usuario::tornaModerador);
        usuarios.forEach(System.out::println);
        System.out.println(" ------ --------------------- ------ ");


    }



}
