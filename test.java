public class test {
    public static void main(String[] args){
        int[] list  = {3, 1, 5, 6, 8};
        System.out.println(findMax(list, 0));
    }

    public static int findMax(int[] list, int index){
        if(index == list.length - 1){
            return list[index];
        }
        return Math.max(list[index], findMax(list, index + 1));
    }
}
