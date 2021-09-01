package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashSet;

import javax.swing.JFrame;

import alg.Bitonic;
import alg.Quicksort;
import alg.Selection;
import utils.Algorithm;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Main {

	private JFrame frame;
	private HashSet<Algorithm> algs;
	
	private final String[] algorithms = {"Bitonic", "Bubble", "CocktailShaker", "Counting", "Cycle", "Gravity", "Heap", "Insertion", "Merge", "QuickShell",
			"Quicksort", "Radix", "Selection", "Shell", "PigeonHole"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		algs = new HashSet<>();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, Algorithm.PANEL_WIDTH + 14, Algorithm.PANEL_HEIGHT + 37 + 110);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		for(String item: algorithms) {
			comboBox.addItem(item);
		}
		
		comboBox.setBounds(10, 10, 366, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String select = (String) comboBox.getSelectedItem();
				
				Object algInstance = null;
				
				System.out.println("Select: " + select);
				
				try {
					Class myClass = Class.forName("alg." + select);
					algInstance = myClass.newInstance();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				Algorithm a = (Algorithm) algInstance;
				
				algs.add(a);
				a.setBounds(0, 110, Algorithm.PANEL_WIDTH, Algorithm.PANEL_HEIGHT);
				
				frame.add(a);
				
				AlgorithmThread algt = new AlgorithmThread((Algorithm) algInstance);
				
				algt.start();
			
			}
		});
		btnStart.setBounds(40, 41, 85, 21);
		frame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Algorithm a: algs) {
					frame.remove(a);
				}
			}
		});
		btnStop.setBounds(260, 41, 85, 21);
		frame.getContentPane().add(btnStop);
		frame.setBackground(Color.BLACK);
		
		
	}
	
	class AlgorithmThread extends Thread{
		
		private Algorithm alg;
		
		
		public AlgorithmThread(Algorithm alg) {
			this.alg = alg;
			
		}
		
		public void run() {
			alg.sort();
			
			frame.remove(alg);
			
		}
		
	}
	
}
