package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import exception.OutOfRangeException;

public abstract class Algorithm extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6925534050024878919L;
	
	public static final int PANEL_WIDTH = 1000;
	public static final int PANEL_HEIGHT = 500;
	public static final int NUM_ELEMENTS = 500;
	
	protected Sortable[] sort_d;
	protected volatile int[] sort;
	protected int comparisons;
	
	public Algorithm() throws Exception {
		sort = Generator.generate(NUM_ELEMENTS);
		sort_d = Generator.generateFrom(sort);
		
		comparisons = 0;
		
		this.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		
		for(Sortable s: sort_d) {
			this.add(s);
		}
		
	}
	
	public abstract void sort();
	
	public Sortable[] get_sort() {
		return sort_d;
	}
	
	public void swap(int i, int j) {
		int temp = sort[i];
		sort[i] = sort[j];
		sort[j] = temp;
	}
	
	public boolean isSorted() {
		for(int i = 0; i < sort.length - 1; i++){
			if(sort[i] > sort[i + 1]){
				return false;
			}
		}
		return true;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setBackground(Color.BLACK);
		
		for(int i = 0; i < sort.length; i++) {
			try {
				sort_d[i].setValue(sort[i]);
				sort_d[i].repaint();
			} catch (OutOfRangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class SortThread extends Thread {
		public void run() {
			sort();
		}
	}
	
	
	static class Generator {
		public static int[] generate(int size) throws Exception {
			int[] ret = new int[size];
			
			for(int i = 0; i < size; i++) {
				ret[i] = (int) ((Math.random() * (double)(Sortable.MAX_VALUE - Sortable.MIN_VALUE)) + Sortable.MIN_VALUE);
			}
			
			return ret;
			
		}
		
		public static Sortable[] generateFrom(int[] sort) throws Exception {
			Sortable[] ret = new Sortable[sort.length];
			
			int width = (int)((double)PANEL_WIDTH/sort.length);
			int height = PANEL_HEIGHT;
			
			int x = 0, y = 0;
			
			for(int i = 0; i < sort.length; i++) {
				ret[i] = new Sortable(sort[i]);
				ret[i].setBounds((x += width), y, width, height);
				
				System.out.println(ret[i]);
				
			}
			
			return ret;
		}
	}
}
