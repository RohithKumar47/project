package Com.assignments;
import java.util.*;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> str=new ArrayList<String>();
		str.add("mohan");
		str.add("raju");
		str.add("rahul");
		str.add("ravi");
		str.add("ram");
		
		for(int i=0;i<str.size()/2;i++) {
			String temp1 = str.get(i);
			str.set(i, str.get(str.size()-1-i));
			str.set(str.size()-1-i, temp1);
		}
 

			System.out.println(str);
	
			
		
	}

	}

