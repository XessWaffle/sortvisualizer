package alg;

import utils.Sortable;
import utils.Algorithm;

public class Shell extends Algorithm {

	public Shell() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int gap = sort.length;
		
		
		for(int i = gap; i > 0; i/=2){
			for(int j = 0; j < (sort.length - i); j++){
				for(int k = 0; k < (sort.length - i); k++){
					if(sort[k] > sort[k + i]){
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
		comparisons = 0;
	}

}
