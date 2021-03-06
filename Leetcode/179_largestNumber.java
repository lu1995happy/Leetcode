import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
	public String largestNumbers(int[] num) {
		
		if (num == null || num.length == 0) 
			return "";
		
		String[] res = new String[num.length];
		
		for (int i = 0; i < num.length; i++)
			res[i] = String.valueOf(num[i]);
		
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str2.compareTo(str1);
			}	
		};
		
		Arrays.sort(res, cmp);
		
		if (res[0].charAt(0) == '0')
			return "0";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < res.length; i++) {
			sb.append(res[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		largestNumber test = new largestNumber();
		int[] num = {9, 34, 33, 45, 65, 76};
		System.out.println(test.largestNumbers(num));
	}
}
