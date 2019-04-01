import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class test1Test extends test1 {
  test1 test1 = new test1();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException {
		boolean res = test1.main(25);
		assertEquals(true, res);
	}
	
	@Test
	public void test1() throws IOException {
		boolean res = test1.main(23);
		assertEquals(true, res);
	}
	
	@Test
	public void test2() throws IOException {
		boolean res = test1.main(55);
		assertEquals(true, res);
	}
	
	@Test
	public void test3() throws IOException {
		boolean res = test1.main(83);
		assertEquals(true, res);
	}
	
	

}
