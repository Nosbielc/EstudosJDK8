package livro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Captulo4 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Usuario 1", 100);
        Usuario user2 = new Usuario("Usuario 2", 120);
        Usuario user3 = new Usuario("Usuario 3", 140);
        Usuario user4 = new Usuario("Usuario 4", 160);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4);

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

        List<Usuario> usuariosParaUsoDePredicados = new ArrayList<>();
        usuariosParaUsoDePredicados.add(user1);
        usuariosParaUsoDePredicados.add(user2);
        usuariosParaUsoDePredicados.add(user3);
        usuariosParaUsoDePredicados.add(user4);

        usuariosParaUsoDePredicados.removeIf(predicado);
        usuariosParaUsoDePredicados.forEach(usuario -> System.out.println(usuario));

        
    }

}
