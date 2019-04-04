package pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;



public class Demo {

	public static void main(String[] args) throws IOException {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		
			hm.put(0, "a");
			hm.put(1, "b");
			hm.put(2, "c");
		
		System.out.println(hm);
		System.out.println("Mohan");
		Set sn = hm.entrySet();
		sn.iterator();
	}

}
