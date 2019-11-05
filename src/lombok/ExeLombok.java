package lombok;

import java.util.Objects;

public class ExeLombok {

    public static void main(String[] args) {
        BuilderExample builder = BuilderExample.builder()
                .age(25)
                .created(System.currentTimeMillis())
                .name("Fulano")
                .occupation("Faz nada sauro")
                .occupation("Faz nada sauro 2")
                .build();

        if (Objects.isNull(builder)) {
            System.out.println("Is Null");
        } else {
            System.out.println("No Null");
        }
    }

}
