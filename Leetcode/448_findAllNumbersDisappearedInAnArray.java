import java.util.ArrayList;
import java.util.List;

public class findAllNumbersDisappearedInAnArray {
	
	// The basic idea is that we iterate through the input array and mark elements as negative 
	// using nums[nums[i] -1] = -nums[nums[i]-1]. 
	// In this way all the numbers that we have seen will be marked as negative. 
	// In the second iteration, if a value is not marked as negative, it implies
	// we have never seen that index before, so just add it to the return list.
	// Time: O(n); Space: O(1);
	public List<Integer> findDisappear(int[] nums) {
		
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0)
				nums[index] = -nums[index];
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		findAllNumbersDisappearedInAnArray test = new findAllNumbersDisappearedInAnArray();
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(test.findDisappear(nums));
	}
}
