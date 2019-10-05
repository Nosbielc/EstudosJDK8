package generics;

import java.util.ArrayList;
import java.util.Collection;

public class LowerUpperBound {

    public static void validateTillStringType(Collection<? super String> collection) {
        // Curinga com limite inferior
        // Aceita coleção de objetos do tipo string ou SUPER-CLASS of String
    }

    public static void validateStringTypes(Collection<? extends String> collection) {
        // Curinga com limite superior
         // Aceita coleção de objetos do tipo string ou SUB-CLASS of String
    }

    public static void main(String[] args) {
        LowerUpperBound.validateTillStringType(new ArrayList<Object>());//OK

//      LowerUpperBound.validateTillStringType(new ArrayList<Integer>());//Error

//      LowerUpperBound.validateStringTypes(new ArrayList<Object>());//Error

        LowerUpperBound.validateStringTypes(new ArrayList<String>());//OK

    }


}
