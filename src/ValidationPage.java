import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidationPage {
    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ValidationPage window = new ValidationPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ValidationPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Load background image
        ImageIcon backgroundImage = new ImageIcon("C:/Users/Windows/OneDrive/Desktop/sjcit_logo4.jpg");

        // Create a JPanel with background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);

        // Add components onto the JPanel
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(63, 79, 70, 14);
        backgroundPanel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(63, 120, 70, 14);
        backgroundPanel.add(lblPassword);

        txtUsername = new JTextField();
        txtUsername.setBounds(143, 76, 191, 20);
        backgroundPanel.add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(143, 117, 191, 20);
        backgroundPanel.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform validation here
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                // Check if the provided credentials match the expected values
                if (username.equals("sjcit") && password.equals("12345")) {
                    // Open the CRUD application page
                    frame.dispose(); // Close the validation page
                    JavaCrud.main(new String[0]); // Initialize JavaCrud page
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
                }
            }
        });
        btnLogin.setBounds(161, 169, 89, 23);
        backgroundPanel.add(btnLogin);
    }
}
