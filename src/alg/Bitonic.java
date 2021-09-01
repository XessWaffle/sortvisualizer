package alg;

import utils.Algorithm;

public class Bitonic extends Algorithm {

	
	public Bitonic() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
		bitonicSort(0, sort.length, true);
		comparisons = 0;
	}

    private void bitonicSort(int lo, int n, boolean isAscending) {
        if (n > 1) {
            int m = n / 2;
            bitonicSort(lo, m, !isAscending);
            bitonicSort(lo + m, n - m, isAscending);
            bitonicMerge(lo, n, isAscending);
        }
    }

    private void bitonicMerge(int lo, int n, boolean dir) {
        if (n > 1) {
            int m = greatestPowerOfTwoLessThan(n);
            for (int i = lo; i < lo + n - m; i++) {
                compare(i, i + m, dir);
            }
            bitonicMerge(lo, m, dir);
            bitonicMerge(lo + m, n - m, dir);
        }
    }

    private void compare(int i, int j, boolean isSortingDirection) {
    	comparisons++;
        if (isSortingDirection == (sort[i] > sort[j])) {
            swap(i, j);
            this.repaint();
            
        	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
        }
    
    }
    
    private int greatestPowerOfTwoLessThan(int n) {
        int k = 1;
        while (k < n)
            k = k << 1;
        return k >> 1;
    }

}
