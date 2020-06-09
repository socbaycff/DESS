import java.util.Random;

public class ImageCrypt {
    // ma hoa anh voi key dc sinh ra, luu 2 file mahoa va file sau khi dc giai ma
    public void des() {
        try {
            //sinh key hexa random bang java
            String key = getRandomHexString(16);
            // ma hoa file anh image.jpg -> mahoa.enc
            execCmd("openssl enc -des-cbc -in image.png -out mahoa.enc -iv 0000000000000000 -K " + key);
            // giai ma mahoa.ecn -> newImage.jpg
            execCmd("openssl enc -des-cbc -d -in mahoa.enc -out newImage.png -iv 0000000000000000 -K " + key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // thuc thi lenh terminal
    public static void execCmd(String cmd) throws java.io.IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : ""); // in ket qua
    }
    // sinh key 64bit
    private static String getRandomHexString(int numchars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }
}
