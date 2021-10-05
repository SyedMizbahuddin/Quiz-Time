import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener {
	private JTextArea question;
	private JRadioButton a, b, c, d;
	private ButtonGroup bg;
	private JButton next, submit;
	private int[] ar;
	private int score;
	private int i;
	private PreparedStatement st;
	private String questionData ;
	private String []option;
	private int correct;
	private Random rand;
	Quiz()  {
		i = 0;
		score = 0;
		option = new String[4];
		rand = new Random();
		this.setBounds(350, 150, 600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		Container pane = this.getContentPane();
		Color back = new Color(145, 217, 216);
		Color front = new Color(29, 29, 46);
		pane.setBackground(back);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			st = con.prepareCall("select * from quiz where id = ?");
		} catch (Exception e) {}
		ar = new int[20];
		for (int l = 0; l < 20; l++) {
			ar[l] = l + 1;
		}
		question = new JTextArea("question");
		a = new JRadioButton("a");
		b = new JRadioButton("b");
		c = new JRadioButton("c");
		d = new JRadioButton("d");
		bg = new ButtonGroup();
		next = new JButton("Next");
		submit = new JButton("Submit");
		Font f = new Font("arial", Font.BOLD, 15);

		a.setFont(f);
		b.setFont(f);
		question.setFont(f);
		c.setFont(f);
		d.setFont(f);
		next.setFont(f);
		submit.setFont(f);

		a.setBackground(back);
		b.setBackground(back);
		c.setBackground(back);
		d.setBackground(back);
		question.setBackground(back);
		next.setBackground(front);
		submit.setBackground(front);

		a.setForeground(front);
		b.setForeground(front);
		c.setForeground(front);
		d.setForeground(front);
		question.setForeground(front);
		next.setForeground(new Color(195, 224, 205));
		submit.setForeground(new Color(195, 224, 205));


		question.setEditable(false);
		question.setLineWrap(true);
		this.add(question);
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		this.add(next);

		next.addActionListener(this);
		// submit.addActionListener(this);


		question.setBounds(75, 30, 475, 75);
		a.setBounds(75, 150, 400, 25);//left top width height
		b.setBounds(75, 200, 400, 25);
		c.setBounds(75, 250, 400, 25);
		d.setBounds(75, 300, 400, 25);
		next.setBounds(425, 350, 100, 30);

		select();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == next) {
			switch (correct) {
			case 0: if (a.isSelected() == true) {score++;} break;
			case 1: if (b.isSelected() == true) {score++;} break;
			case 2: if (c.isSelected() == true) {score++;} break;
			case 3: if (d.isSelected() == true) {score++;} break;
			}
			bg.clearSelection();
			if (i == 10) {
				this.setVisible(false);
				new Result(score);
			} else {

				if (i == 9) {
					next.setText("Submit");
				}
				select();
			}
		}
	}
	public void select() {
		int k = rand.nextInt(20 - i);
		int temp = ar[20 - i - 1];
		ar[20 - i - 1] = ar[k];
		ar[k] = temp;
		k = ar[20 - i - 1];
		i++;
		try {
			st.setInt(1, k);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				questionData = rs.getString(2);
				option[0] = rs.getString(3);
				option[1] = rs.getString(4);
				option[2] = rs.getString(5);
				option[3] = rs.getString(6);
			}
		} catch (Exception e) {}
		correct = rand.nextInt(4);
		String temp1 = option[correct];
		option[correct] = option[0];
		option[0] = temp1;

		display();
	}

	public void display() {
		question.setText(questionData);
		a.setText(option[0]);
		b.setText(option[1]);
		c.setText(option[2]);
		d.setText(option[3]);
	}

	public static void main(String[] args) {
	}
}