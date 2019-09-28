package livro;

@FunctionalInterface
public interface Validador<T> {
    boolean valiida(T t);
}
