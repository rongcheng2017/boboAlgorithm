package linearsearch;

public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 1000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            int res = LinearSearch.search(data, n);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ",time cost:" + time + "s ::  " + res);

        }

//        Student[] stds = {new Student(12,0),new Student(35,0),new Student(1,1)};
//        int res =LinearSearch.search(stds,new Student(35,0));
//        System.out.println(res);


    }
}
