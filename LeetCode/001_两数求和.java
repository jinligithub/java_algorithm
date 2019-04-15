给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

方法一：
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=1+i;j<nums.length;j++){
				//利用target等于两数之和求判断，也可以利用target-num[1]=num[2]来计算
                if((nums[i]+nums[j])==target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}

方法二：
class Solution {
    public int[] twoSum(int[] nums, int target) { 
        //利用map来保存元素	，key和value都是Integer类型的 
	    Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
				//如果两数之和为target
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                 }
				 //把元素放入map集合里，然后和后边元素的进行比较
                map.put(nums[i], i);
           }
        throw new IllegalArgumentException("No two sum solution");
    }
}

方法三
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int check = target - nums[i];
            if (map.containsKey(check)) {
                pair[0] = i;
                pair[1] = map.get(check);
            } else {
                map.put(nums[i], i);
            }
        }    
        return pair;
    }
}