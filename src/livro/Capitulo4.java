package livro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static livro.Usuario.usuarios;

public class Capitulo4 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        ConsumerCaptulo4<Usuario> mostrarMensagem = usuario -> {
            System.out.println("Antes de imprimir os nomes");
        };

        ConsumerCaptulo4<Usuario> imprimeNome = usuario -> {
            System.out.println(usuario.getNome());
        };

        usuarios.forEach(mostrarMensagem.andThen(imprimeNome));

        // Usando predicados

        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 140;
            }
        };

        List<Usuario> usuariosParaUsoDePredicados = usuarios();

        usuariosParaUsoDePredicados.removeIf(predicado);
        usuariosParaUsoDePredicados.forEach(usuario -> System.out.println(usuario));

        System.out.println("Exemplo 2 com predicados ");

        List<Usuario> usuariosParaUsoDePredicados2 = usuarios();

        usuariosParaUsoDePredicados2.removeIf(u -> u.getPontos() > 100);
        usuariosParaUsoDePredicados2.forEach(usuario -> System.out.println(usuario));

    }

}
