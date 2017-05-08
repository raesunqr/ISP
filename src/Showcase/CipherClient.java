package Showcase;

import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;

public class CipherClient
{
    public static void main(String[] args) throws Exception {


        // -Generate a DES key.
        Key k = KeyGenerator.getInstance("DES").generateKey();
        // -Store it in a file.
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DESKeyFile.txt"));
        out.writeObject(k);
        out.close();

        String message = "The quick brown fox jumps over the lazy dog.";
        String host = "127.0.0.1";
        int port = 7999;
        Socket s = new Socket(host, port);

        // -Use the key to encrypt the message above
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, k);
        // -Sends the encrypted object over socket s to the server
        ObjectOutputStream outSocket = new ObjectOutputStream(s.getOutputStream());
        byte[] bytes = cipher.doFinal(message.getBytes());
        outSocket.writeInt(bytes.length);
        outSocket.write(bytes);
        outSocket.close();
    }
}