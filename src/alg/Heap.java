package alg;
import utils.Algorithm;
import utils.Sortable;

public class Heap extends Algorithm{

	private static int N;
	
	public Heap() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		heapify();        
        for (int i = N; i > 0; i--)
        {
            swap(0, i);
            N = N-1;
            maxheap(0);
            
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
    /* Function to build a heap */   
    public void heapify()
    {
        N = sort.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(i);        
    }
    /* Function to swap largest element in heap */        
    public void maxheap(int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && sort[left] > sort[i]){
            comparisons++;
        	max = left;
        }
        if (right <= N && sort[right] > sort[max]){        
            comparisons++;
        	max = right;
        }
 
        if (max != i)
        {
            swap(i, max);
            maxheap(max);
            
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
