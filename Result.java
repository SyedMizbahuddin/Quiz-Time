import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Result extends JFrame implements ActionListener {
	private JLabel result;
	private JLabel commentLabel;
	private String comment;
	JButton exit, again;
	Result(int score) {
		this.setBounds(400, 200, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = this.getContentPane();
		pane.setBackground(new Color(42, 68, 92));
		this.setLayout(null);
		Font f = new Font("arial", Font.BOLD, 15);
		Font f1 = new Font("arial", Font.ITALIC, 70);
		String s = Integer.toString(score) + "/10";
		result = new JLabel(s);

		if (score <= 5) {
			comment = "Work more on your weak concepts";
		} else if (score <= 8) {
			comment = "Congratulations, keep going";
		} else {
			comment = "You did it Champ, Excellent";
		}

		commentLabel = new JLabel(comment);

		commentLabel.setFont(f);
		result.setFont(f1);
		commentLabel.setForeground(new Color(240, 250, 252));
		result.setForeground(new Color(240, 250, 252));

		result.setBounds(150, 75, 400, 100);
		commentLabel.setBounds(100, 200, 400, 30);

		this.add(result);
		this.add(commentLabel);

		again = new JButton("Again");
		again.setBounds(350, 250, 75, 30);
		this.add(again);
		again.setBackground(new Color(222, 144, 0));
		again.addActionListener(this);

		exit = new JButton("Exit");
		exit.setBounds(75, 250, 75, 30);
		this.add(exit);
		exit.setBackground(new Color(222, 144, 0));
		exit.addActionListener(this);
		this.setVisible(true);

		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == again) {
			this.setVisible(false);
			new Quiz();
		} else if (ae.getSource() == exit) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
	}
}