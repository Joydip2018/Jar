import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class readcsv {
	public static void main(String []args)
	{
		readcsv rs=new readcsv();
		rs.VerifySearchCriteria();
		rs.tableHeading();
		rs.rowcount();
	}
	
	public void VerifySearchCriteria()
	{
		Scanner scanner;
		HashMap<String, String> HM= new HashMap<String, String>();
		ArrayList<String> Label= new ArrayList<String>();
		Label.add("Name");
		Label.add("Emp ID");
		Label.add("Zone");
		int i = 0;
		try 
		{
			scanner = new Scanner(new File("./src/sample.csv"));
			scanner.useDelimiter("[,\n]");
			while(scanner.hasNext())
			{
				String str=scanner.next();
				if(str.equalsIgnoreCase(Label.get(i)))
				{
					HM.put(str, scanner.next());
					i++;
					if(i==Label.size())
					{
						break;
					}
				}
				else if(str.equalsIgnoreCase("DOJ"))
				{
					break;
				}
			}
			System.out.println(HM);
			scanner.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void tableHeading()
	{
		boolean found=false;
		List<String> str= new ArrayList<String>();
		List<String> TableHeading= new ArrayList<String>();
		Scanner scanner;
		try 
		{
		scanner = new Scanner(new File("./src/sample.csv"));
	    scanner.useDelimiter("[,\n \r]");
	    while(scanner.hasNextLine() && !found)
	     {
	            str.add(scanner.next());
	            String stp=str.get(0);
	            if(stp.equalsIgnoreCase("DOJ"))
	            {
		            while(stp.equalsIgnoreCase("DOJ"))
		            {
		            	str.add(scanner.next());
		            	String stp1=str.get(str.size()-1);
		            	if(stp1.equalsIgnoreCase("Possition"))
		            	{
		            		TableHeading.addAll(str);
		            		str.clear();
		            		break;		            		
		            	}
		            }
	            }
	            else
	            {
	            scanner.nextLine();
	            str.clear();
	            }
	     }
	     System.out.println(TableHeading);     
	     scanner.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public void rowcount()
	{
		Scanner scanner;
		try 
		{
			scanner = new Scanner(new File("./src/sample.csv"));
			scanner.useDelimiter(",");
			int count=0;
			while(scanner.hasNextLine())
			{
				if(scanner.next().equalsIgnoreCase("DOJ"))
				{
					count=-1;
				}
	            count++;
	            scanner.nextLine();
			}
			System.out.println(count);
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

}
