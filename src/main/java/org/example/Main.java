package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws Exception {

        Person person1 = new Person("Benjamin","19","admin@dataindev.com");

        Person person2 = new Person("Benjamin","19","admin@dataindev.com");

        byte[] person1bytes = person1.toString().getBytes();
        byte[] person2bytes = person2.toString().getBytes();

        System.out.println(person1bytes+" - "+person1);
        System.out.println(person2bytes+" - "+person2);

        System.out.println(calculateChecksum(person1bytes,"SHA-256"));
        System.out.println(calculateChecksum(person2bytes,"SHA-256"));


    }

    private static String calculateChecksum(byte[]data , String algorithm) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] checksumBytes = digest.digest(data);

        StringBuilder checksum = new StringBuilder();
        for(byte b : checksumBytes){
            checksum.append(String.format("%02x", b));
        }

        return checksum.toString();
    }


}