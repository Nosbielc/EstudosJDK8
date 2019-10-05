package livro;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario() {
    }

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = Boolean.FALSE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }

    public Usuario tornaModerador() {
        this.moderador = Boolean.TRUE;
        return this;
    }

    public static List<Usuario> usuarios() {
        Usuario user1 = new Usuario("Primeiro", 100);
        Usuario user2 = new Usuario("Segundo", 120);
        Usuario user3 = new Usuario("Terceiro", 140);
        Usuario user4 = new Usuario("Quarto", 160);

        return Arrays.asList(user1, user2, user3, user4);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("pontos=" + pontos)
                .add("moderador=" + moderador)
                .toString();
    }
}
