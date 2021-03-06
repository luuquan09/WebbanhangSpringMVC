package DAO;

import java.util.ArrayList;
import java.util.List;

import BEAN.KnapsackPackage;
import BEAN.KnapsackPackageResult;

public class Readlistimport {
	public static List<KnapsackPackage> TestdataFeed(String path){
		  Double ValueS;
		  Double Ms;
		  String Name;
		//  Double SL;
		  List<KnapsackPackage> dssp = new ArrayList<KnapsackPackage>();
	   	
	  		
	  		
	  		ReadExcelFilesuport config = new ReadExcelFilesuport(path);
	   		int rows = config.getrowcount(0);   
	  // 		System.out.print(rows);
	   		for(int i=0;i<rows;i++) {
	   			
	   			//Giá trị
	   			Name = config.getData(0, i, 0);
	   			//Trọng lượng
	   			Ms = config.getintData(0, i, 1);
	   			//Tên đồ vật
	   			ValueS = config.getintData(0, i, 2);
	   			//Ép kiểu
	   			double SL = config.getintData(0, i, 3);
	   			long l = (long) SL;
	   			int ii = (int)l;
	   			//String sl = String.valueOf(SL);
	   			

	   			KnapsackPackage sp = new KnapsackPackage(Ms,ValueS,Name,ii);
	   			dssp.add(sp);
	   		
	   		}
	   		
	   		
	   		return dssp;
	   	}
	
	public static double TKL(List<KnapsackPackage> dssp) {
		double TongKL=0;
		for(KnapsackPackage a:dssp) {
			TongKL=TongKL + (a.getWeight() * a.getSLsp());
		}
		return TongKL;
	}

	
	public static double TGTafter(List<KnapsackPackage> dssp) {
		double TongGT=0;
		for(KnapsackPackage a:dssp) {
			TongGT=TongGT + (a.getSLsp() * a.getValue());
		}
		return TongGT;
	}
	
	
	public static int TSL(List<KnapsackPackage> dssp) {
		int TongSL=0;
		for(KnapsackPackage a:dssp) {
			TongSL=TongSL + a.getSLsp();
		}
		return TongSL;
	}
	//Sau khi tính toán
	
	public static double TKLtinhtoan(List<KnapsackPackageResult> dssp) {
		double TongKL=0;
		for(KnapsackPackageResult a:dssp) {
			TongKL=TongKL + (a.getSLsp()*a.getWeight());
		}
		return TongKL;
	}

	
	public static double TGTtinhtoan(List<KnapsackPackageResult> dssp) {
		double TongGT=0;
		for(KnapsackPackageResult a:dssp) {
			TongGT=TongGT + (a.getSLsp() * a.getValue());
		}
		return TongGT;
	}
	
	
	public static int TSLtinhtoan(List<KnapsackPackageResult> dssp) {
		int TongSL=0;
		for(KnapsackPackageResult a:dssp) {
			TongSL=TongSL + a.getSLsp();
		}
		return TongSL;
	}
	
	
	
	
}
