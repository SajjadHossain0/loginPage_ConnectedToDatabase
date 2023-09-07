import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignupPage {
    private JFrame frame;
    private JLabel name, id, reg_num, email,pass;
    private JPanel panel1, panel2, panel3, panel4, panel5, btn1, btn2;
    private JTextField name1, id1, reg_num1, email1, pass1;
    private JButton login, signup;

    public SignupPage() {
        frame = new JFrame();
        frame.setSize(350,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
//-----------------------------------------------------------------------------
        panel1 = new JPanel();
        panel1.setBounds(0,20,350,65);
        frame.add(panel1);
        name = new JLabel("Name");
        panel1.add(name);
        name1 = new JTextField();
        name1.setPreferredSize(new Dimension(350,40));
        panel1.add(name1);

        panel2 = new JPanel();
        panel2.setBounds(0,90,350,65);
        frame.add(panel2);
        id = new JLabel("ID");
        panel2.add(id);
        id1 = new JTextField();
        id1.setPreferredSize(new Dimension(350,40));
        panel2.add(id1);

        panel3 = new JPanel();
        panel3.setBounds(0,160,350,65);
        frame.add(panel3);
        reg_num = new JLabel("Registration Number");
        panel3.add(reg_num);
        reg_num1 = new JTextField();
        reg_num1.setPreferredSize(new Dimension(350,40));
        panel3.add(reg_num1);

        panel4 = new JPanel();
        panel4.setBounds(0,230,350,65);
        frame.add(panel4);
        email = new JLabel("E-mail");
        panel4.add(email);
        email1 = new JTextField();
        email1.setPreferredSize(new Dimension(350,40));
        panel4.add(email1);

        panel5 = new JPanel();
        panel5.setBounds(0,300,350,65);
        frame.add(panel5);
        pass = new JLabel("Password");
        panel5.add(pass);
        pass1 = new JTextField();
        pass1.setPreferredSize(new Dimension(350,40));
        panel5.add(pass1);
//---------------------------------------------------------------------------------
        btn1 = new JPanel();
        btn1.setBounds(60,380,100,50);
        frame.add(btn1);

        login = new JButton("Login");
        login.setFocusable(false);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login){
                    frame.dispose();
                    loginPage loginPage = new loginPage();
                }
            }
        });
        btn1.add(login);
//-----------------------------------------------------------------------------------------
        btn2 = new JPanel();
        btn2.setBounds(180,380,100,50);
        frame.add(btn2);
        
        signup = new JButton("Signup");
        signup.setFocusable(false);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signup){
                    try {
                        Connection connection = ConnectionProvider.getConnection();

                        String name = name1.getText();
                        String id = id1.getText();
                        String reg_num = reg_num1.getText();
                        String email = email1.getText();
                        String pass = pass1.getText();

                        String q = "insert into [table name](Name,Id,Registration_Number,Email,password) values(?,?,?,?,?);";

                        PreparedStatement pstmnt = connection.prepareStatement(q);
                        pstmnt.setString(1,name);
                        pstmnt.setInt(2, Integer.parseInt(id));
                        pstmnt.setString(3,reg_num);
                        pstmnt.setString(4,email);
                        pstmnt.setString(5,pass);
                        pstmnt.executeUpdate();
                        connection.close();

                        signup.setEnabled(false);
                        JOptionPane.showMessageDialog(null,"Signup complete, now login to your account","Signup", JOptionPane.INFORMATION_MESSAGE);
                        name1.setText("");
                        id1.setText("");
                        reg_num1.setText("");
                        email1.setText("");
                        pass1.setText("");
                        frame.dispose();
                        loginPage loginPage = new loginPage();


                    }catch (Exception exception){
                        System.err.println("Error...");
                    }
                }
            }
        });
        btn2.add(signup);
//-----------------------------------------------------------------
        
        frame.setVisible(true);
    }
}
