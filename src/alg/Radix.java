package alg;
import java.util.LinkedList;
import java.util.Queue;

import exception.OutOfRangeException;
import utils.Sortable;
import utils.Algorithm;

public class Radix extends Algorithm {

	public Radix() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		boolean flag = true;
		int divisor = 1;
		Queue [ ] buckets = new Queue[10];
		for (int i = 0; i < 10; i++)
			buckets[i] = new LinkedList();

		while (flag) {
			flag = false;
				// first copy the values into buckets
			for (int i = 0; i < sort.length; i++) {
				int hashIndex = (sort[i] / divisor) % 10;
				if (hashIndex > 0) flag = true;
				((LinkedList<Integer>) buckets[hashIndex]).addLast(new Integer(sort[i]));
			}
				// then copy the values back into vector
			divisor *= 10;
			int i = 0;
			for (int j = 0; j < 10; j++) {
				while (! buckets[j].isEmpty()) {
					Integer ival = (Integer) ((LinkedList) buckets[j]).getFirst();
					((LinkedList) buckets[j]).removeFirst();
					sort[i++] = (ival.intValue());
					
					this.repaint();
		            
		        	try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			if(isSorted()){break;}
		}
		comparisons = 0;
	}
}
