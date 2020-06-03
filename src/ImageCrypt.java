import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class ImageCrypt {

    public void des(String plainPath, String cipherPath, String newPlainPath) {
        try {

            // sinh key
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            // tao object cipher
            Cipher desCipher = Cipher.getInstance("DES");
            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);


            FileInputStream plainIS = new FileInputStream(plainPath);
            FileOutputStream cipherOS = new FileOutputStream(cipherPath);
            CipherOutputStream outputStream = new CipherOutputStream(cipherOS, desCipher);
            writeData(plainIS,outputStream); // ghi ra cipher


            // giai ma
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            FileInputStream cipherIS = new FileInputStream(cipherPath);
            FileOutputStream newPlainOS = new FileOutputStream(newPlainPath);
            CipherInputStream inputStream = new CipherInputStream(cipherIS,desCipher);
            writeData(inputStream,newPlainOS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static void writeData(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[1024];
        int numRead = 0;
        // read and write operation
        while ((numRead = is.read(buf)) >= 0) {
            os.write(buf, 0, numRead);
        }
        os.close();
        is.close();
    }

}
