package livro;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static livro.Usuario.usuarios;

public class Capitulo5 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario o1, Usuario o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };
        System.out.println(" ------ coleção sem ordenação ------ ");
        usuarios.forEach(u -> System.out.println(u));
        System.out.println(" ------ --------------------- ------ ");

        Collections.sort(usuarios, comparator);

        System.out.println(" ------ coleção com ordenação ------ ");
        usuarios.forEach(u -> System.out.println(u));
        System.out.println(" ------ --------------------- ------ ");

        List<String> palavras = Arrays.asList("Nosbielc", "Ehureka Games", "Space Shooter");

        palavras.sort(Comparator.naturalOrder());

        System.out.println(" ------ Ordem natural ------ ");
        palavras.forEach(p -> System.out.println(p));
        System.out.println(" ------ --------------------- ------ ");
    }

}
