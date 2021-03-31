package com.darkside.quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

	private String[] questions;
	private String[][] options;
	private char[] answers;

	private char answer;
	private int index;
	private int correctAnswers = 0;
	private int totalQuestions;
	private int result;
	private int seconds = 10;

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JButton[] buttons;
	private JLabel[] answerLabel;
	private JLabel timeLabel;
	private JLabel secondsLeft;
	private JTextField numberRight;
	private JTextField percentage;

	private Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondsLeft.setText(String.valueOf(seconds));
			if (seconds <= 0) {
				displayAnswer();
			}
		}
	});

	public Quiz(String[] questions, String[][] options, char[] answers, int seconds, JFrame frame, JTextField textField,
			JTextArea textArea, JButton[] buttons, JLabel[] answerLabel, JLabel timeLabel, JLabel secondsLeft,
			JTextField numberRight, JTextField percentage) {
		super();
		this.questions = questions;
		this.options = options;
		this.answers = answers;
		this.seconds = seconds;
		this.frame = frame;
		this.textField = textField;
		this.textArea = textArea;
		this.buttons = buttons;
		for (int i = 0; i < buttons.length; i++) {
			this.buttons[i] = buttons[i];
		}

		this.answerLabel = answerLabel;
		for (int i = 0; i < answerLabel.length; i++) {
			this.answerLabel[i] = answerLabel[i];
		}

		this.timeLabel = timeLabel;
		this.secondsLeft = secondsLeft;
		this.numberRight = numberRight;
		this.percentage = percentage;

		this.frame.add(this.timeLabel);
		this.frame.add(this.secondsLeft);

		for (JLabel iterator : this.answerLabel) {
			this.frame.add(iterator);
		}

		for (JButton iterator : this.buttons) {
			iterator.addActionListener(this);
			this.frame.add(iterator);
		}

		this.frame.add(this.textArea);
		this.frame.add(this.textField);

		totalQuestions = this.questions.length;
	}

	public void play() {
		this.frame.setVisible(true);
		nextQuestion();
	}

	private void nextQuestion() {

		if (index >= totalQuestions) {
			displayResult();
		} else {
			textField.setText("Question " + (index + 1));
			textArea.setText(questions[index]);

			for (int i = 0; i < options[0].length; i++) {
				answerLabel[i].setText(options[index][i]);
			}

			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		buttonsSetEnabled(false);

		answer = 'A';
		for (JButton iterator : buttons) {
			if (e.getSource() == iterator) {
				if (answer == answers[index]) {
					correctAnswers++;
				}
			}
			answer++;
		}

		displayAnswer();
	}

	public void displayAnswer() {

		timer.stop();

		buttonsSetEnabled(false);

		char e = 'A';

		for (int i = 0; i < answerLabel.length; i++) {
			if (answers[index] != e++) {
				answerLabel[i].setForeground(Color.RED);
			} else {
				answerLabel[i].setForeground(Color.GREEN);
			}
		}

		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < options[0].length; i++) {
					answerLabel[i].setForeground(Color.ORANGE);
				}

				answer = ' ';
				seconds = 10;
				secondsLeft.setText(String.valueOf(seconds));
				buttonsSetEnabled(true);
				index++;
				nextQuestion();

			}
		});

		pause.setRepeats(false);
		pause.start();
	}

	private void buttonsSetEnabled(boolean value) {
		for (JButton iterator : buttons) {
			iterator.setEnabled(value);
		}
	}

	private void buttonsSetText(String text) {
		for (JLabel iterator : answerLabel) {
			iterator.setText(text);
		}
	}

	public void displayResult() {

		buttonsSetEnabled(false);

		result = (int) ((correctAnswers / (double) totalQuestions) * 100);

		textField.setText("RESULT!");
		textArea.setText("");
		buttonsSetText("");

		numberRight.setText("(" + correctAnswers + "/" + totalQuestions + ")");
		percentage.setText(result + "%");

		frame.add(numberRight);
		frame.add(percentage);

	}
}