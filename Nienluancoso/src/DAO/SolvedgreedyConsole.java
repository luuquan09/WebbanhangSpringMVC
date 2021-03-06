package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import BEAN.KnapConsole;
import BEAN.KnapsackPackage;

public class SolvedgreedyConsole {
	
	
	
	public static List<KnapConsole> knapsackGreProc(int W[], int V[],String Na[], int SL[], int M, int n) {
		List<KnapConsole> listkq=null;
		KnapConsole[] packs = new KnapConsole[n];
		for (int i = 0; i < n; i ++) {
			packs[i] = new KnapConsole(W[i], V[i],Na[i],SL[i]);
			System.out.print(W[i]+ " " + V[i] +" " + " " + Na[i]+ " " + SL[i] + "\n");
		}
		// Sắp xếp theo giá trị value / weight
		
		
		
		Arrays.sort(packs, 
		new Comparator<KnapConsole>() {
			public int compare(KnapConsole kPackA, KnapConsole kPackB) {
	
				return kPackB.getCost().compareTo(kPackA.getCost());
			}	
		});
		
	

		
		int remain = M;	// Tổng khối lượng
		double result = 0d;		
		int i = 0;
		boolean stopProc = false;
		int SLs=1;
		while (!stopProc) {
			
			if (packs[i].getWeight() <= remain && SLs <= packs[i].getSLsp() ) {
				remain -= packs[i].getWeight();
				result += packs[i].getValue();	
			
				System.out.print(SLs);
				System.out.println(" Name "+packs[i].getnamething() + " - Weight " + packs[i].getWeight() + " - Value " + packs[i].getValue() + " SL:" + packs[i].getSLsp());
			//	KnapConsole kq = new KnapConsole (packs[i].getWeight(),packs[i].getValue(),packs[i].getnamething(),packs[i].getSLsp());
			
				
				
				/*try {
					listkq.add(kq);
				} catch (Exception e) 
				{
					
					e.printStackTrace();
				}*/
			
				SLs += 1;
			
			}
			
			
			if (packs[i].getWeight() > remain || SLs > packs[i].getSLsp()) {
				i ++;
				SLs=1;
			}
			
			if (i == n) {
				stopProc = true;
			}
		}
		
		System.out.println("Max Value:\t" + result);
	return listkq;
	}
	
	public static void main(String [] args) {
		
		
		int W[] = new int[]{12, 2, 1, 1, 4};
		int V[] = new int[]{4, 2, 1, 2, 10};
		int SL[] = new int[]{1, 1, 2, 3, 2};
		String Na[] = new String[] {"Kim cuong","Vang","Bac","Dong","Sat"};
		int M = 15;
		int n = V.length;
		knapsackGreProc(W, V, Na, SL, M, n);
	}
	


}
