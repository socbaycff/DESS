import javax.crypto.*;
import java.io.*;

public class ImageCrypt {
    // ma hoa anh voi key dc sinh ra, roi luu file ma hoa vao duong dan cipherPath
    // luu anh dc giai ma vao newPlainPath
    public void des(String plainPath, String cipherPath, String newPlainPath) {
        try {

            // sinh key
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            // tao object cipher
            Cipher desCipher = Cipher.getInstance("DES");
            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            // ma hoa
            FileInputStream plainIS = new FileInputStream(plainPath);
            FileOutputStream cipherOS = new FileOutputStream(cipherPath);
            CipherOutputStream outputStream = new CipherOutputStream(cipherOS, desCipher);
            writeData(plainIS, outputStream); // ghi ra cipher


            // giai ma
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            FileInputStream cipherIS = new FileInputStream(cipherPath);
            FileOutputStream newPlainOS = new FileOutputStream(newPlainPath);
            CipherInputStream inputStream = new CipherInputStream(cipherIS, desCipher);
            writeData(inputStream, newPlainOS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    // luu data tu 2 stream input output
    private static void writeData(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[1024];
        int numRead;
        // doc tu input stream ghi vao output stream
        while ((numRead = is.read(buf)) >= 0) {
            os.write(buf, 0, numRead);
        }
        os.close();
        is.close();
    }

}
