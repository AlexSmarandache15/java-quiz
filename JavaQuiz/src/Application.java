import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.darkside.quiz.Quiz;

/**
 * 
 * @author Alex Smarandache
 *
 */

public class Application {

	public static void main(String[] args) {
		
		new Application().createQuiz().play();
		 
	}
	
	private Quiz createQuiz() {
		
		String[] questions = 	{
				"Which of the following is not a Java features?",
				"Which of the following is a marker interface?",
				"Which of the following is a reserved keyword ?",
				"What is the initial quantity of the ArrayList ?",
				" _ is used to find and fix bugs in the Java?",
				"What does the expr. float a = 35 / 0 return?",
			};
		
		String[][] options = 	{
				{"Dynamic","Architecture Neutral","Use of pointers","Object-oriented"},
				{"Runnable interface", "Remote interface", "Readable interface", "Result interface"},
				{"object", "strictfp", "main", "system"},
				{"5","10","0","100"},
				{"JVM", "JRE", "JDK", "JDB"},
				{"0", "Not a Number", "Infinity", "Run time exception"},
			};
		
		char[] answers = 		{
				'C',
				'B',
				'B',
				'B',
				'D',
				'C',
			};
		
		JFrame frame = new JFrame();
		JTextField textField = new JTextField();
		JTextArea textArea = new JTextArea();
		JButton[] buttons = new JButton[4];
		JLabel[] answerLabel = new JLabel[4];
		JLabel timeLabel = new JLabel();
		JLabel secondsLeft = new JLabel();
		JTextField numberRight = new JTextField();
		JTextField percentage = new JTextField();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(null);
		frame.setResizable(false);

		textField.setBounds(0, 0, 650, 50);
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);

		textArea.setBounds(0, 50, 650, 50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(25, 25, 25));
		textArea.setForeground(new Color(25, 255, 0));
		textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
		textArea.setBorder(BorderFactory.createBevelBorder(1));
		textArea.setEditable(false);

		int dim = 100;
		char e = 'A';
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setBounds(0, dim, 100, 100);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 35));
			buttons[i].setFocusable(false);
			buttons[i].setText(Character.toString(e++));
			dim += 100;
		}
		

		dim = 100;
		
		for (int i = 0; i < answerLabel.length; i++) {
			answerLabel[i] = new JLabel();
			answerLabel[i].setBounds(125, dim, 500, 100);
			answerLabel[i].setBackground(new Color(50, 50, 50));
			answerLabel[i].setForeground(Color.ORANGE);
			answerLabel[i].setFont(new Font("MV Boli", Font.PLAIN, 35));
			dim += 100;
		}
		
		
		secondsLeft.setBounds(535, 510, 100, 100);
		secondsLeft.setBackground(new Color(25, 25, 25));
		secondsLeft.setForeground(new Color(255, 0, 0));
		secondsLeft.setFont(new Font("Ink Free", Font.BOLD, 60));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(10));

		timeLabel.setBounds(535, 475, 100, 25);
		timeLabel.setBackground(new Color(50, 50, 50));
		timeLabel.setForeground(new Color(255, 0, 0));
		timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setText("timer >:D");

		numberRight.setBounds(225, 225, 200, 100);
		numberRight.setBackground(new Color(25, 25, 25));
		numberRight.setForeground(new Color(25, 255, 0));
		numberRight.setFont(new Font("Ink Free", Font.BOLD, 50));
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setEditable(false);

		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

		return (new Quiz(questions, options, answers, 10, frame, textField, textArea, buttons, answerLabel, timeLabel, secondsLeft, numberRight, 
				percentage));
	}

}
