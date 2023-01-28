import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		judge jd = new judge();
		if(jd.leap_year(year) == true)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
}


class judge{
	int year;
	boolean result;
	boolean leap_year(int year) {
		this.year = year;
		if(year%4 == 0){
			if( (year%400 == 0) | (year%100 != 0)) {
				result = true;
			}
			else {
				result = false;
			}
		}
		return result;
	}
}
