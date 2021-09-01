package alg;


import utils.Algorithm;
import utils.Sortable;

public class Merge extends Algorithm {

	public Merge() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.toString(sort));
		mergeSort(0, sort.length - 1);	
		//System.out.println(Arrays.toString(sort));
		comparisons = 0;
	}
	
	private void mergeSort(int lowIndex, int highIndex){
		
		if(highIndex - lowIndex >= 1){
			
			int middleIndex = (lowIndex + highIndex) / 2;
			
			
			
			mergeSort(lowIndex, middleIndex);
			mergeSort(middleIndex + 1, highIndex);
			
			merge(lowIndex, middleIndex, highIndex);
			
			//sorter.update(sort);
		} else {
			return;
		}
	}
	
	private void merge(int low, int mid, int high){
		
		//1System.out.println("B:" + Arrays.toString(sort));
		int[] temp = new int[sort.length];
		
		int left = low;
		int right = mid + 1;
		int tempTrack = low;
		
		while(left <= mid && right <= high){
			
			if(sort[left] < sort[right]){
				comparisons++;
				temp[tempTrack] = sort[left++];
			} else {
				temp[tempTrack] = sort[right++];
			}
			
			tempTrack++;
			
			
			
		}
			
		while(left <= mid){
			temp[tempTrack++] = sort[left++];
		}
		
		while(right <= high){
			temp[tempTrack++] = sort[right++];
		}
		
		
		for(int i = low; i <= high; i++){
			sort[i] = temp[i];
			
			/*  try{
		        	Thread.sleep(10);
		        }catch(Exception e){
		        }*/
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//System.out.println("A:" + Arrays.toString(sort));
	}

}
