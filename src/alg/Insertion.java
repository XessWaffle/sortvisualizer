package alg;

import exception.OutOfRangeException;
import utils.Algorithm;
import utils.Sortable;

public class Insertion extends Algorithm {

	public Insertion() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
		
		int i, j, newValue;
	    
		for (i = 1; i < sort.length; i++) {
	          newValue = sort[i];
	          j = i;
	          while (j > 0 && sort[j - 1] > newValue) {
	        	 comparisons++;
	        	 sort[j] = sort[j - 1];
	        	 
	        	 this.repaint();
	             
	         	try {
	 				Thread.sleep(1);
	 			} catch (InterruptedException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	        	 
                 j--;
                 
	          }
	          sort[j] = newValue;
	          
	          this.repaint();
	            
	        	try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        //  System.out.println(Arrays.toString(sort));
	          
	    }
		comparisons = 0;
	}

}
