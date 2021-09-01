package alg;

import exception.OutOfRangeException;
import utils.Algorithm;
import utils.Sortable;

public class Counting extends Algorithm{

	public Counting() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int N = sort.length;
		 
        int max = sort[0], min = sort[0];
        for (int i = 1; i < N; i++)
        {
            if (sort[i] > max){
                max = sort[i];
            }
            if (sort[i] < min){
                min = sort[i];
            }
        }
        
        int range = max - min + 1;
 
        int[] count = new int[range];
        /** make count/frequency array for each element **/
        
        for (int i = 0; i < N; i++){
            count[sort[i] - min]++;
            //(count);
        }
        /** modify count so that positions in final array is obtained **/
        
        for (int i = 1; i < range; i++){
            count[i] += count[i - 1];
            //(count);
        }
        /** modify original array **/
        
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i]){
                sort[j++] = i + min;
                
                this.repaint();
                
            	try {
    				Thread.sleep(20);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
        
        comparisons = 0;
	}
	

}
