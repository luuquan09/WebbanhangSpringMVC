package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import BEAN.KnapsackPackage;
import BEAN.KnapsackPackageResult;

public class Solvedgreedy {
	
	public static List<KnapsackPackageResult> knapsackGreProc(List<KnapsackPackage> dssp, int M, int n) {
		List<KnapsackPackageResult> listkq = new ArrayList<KnapsackPackageResult>();
		
		
		
		KnapsackPackage[] packs = new KnapsackPackage[n];			
		int ii=0;
			for(KnapsackPackage a:dssp) {
				packs[ii] = new KnapsackPackage(a.getWeight(), a.getValue(),a.getnamething(),a.getSLsp());
			
			ii=ii+1;
			}
	
		
		
		// Sắp xếp danh sách import theo giá trị value / weight	
		Arrays.sort(packs, 
		new Comparator<KnapsackPackage>() {
			public int compare(KnapsackPackage kPackA, KnapsackPackage kPackB) {
				
				return kPackB.getCost().compareTo(kPackA.getCost());
			}	
		});
		
	

		
		int remain = M;	// Tổng khối lượng
		double result = 0;		//Tổng giá trị 
		int i = 0;   
		boolean stopProc = false; //Vòng lặp for chỉ dừng khi i bằng với số lượng phần thử listimprot
		int SL = 1;
		
		
		while (!stopProc) {
				//Kiểm tra khối lượng đồ vật i nhỏ hơn khối lượng lấy trộm và SL phải nhỏ hơn hoặc bằng SL của đồ vật đó
			if (packs[i].getWeight() <= remain && SL <= packs[i].getSLsp()) { 
				//Tổng khối lượng lấy trộm trừ cho khối lượng từng đồ vật 
				remain -= packs[i].getWeight();
				//Giá trị đồ vật cộng dồn giá trị đồ vật lấy được
				result += packs[i].getValue();
						
				KnapsackPackageResult kq = new KnapsackPackageResult(packs[i].getWeight(),packs[i].getValue(),packs[i].getnamething(),SL);
				
				String name = kq.getnamething();
			
		
				
				// Trong một danh sách listkq 
				// Kiểm tra xem listkq đã có phần tử đó chưa ??
				// Nếu có phần tử thì phần tử kế tiếp trước khi thêm vào phải kiểm tra xem
				// Phần tử đó đã có mặt trong listkq hay chưa?
				// Nếu có rồi thì remove nó lại
			 
				
				
				if(listkq.size()>0) {
					
					System.out.print("Chi so can remove: " + remove(listkq,name) );
							
					if( remove(listkq,name) != 0) {
							
							listkq.remove(remove(listkq,name));
							
							
							}
					if(remove(listkq,name)==0 ) {
						if(ktlistkq(listkq,name)==true && packs[0].getSLsp()!=1) {
								listkq.remove(remove(listkq,name));
								
								}
							}
					
				}
				listkq.add(kq);
	
						
			
				
				
				SL+=1;
			}
			//Nếu khối lượng của túi nhỏ hơn khối lượng của đồ vật thứ i hoặc SL lần lặp lần lấy đồ vật (SL) lớn hơn số lượng của đồ vật đó
			//thì chuyển sang đồ vật tiếp theo i++ và cập nhật lại SL lần lặp 
		if (packs[i].getWeight() > remain || SL > packs[i].getSLsp()) {				
				i++;
				SL=1;
			}
			// Nếu i bằng n tiếp tục vòng lặp
			if (i == n) {
				stopProc = true;
			}
		}
		
	//	System.out.println("Max Value:\t" + result);
	return listkq;
	}
	
	
	
		//Hàm so sánh phần tử mới chuẩn bị thêm vào và phần tử có sẵn trước đó trả về index phần tử có sẵn trước đó
		public static int remove(List<KnapsackPackageResult>  list,String name) {
			int a=0;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getnamething().equals(name)) {
					a=i;
					
				}
			}
		
			return a;
		}
		//Hàm dùng để kiếm tra nếu phần tử x đã có trong danh sách kết quả thì trả về true
		public static boolean ktlistkq(List<KnapsackPackageResult>  list,String name) {
			boolean result=false;
			
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getnamething().equals(name)) {
						result=true;
					}
				}
			
			return result;
			
		
		}
}