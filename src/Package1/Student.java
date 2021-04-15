package Package1;

public class Student{
	public static void main(String args[]) {
		String s = "tester";
		System.out.println(s.length());
		for(int i=0;i<s.length()-1;i++) {
			char niddle = s.charAt(i);
			int count = 0;
			for(int j=0;j<s.length()-1;j++) {
				if(s.charAt(j) == niddle) {
					count++;
				} 		
			}
			if(count<2) {
				System.out.println("First non repeated char "+niddle);
			}
		}
		
	}
}