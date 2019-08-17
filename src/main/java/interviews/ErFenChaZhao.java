package interviews;

/**
 * @author abaka
 * @date 2019/8/16 19:17
 */
public class ErFenChaZhao {
    /**
     * 二分查找-非递归
     * @param num
     * @param array
     * @return
     */
        public static int binarySearch(int num,int[] array){
            int left = 0; //代表第一个元素，下标从0开始
            int right = array.length -1;
            while(left <= right){
                int mid = left+(right-left)/2;
                if(array[mid]<num){
                    left=mid+1;
                }else if(array[mid]>num){
                    right = mid -1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

    /**
     * 二分查找-递归
     * @param num
     * @param arr
     * @param left
     * @param right
     * @return
     */
        public static int binarySearch2(int num, int[] arr,int left,int right){
            while (left < right){
                int mid = left + (right - left) / 2;
                if (num < arr[mid])
                    return binarySearch2(num,arr,left,mid - 1);
                else if (num > arr[mid])
                    return binarySearch2(num,arr,mid + 1,right);
                else
                    return mid;
            }
            return -1;
        }
        public static void main(String[] args) {
            int[] array={1,2,3,4,5,6,9,10};
            int num = 9;
           int ret = binarySearch2(num,array,0,array.length);
           if (ret != -1){
               System.out.println(ret);
           }
        }
}
