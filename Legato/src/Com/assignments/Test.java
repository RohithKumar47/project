package Com.assignments;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String name[]= {"raju","mohan","venky","preetham","abhi"};
for (int i = 0; i < name.length; i++) {
    for (int j = i + 1; j < name.length; j++) {
        if (name[i].compareTo(name[j])>0 ) {
            String tmp = name[i];
            name[i] = name[j];
            name[j] = tmp;
        }
    }
}
System.out.println("Sort Order of given array: ");
for (int i = 0; i < name.length; i++) {
	System.out.println(name[i]);
}
	}
	
}
