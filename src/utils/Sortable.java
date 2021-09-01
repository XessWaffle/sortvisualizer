package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import exception.OutOfRangeException;

public class Sortable extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5265421653476918998L;
	
	public static final int MAX_VALUE = 5000;
	public static final int MIN_VALUE = 0;
	
	public static final Color MAX_COLOR_VALUE = Color.BLUE;
	public static final Color MIN_COLOR_VALUE = Color.RED;
	
	private int value;
	
	public Sortable(int value) throws Exception {
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) throws OutOfRangeException {
		
		if(value > MAX_VALUE || value < MIN_VALUE) {
			throw new OutOfRangeException();
		}
		
		this.value = value;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		float[] diff = {MAX_COLOR_VALUE.getRed() - MIN_COLOR_VALUE.getRed(), MAX_COLOR_VALUE.getGreen() - MIN_COLOR_VALUE.getGreen(), MAX_COLOR_VALUE.getBlue() - MIN_COLOR_VALUE.getBlue() };
		
		diff[0] /= 255.0;
		diff[1] /= 255.0;
		diff[2] /= 255.0;
		
		float[] hues = new float[3];
		
		double percent = (double)(value - MIN_VALUE)/(MAX_VALUE - MIN_VALUE);
		
		diff[0] *= percent;
		diff[1] *= percent;
		diff[2] *= percent;
		
		hues[0] = (float) (MIN_COLOR_VALUE.getRed()/255.0 + diff[0]);
		hues[1] = (float) (MIN_COLOR_VALUE.getGreen()/255.0 + diff[1]);
		hues[2] = (float) (MIN_COLOR_VALUE.getBlue()/255.0 + diff[2]);
		
		//hues[0] = (float) Math.random();
		//hues[1] = (float) Math.random();
		//hues[2] = (float) Math.random();
		
		g2d.setBackground(Color.BLACK);
		
		g2d.setColor(new Color(hues[0], hues[1], hues[2]));
		
		g2d.fillRect(0, this.getY() + (int) (this.getHeight() * (1.0-percent)), this.getWidth(), (int) (this.getHeight() * (percent)));
		
	}
	
	public String toString() {
		double percent = (double)(value - MIN_VALUE)/(MAX_VALUE - MIN_VALUE);
		return "[ Value: " + value + ", Rect: (" +  this.getX() + ", " + (this.getY() + (int) (this.getHeight() * (1.0 - percent))) + ", " + this.getWidth() + ", " + (int) (this.getHeight() * (percent)) + ")]"; 
	}
	
	
}
