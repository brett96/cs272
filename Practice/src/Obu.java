public class Obu
{
	public Obu(int n)
	{
		System.out.println(Obu(n));
	}
	public String Obu(int n)
	{
		int temp = n;
		if(n <= 1)
		{
			n = temp;
			temp += 1;
		}
		return "Obu " + Obu(n-1);
	}
	
	public static void main(String[] args)
	{
		new Obu(5);
	}
}