package alg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import utils.Algorithm;

public class QuickShell extends Algorithm{

	public QuickShell() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		quickDivide(0, sort.length - 1);
		shell(0, sort.length - 1);
		comparisons = 0;
	}

	private void quickDivide(int left, int right) {
		// TODO Auto-generated method stub
		if(right - left > 1){
			
			int avg = findAvg(left, right);
		
			int mid = partition(left, right, avg);
			
			quickDivide(left, mid);
			quickDivide(mid + 1, right);
			
		} else {
			swap(left,right);
			//return;
		}
	}

	private int partition(int left, int right, int avg) {
		// TODO Auto-generated method stub
		
		
		int leftPntr = left, rightPntr = right;
		
		int mid = (left + right)/2;
		
		
		while(leftPntr <= mid && rightPntr > mid){
			while(sort[leftPntr] < avg){
				comparisons++;
				leftPntr++;
				if(leftPntr > mid){
					break;
				}
			}
			
			while(sort[rightPntr] > avg){
				comparisons++;
				rightPntr--;
				if(rightPntr <= mid){
					break;
				}
			}
			
			
			if(leftPntr <= mid && rightPntr > mid){
				swap(leftPntr++, rightPntr--);
				
				this.repaint();
	            
	        	try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				break;
			}
		}
		
		while(leftPntr <= mid){
			swap(leftPntr++, rightPntr--);
			
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//(sort, comparisons);
		}
		
		while(rightPntr > mid){
			swap(leftPntr++, rightPntr--);
			
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//(sort, comparisons);
		}
		return leftPntr;
	}

	private int findAvg(int left, int right) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = left; i < right; i++){
			sum += sort[i];
		}
		
		return sum/(right - left);
	}

	private void shell(int left, int right) {
		// TODO Auto-generated method stub
		int gap = right - left;
		
		
		for(int i = gap; i > 0; i/=2){
			for(int j = left; j < (right - i); j++){
				for(int k = left; k < (right - i); k++){
					if(sort[k] > sort[k + i]){
						comparisons++;
						swap(k, k + i);
						
						this.repaint();
			            
			        	try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
		}
	}
	
}
