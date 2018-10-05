import java.util.Scanner;

/**
 * Recursivesly converts numbers to different bases
 * @author Brett Tomita
 *
 */
public class RecursiveBases 
{

	/**
	 * Converts a decimal number to a binary number
	 * @param value Value to be converted
	 * @return
	 */
	public static String decimal2Binary(int value)
	{
		int quotient = value / 2;
		int remainder = value % 2;
		if(value < 2) return String.valueOf(remainder);
		
		return decimal2Binary(quotient) + String.valueOf(remainder);
	}
	
	/**
	 * Converts a decimal number to hexadecimal
	 * @param value Value to be converted
	 * @return
	 */
	public static String decimal2Hex(int value)
	{
		int quotient = value / 16;
		int remainder = value % 16;
		String letter = "";
		if(remainder < 10) letter = String.valueOf(remainder);
		switch(remainder)
		{
		case 10:
			letter = "A";
			break;
		case 11:
			letter = "B";
			break;
		case 12:
			letter = "C";
			break;
		case 13:
			letter = "D";
			break;
		case 14:
			letter = "E";
			break;
		case 15:
			letter = "F";
			break;
		}
		
		if(value <= 16) return letter;
				
		return decimal2Hex(quotient) + letter;
	}
	
	/**
	 * Converts a binary number to a decimal number
	 * @param binaryString  Binary number in string format which will be converted to decimal
	 * @return
	 */
	public static int binary2Decimal(String binaryString)
	{
		String[] binary = binaryString.split("");
		int length = binary.length;
		if(length == 1) return Integer.valueOf(binary[0]);
		return (Integer.valueOf((binary[0])) * (int) Math.pow(2, length-1))
				+ binary2Decimal(binaryString.substring(1));
	}
	
	/**
	 * Converts a hexadecimal number to decimal
	 * @param hexString  Hex number in string format which will be converted to decimal
	 * @return
	 */
	public static int hex2Decimal(String hexString)
	{
		String[] hex = hexString.split("");
		int length = hex.length;
		int value = 0;
		String regex = "[0-9]";
		if(hex[0].matches(regex)) value = Integer.valueOf(hex[0]);
		else
		{
			switch(hex[0])
			{
			case "A":
				value = 10;
				break;
			case "B":
				value = 11;
				break;
			case "C":
				value = 12;
				break;
			case "D":
				value = 13;
				break;
			case "E":
				value = 14;
				break;
			case "F":
				value = 15;
				break;
			}
		}
		if(length == 1) return value;
		return value * (int) Math.pow(16, length-1)
				+ hex2Decimal(hexString.substring(1));
	}
	
	/**
	 * Starts process of converting numbers to different bases
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a decimal number to be converted to binary and hexadecimal");
		int value = input.nextInt();
		System.out.println(value + " in binary = " + decimal2Binary(value));
		System.out.println(value + " in hexadecimal = " + decimal2Hex(value));
		
		System.out.println("Enter a binary number to be converted to decimal");
		String binary = Integer.toString(input.nextInt());
		System.out.println(binary + " in decimal = " + binary2Decimal(binary));
		
		System.out.println("Enter a hexadecimal number to be converted to decimal");
		String hex = input.next();
		System.out.println(hex + " in decimal = " + hex2Decimal(hex));
		
		
		
		input.close();
	}

}
