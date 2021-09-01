package alg;
import java.util.Arrays;

import utils.Sortable;
import utils.Algorithm;

public class Bubble extends Algorithm{

	public Bubble() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
		
		for(int i = 0; i < sort.length - 1; i++){
			for(int j = 0; j < sort.length - 1; j++){
				
				if(sort[j] > sort[j + 1]){
					swap(j, j + 1);
					
					this.repaint();
		            
		        	try {
						Thread.sleep(1, 0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
					
				}
				
				if(isSorted()){ break; }
				
				
			}
			//System.out.println(Arrays.toString(sort));
		}
		
		comparisons = 0;
	}

}
