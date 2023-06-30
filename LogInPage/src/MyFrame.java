import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.math.BigInteger;

public class MyFrame extends JFrame implements ActionListener, MouseListener {

    //-File-//
    private File usersFile = new File("users.txt");

    //-Components-//
    private JLabel titleLabel = new JLabel("LOGIN Page By Steven");
    private JLabel nameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JTextField nameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton confirmButton = new JButton("Login");

    public MyFrame(){
        this.setSize(1300,900);
        this.setTitle("LOGIN Page By Steven");
        this.getContentPane().setBackground(Style.myYellow);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        titleLabel.setBounds(165, 90,971,105);
        titleLabel.setFont(new Font("Open Sans Light", Font.BOLD,60));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        nameLabel.setBounds(380, 320,270,96);
        nameLabel.setFont(Style.buttonsFont);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        nameField.setBounds(650, 347,270,42);
        nameField.setFont(Style.buttonsFont);

        passwordLabel.setBounds(380, 417,270,96);
        passwordLabel.setFont(Style.buttonsFont);
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);

        passwordField.setBounds(650, 444,270,42);
        passwordField.setFont(Style.buttonsFont);

        confirmButton.setBounds(515, 651, 270, 96);
        confirmButton.setOpaque(true);
        confirmButton.setFocusable(false);
        confirmButton.setBorder(null);
        confirmButton.setFont(Style.buttonsFont);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setBackground(Color.green);
        confirmButton.addActionListener(this);
        confirmButton.addMouseListener(this);


        this.add(titleLabel);
        this.add(nameLabel);
        this.add(passwordLabel);
        this.add(nameField);
        this.add(passwordField);
        this.add(confirmButton);


    }

    public boolean logIn(String name, String password){
        boolean flag = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String data;

            while ((data = reader.readLine()) != null){
                String[] datas = data.split(",");

                String user = datas[0];
                String pass = datas[1];

                if(name.equals(user) && pass.equals(password)){
                    flag = true;
                    break;
                }

            }

            reader.close();


        } catch (IOException e) {throw new RuntimeException(e);}

        return flag;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton && !nameField.getText().trim().equals("") && !passwordField.getText().trim().equals("")){
            boolean result = logIn(nameField.getText(), passwordField.getText());

            if(result){
                JOptionPane.showMessageDialog(this, "Login Confirmed","Success",JOptionPane.PLAIN_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Login Failed","Error",JOptionPane.PLAIN_MESSAGE);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==confirmButton) confirmButton.setBackground(Style.myGreen);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==confirmButton) confirmButton.setBackground(Color.green);
    }
}
