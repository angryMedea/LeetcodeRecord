package DynamicProgramming.memorySearch;

public class Tribonacci_1137 {
    public static void main(String[] args) {
        System.out.println(solution(25));
    }

    /**
     * 记忆化搜索，设置一个cache数组来把计算过的n值存进去，防止重复计算
     * @param n
     * @return
     */
    public static int solution(int n){
        //题目限制 0<= n <= 37，所以把长度设置为40是够的

        int[] cache = new int[40];
        if (n == 0) return 0;
        if (n == 1 || n ==2) return 1;
        //如果数组中的元素不为0，说明这个位置的n已经被搜索过了，就不用再搜索了
        //可以直接return cache[0]
        if(cache[n] != 0) return cache[n];
        //运用递归（or 迭代）
        cache[n] = solution(n - 1) + solution(n - 2) + solution(n - 3);
        return cache[n];
    }
}
