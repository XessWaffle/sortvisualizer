package alg;
import java.util.Arrays;

import utils.Sortable;
import utils.Algorithm;

public class CocktailShaker extends Algorithm {

	public CocktailShaker() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.toString(sort));
		int lowInd = 0, highInd = sort.length- 1, maxInt = Integer.MIN_VALUE, minInt = Integer.MAX_VALUE, 
				maxInd = 0, minInd = 0;
		
		while(true){
			
			if(highInd - lowInd <= 0){ 
				break; 
			}
			
			for(int i = lowInd; i <= highInd; i++){
				if(sort[i] < minInt){
					comparisons++;
					minInt = sort[i];
					minInd = i;
				} else if(sort[i] > maxInt){
					comparisons++;
					maxInt = sort[i];
					maxInd = i;
				}
				
				
			}
			//System.out.println("B: " + Arrays.toString(sort));
			
			//System.out.println("MinInd: " + minInd + "\nMaxInd: " + maxInd);
			//System.out.println("HighInd: " + highInd + "\nLowInd: " + lowInd);
			
			//System.out.println("B: " + Arrays.toString(sort));
			swap(lowInd++, minInd);
			//System.out.println("D: " + Arrays.toString(sort));
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			swap(highInd--, maxInd);
			//System.out.println("A: " + Arrays.toString(sort));
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			maxInt = Integer.MIN_VALUE; 
			minInt = Integer.MAX_VALUE;
			
		}
		
		if(sort[++highInd] < sort[--lowInd]){
			comparisons++;
			swap(lowInd,highInd);
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(Arrays.toString(sort));
		comparisons = 0;
	}

}
