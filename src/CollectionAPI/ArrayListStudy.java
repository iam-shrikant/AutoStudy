package CollectionAPI;

import java.util.ArrayList;

public class ArrayListStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("shrikant");
		a.add("Aishwarya");
		a.add("Swapnil");
		a.add("Aishwarya");
		a.remove("Aishwarya");
		a.add(0, "first");
		System.out.println(a);
		
	}

}
