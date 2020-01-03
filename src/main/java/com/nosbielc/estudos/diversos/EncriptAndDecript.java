package com.nosbielc.estudos.diversos;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Timer;
import java.util.stream.Stream;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 03/01/2020
 * @project EstudosJDK8
 */
public class EncriptAndDecript {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "******$*********".getBytes();
    private static Key key;
    private static final String FILE = "yolossson";

    public static void main(String args[]) throws Exception {
        key = generateKey();

//        Path caminho = Paths.get(System.getProperty("user.home"),
//                "Documents/testeScript.sql");
//
//        Stream<String> linhas = Files.lines(caminho,
//                StandardCharsets.ISO_8859_1);
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        linhas.forEach(l -> {
//            stringBuilder.append(l);
//        });

        LocalDateTime startEncrypt = LocalDateTime.now();
        String encriptValue = encrypt(FILE);
        LocalDateTime EndEncrypt = LocalDateTime.now();

        System.out.println(encriptValue);

        LocalDateTime startDecrypt = LocalDateTime.now();
        String resultado = decrypt(encriptValue);
        LocalDateTime endDecrypt = LocalDateTime.now();

        System.out.println("periodEncrypt " + ChronoUnit.SECONDS.between(startEncrypt, EndEncrypt));
        System.out.println("periodDecrypt " + ChronoUnit.SECONDS.between(startDecrypt, endDecrypt));

        System.out.println(resultado == FILE);
    }

    public static String encrypt(String valueToEnc) throws Exception {

//        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);

        System.out.println("valueToEnc.getBytes().length "+valueToEnc.getBytes().length);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        System.out.println("encValue length" + encValue.length);
        byte[] encryptedByteValue = Base64.getEncoder().encode(encValue);
        String encryptedValue = new String(encryptedByteValue);
        System.out.println("encryptedValue " + encryptedValue);

        return encryptedValue;
    }

    public static String decrypt(String encryptedValue) throws Exception {
//        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] decordedValue = Base64.getDecoder().decode(encryptedValue.getBytes());

        byte[] decryptedVal  = c.doFinal(decordedValue);

//        return decryptedVal.toString();
        return new String(decryptedVal);
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
}
