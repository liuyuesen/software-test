import java.io.IOException;

import junit.framework.TestCase;

public class test1 extends TestCase{

	public static boolean main(int number) throws IOException {
		// TODO Auto-generated method stub
		int[] list = {50,20,5,5,1,1,1};
		boolean answer = false;
		for (int i =0;i<7;i++) {
			if (number>=list[i]) {
				number-=list[i];
			}
			if (number == 0) {
				answer = true;
				break;
			}
		}
		if (answer == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
