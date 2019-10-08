package livro;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

import static livro.Usuario.usuarios;

public class Capitulo8 {

    public static void main(String[] args) {

        List<Usuario> usuarios = usuarios();

        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        System.out.println("Media : " + pontuacaoMedia);

        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparing(Usuario::getPontos));
        Usuario maximaPontuacao = max.get();

        System.out.println("Maxima Pontuação: " + maximaPontuacao);

        double sumPontuacao = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();

        int valorInicial = 0;
        IntBinaryOperator operacao = (a, b) -> a + b;

        int total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(valorInicial, operacao);

        int total2 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, (a, b) -> a + b);

        int total3 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, Integer::sum);

        int multiplicacao = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(1, (a, b) -> a * b);

        int total4 = usuarios.stream()
                .reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);

    }
}
