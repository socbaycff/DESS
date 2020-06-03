import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageCryptUI {
    private JPanel panel1;
    private JButton decryptBtn;
    private JButton encryptBtn;
    private JButton loadImageButton;
    private JLabel imageLabel;
    private JButton runDESBtn;


    String imageUrl;

    public ImageCryptUI() {
        loadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                    imageUrl = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
                    ImageIcon imageIcon = new ImageIcon(imageUrl);
                    imageLabel.setIcon(imageIcon);
                }

            }
        });

        runDESBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int indexOf = imageUrl.lastIndexOf('/');
                String substring = imageUrl.substring(0, indexOf+1);
                new ImageCrypt().des(imageUrl,substring+"cipher",substring+ "newImage.jpg");
                JOptionPane.showMessageDialog(panel1, "Đã mã hoá tạo thành file cipher và giải mã tạo file newImage.jpg, đặt chung thư mục file input");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ImageCrypt");
        frame.setContentPane(new ImageCryptUI().panel1);
        frame.setBounds(50,50,500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
}

