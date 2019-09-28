package livro;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface ConsumerCaptulo4<T> {

    void accept(T t);

    default Consumer<T> andThen(ConsumerCaptulo4<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
