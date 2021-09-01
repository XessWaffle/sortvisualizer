package alg;

import exception.OutOfRangeException;
import utils.Algorithm;
import utils.Sortable;

public class Gravity extends Algorithm{

	public Gravity() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int max=0;
		for(int i=0;i<sort.length;i++)
			if(sort[i]>max)
				max=sort[i];
 
		//Set up abacus
		char[][] grid=new char[sort.length][max];
		int[] levelcount=new int[max];
		for(int i=0;i<max;i++)
		{
			levelcount[i]=0;
			for(int j=0;j<sort.length;j++)
				grid[j][i]='_';
		}
		/*
		display1D(arr);
		display1D(levelcount);
		display2D(grid);
		*/
 
		//Drop the beads
		for(int i=0;i<sort.length;i++)
		{
			int num=sort[i];
			for(int j=0;num>0;j++)
			{
				grid[levelcount[j]++][j]='*';
				num--;
			}
		}
		//display2D(grid);
		//Count the beads
		for(int i=0;i<sort.length;i++)
		{
			int putt=0;
			for(int j=0;j<max&&grid[sort.length-1-i][j]=='*';j++)
				putt++;
			sort[i] = (putt);
			
			this.repaint();
            
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		comparisons =0;
 
	}

}
