import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
	private Container pane;
	private JLabel name, email;
	private JTextField nameField, emailField;
	private JButton start , exit;
	Home() {
		this.setBounds(400, 200, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = this.getContentPane();
		pane.setBackground(new Color(42, 68, 92));
		this.setLayout(null);

		name = new JLabel("Enter Your Name");
		name.setForeground(Color.WHITE);
		Font f = new Font("arial", Font.BOLD, 15);
		name.setFont(f);
		name.setBounds(75, 100, 200, 15);
		this.add(name);

		nameField = new JTextField();
		nameField.setBackground(Color.WHITE);
		nameField.setBounds(225, 100, 200, 20);
		this.add(nameField);

		email = new JLabel("Enter Your email");
		email.setForeground(Color.WHITE);
		// Font f = new Font("arial", Font.BOLD, 15);
		email.setFont(f);
		email.setBounds(75, 150, 200, 15);
		this.add(email);

		emailField = new JTextField();
		emailField.setBackground(Color.WHITE);
		emailField.setBounds(225, 150, 200, 20);
		this.add(emailField);


		start = new JButton("Start");
		start.setBounds(350, 200, 75, 30);
		this.add(start);
		start.setBackground(new Color(222, 144, 0));
		start.addActionListener(this);

		exit = new JButton("Exit");
		exit.setBounds(75, 200, 75, 30);
		this.add(exit);
		exit.setBackground(new Color(222, 144, 0));
		exit.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == start) {
			this.setVisible(false);
			new Quiz();
		} else if (ae.getSource() == exit) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Home();
	}
}