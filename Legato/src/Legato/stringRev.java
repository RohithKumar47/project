package Legato;

import java.util.Scanner;

public class stringRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		System.out.println("please enter size  the array");
		int n=s.nextInt();
		
System.out.println("please enter the array");
for(int i=0;i<=n-1;i++) {
	
}
int x=s.nextInt();

int  arr[]= {10,20,30,40,50};

for(int i=0;i<=arr.length-1;i++) {
	System.out.println("before reverse:"+arr[i]);
}
for(int i=0;i<=arr.length-i-1;i++) {
	int temp=arr[arr.length-i-1];
	arr[arr.length-i-1]=arr[i];
arr[i]=temp;

}
for(int i=0;i<=arr.length-1;i++) {
	System.out.println("after reverse:"+arr[i]);
}

	}

}
