package livro;

import java.util.Arrays;
import java.util.List;

public class Capitulo2 {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Gomes", 1);
        Usuario usuario2 = new Usuario("Silva", 2);
        Usuario usuario3 = new Usuario("Azevedo", 3);
        Usuario usuario4 = new Usuario("Julia", 4);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4);

        for (Usuario u : usuarios)
            System.out.println(u.getNome());
    }

}
