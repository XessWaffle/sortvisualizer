package alg;
import java.util.Arrays;

import utils.Sortable;
import utils.Algorithm;

public class Quicksort extends Algorithm {

	public Quicksort() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.toString(sort));
		quickSort(0, sort.length - 1);
		//System.out.println(Arrays.toString(sort));
		comparisons = 0;
	}
	
	private void quickSort(int low, int high){
		
		//System.out.println(Arrays.toString(sort));
		
		if(high - low <= 0){
			return;
		} else {
			int pivot = sort[high];
			int partition = partition(low, high, pivot);
			quickSort(low, partition - 1);
			quickSort(partition + 1, high);
			
			//System.out.println(Arrays.toString(sort));
		}
		
		//System.out.println(Arrays.toString(sort));

		
	}
	
	private int partition(int left, int right, int pivot){
		
		int nLeft = left;
		int nRight = right - 1;
		
		while(true){
			
			while(sort[nLeft] < pivot){
				nLeft++;
				comparisons++;
			}
			while(nRight >= 0 && sort[nRight] > pivot){
				nRight--;
				comparisons++;
			}
			
			if(nLeft >= nRight){ 
				break;
			} else {
				swap(nLeft,nRight);
				
				this.repaint();
	            
	        	try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*  try{
	        	Thread.sleep(10);
	        }catch(Exception e){
	        }*/
				nLeft++;
				nRight--;
			}
			
		}
		
		//if(sort[nLeft] > sort[right])
			swap(nLeft, right);
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return nLeft;
	}

}
