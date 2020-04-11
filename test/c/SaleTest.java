package c;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith (Parameterized.class)
public class SaleTest {
	
	private int headphones;
	private int shells;
	private int protectors;
	private float expected;
	private Sale sale;
	
	public SaleTest(int headphones,int shells, int protectors,float expected) {
		this.headphones=headphones;
		this.shells=shells;
		this.protectors=protectors;
		this.expected=expected;
		
	}
	private static Object[][] loadDatasFromFile(){
		Object[][] datas =null;
		try {
			File file=new File("D:\\data.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			
			int count=0;
			String row=null;
			while((row=br.readLine())!=null) {
				count++;
			}
			br.close();
			
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			datas=new Object[count][];
			int i=0;
			while((row=br.readLine())!=null) {
				String columns[]=row.split("\t");
				datas[i]=new Object[columns.length];
				for(int j=0; j<columns.length-1;j++) {
					datas[i][j]=Integer.parseInt(columns[j]);
				}
				
				datas[i][columns.length-1]=Float.parseFloat(columns[columns.length-1]);
				i++;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			return datas;
		}
	}
	@Parameters
	public static Collection<Object[]> getDatas(){
		return Arrays.asList(loadDatasFromFile());
		
	}
	@Before
	public void setUp() {
		sale=new Sale();
	}
	@After
	public void After() {
	}
	@Test
	public void test() {
		float result=sale.commission(headphones, shells, protectors);
		assertEquals(expected,result, 0.001);
		
	}

}