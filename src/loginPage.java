import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginPage {
 private JFrame frame;
 private JLabel user, pass;
 private JPanel panel1, panel2, btn1, btn2;
 private JTextField username, password;
 private JButton login, signup;

    public loginPage() {
        frame = new JFrame();
        frame.setSize(350,400);
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
//--------------------------------------
        panel1 = new JPanel();
        panel1.setBounds(0,80,350,80);
        frame.add(panel1);

        user = new JLabel();
        user.setText("E-mail");
        username = new JTextField();
        username.setPreferredSize(new Dimension(350,40));
        panel1.add(user);
        panel1.add(username);
//-----
        panel2 = new JPanel();
        panel2.setBounds(0,160,350,80);
        frame.add(panel2);

        pass = new JLabel();
        pass.setText("Password");
        password = new JTextField();
        password.setPreferredSize(new Dimension(350,40));
        panel2.add(pass);
        panel2.add(password);
//----------------------------------------------
        btn1 = new JPanel();
        btn1.setBounds(60,250,100,50);
        frame.add(btn1);

        login = new JButton("Login");
        login.setFocusable(false);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==login){
                    try{
                        Connection connection = ConnectionProvider.getConnection();

                        String email = username.getText();
                        String pass = password.getText();

                        Statement stmnt = connection.createStatement();
                        String q = "select * from [table name] where Email ='"+email+"' and password ='"+pass+"';";

                        ResultSet rs = stmnt.executeQuery(q);
                        if (rs.next()){
                            frame.dispose();
                            homePage homePage = new homePage();

                        }
                        else {
                            JOptionPane.showMessageDialog(null,"E-mail or Password wrong","Login", JOptionPane.ERROR_MESSAGE);
                            username.setText("");
                            password.setText("");

                        }


                    }catch (Exception exception){
                        System.err.println("Error...");
                    }
                }
            }
        });

        btn1.add(login);
//------
        btn2 = new JPanel();
        btn2.setBounds(180,250,100,50);
        frame.add(btn2);

        signup = new JButton("Signup");
        signup.setFocusable(false);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signup){
                    frame.dispose();
                    SignupPage signupPage = new SignupPage();
                }
            }
        });

        btn2.add(signup);
//---------------------------------------------------------

        frame.setVisible(true);

    }

}
