import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("ALL")
public class ImageCryptUI {
    private JPanel panel1;
    private JButton decryptBtn;
    private JButton encryptBtn;
    private JButton loadImageButton;
    private JLabel imageLabel;
    private JButton runDESBtn;
    private JLabel newImageLabel;


    public ImageCryptUI() {
        loadImageButton.addActionListener(actionEvent -> {
            ImageIcon imageIcon = new ImageIcon("image.png");
            imageLabel.setIcon(imageIcon);
            new ImageCrypt().des();
            JOptionPane.showMessageDialog(panel1, "Đã mã hoá tạo thành file cipher và giải mã tạo file newImage.png");
        });

        runDESBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon imageIcon = new ImageIcon("newImage.png");
                newImageLabel.setIcon(imageIcon);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ImageCrypt");
        frame.setContentPane(new ImageCryptUI().panel1);
        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
}

