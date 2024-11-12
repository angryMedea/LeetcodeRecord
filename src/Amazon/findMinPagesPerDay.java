package Amazon;

public class findMinPagesPerDay {
    public static void main(String[] args) {
    int[] pages = {30,11,23,4,20};
    int days = 6;
    System.out.println(solution(pages, days));
    }

    public static int solution(int[] pages, int days){
        if(days < pages.length) return -1;
        int min = 1;
        int max = 0;
        for(int page : pages){
            max = Math.max(page,max);
        }
        while(min < max){
            int mid = min + max >> 1;
            if (finishDays(pages,mid,days)) {
                max = mid;
            }else
                min = mid + 1;
        }
        return min;
    }

    public static boolean finishDays(int[] pages, int minPage,int days){
        int count = 0;
        for(int page : pages){
            //must multiply 1.0 to convert int to double
            count += Math.ceil(page * 1.0/ minPage);
        }
        return count <= days;
    }
}
