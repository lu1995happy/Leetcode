
public class addBoldTagInString {
	
	// Time: O(n*k) (n is length of string, k is size of dict), Space: O(n);
	public String addBoldTag (String s, String[] dict) {
		if (s == null || s.length() == 0)
			return "";
		boolean[] bold = new boolean[s.length()];
		for (int i = 0, end = 0; i < s.length(); i++) {
			for (String word : dict) {
				if (s.startsWith(word, i)) {
					end = Math.max(end, i + word.length());
				}
			}
			bold[i] = end > i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!bold[i]) {
				sb.append(s.charAt(i));
				continue;
			}
			int j = i;
			while (j < s.length() && bold[j]) {
				j++;
			}
			sb.append("<b>").append(s.substring(i, j)).append("</b>");
			i = j - 1;
		}
		return sb.toString();
	}
}
