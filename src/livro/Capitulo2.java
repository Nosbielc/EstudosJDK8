package livro;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Gomes", 1);
        Usuario usuario2 = new Usuario("Silva", 2);
        Usuario usuario3 = new Usuario("Azevedo", 3);
        Usuario usuario4 = new Usuario("Julia", 4);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4);
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
