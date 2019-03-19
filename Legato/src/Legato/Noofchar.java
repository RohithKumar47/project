package Legato;

public class Noofchar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int count=0;
		String str="my name is rohith ravi";
int len=str.length();
		for(int i=0;i<str.length();i++) {
			char a=str.charAt(i);
		boolean c=Character.isLetter(a);
			if(c==false) {
				count++;
			}
		
		}
		System.out.println(len-count);
	}

}
