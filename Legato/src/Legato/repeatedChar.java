package Legato;

public class repeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		String str="MY name is Rohith ravi";
		str=str.toLowerCase();
		
for(int i=0;i<str.length();i++) {
	for(int j=1;j<str.length();j++) {
if(str.charAt(i)==str.charAt(j)) {
count++;
}

		}
	
	System.out.println("repeated character"+" "+str.charAt(i)+" "+count);	
	count=0;

}
	}

}
