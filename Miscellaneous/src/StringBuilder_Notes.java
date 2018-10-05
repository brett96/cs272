
public class StringBuilder_Notes 
{
	public static void main(String[] args) 
	{
		/*
		 * String Builder = mutable object
		 * Use when creating many strings (esp. in loop)
		 * Not thread safe
		 * Very fast and efficient
		 * 
		 * String Buffer = similar to String builder
		 * 	thread safe - synchronized
		 * 	slower, less efficient
		 */
		
		String[] values = {"ford", "chevy", "porche", "toyota", "nissan"};
		// Want string w/ all values together separated by commas ("ford,chevy,porche...") = csv format
		// csv = comma separated values
		
		// Old Way
//		String csv = "";
//		for(String item : values)
//		{
//			csv += item + ","; // String is being created for one time use
//		}
//		System.out.println(csv);
		// Not good because a lot of strings are being created unnecessarily
		
		// New Way = StringBuilder
		StringBuilder csv = new StringBuilder();
		for(int i = 0; i < values.length - 1; i++)
		{
			csv.append(values[i]).append(",");
		}
		csv.append(values[values.length - 1]);
		System.out.println(csv);
	}
}
