package livro;

class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

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
}
