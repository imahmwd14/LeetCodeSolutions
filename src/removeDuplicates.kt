fun removeDuplicates(nums: IntArray): Int {
    var j = 1
    for (i in 1..nums.lastIndex) if (nums[i] != nums[j]) nums[j++] = nums[i]
    return if (nums.isEmpty()) 0 else j
}