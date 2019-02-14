class Solution {
    @Test
    public void test() {
        int[] array = new int[]{1, 2, 5, -1, 4};
        int result = shortestSubarray(array, 13);
        Assert.assertEquals(-1, result);
    }


    public int shortestSubarray(int[] A, int K) {
        int result = -1;
        if (A == null || A.length > 50000 || K <= 0 || K > 1000000000) {
            return result;
        }

        int[] tmpArray = new int[A.length + 1];
        for (int index = 0; index < A.length; index++) {
            for (int i = 0; i < A.length - index; i++) {
                tmpArray[i] = A[i] + tmpArray[i + 1];
                if (tmpArray[i] >= K) {
                    result = index + 1;
                    return result;
                }
            }
        }

        return result;
    }
}