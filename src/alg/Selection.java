package alg;
import java.util.Arrays;

import utils.Algorithm;
import utils.Sortable;

public class Selection extends Algorithm{

	public Selection() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < sort.length - 1; i++){
			int index = i;  
	        for (int j = i + 1; j < sort.length; j++){
	        	if (sort[j] < sort[index]){  
	        		comparisons++;
	        		index = j;//searching for lowest index  
	            }  
	        }  
	        swap(i,index);
	        
	        this.repaint();
	        
	        try{
	        	Thread.sleep(20);
	        }catch(Exception e){
	        	
	        }
		}
		comparisons = 0;
	}

}
