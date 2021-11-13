package list.arraylist;

import java.util.Arrays;

class TestData {

    public static ArrayList<Integer> defaultList1() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return arr;
    }

    public static ArrayList<Integer> defaultList2() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return arr;
    }

    public static ArrayList<Integer> defaultList3() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return arr;
    }

    public static ArrayList<Integer> defaultList4() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return arr;
    }

    public static ArrayList<String> defaultList5() {
        ArrayList<String> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return arr;
    }

    public static ArrayList<String> defaultList6() {
        ArrayList<String> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList("anteater", "snowy owl", "crocodile", "puppy",
                "meerkat", "crocodile", "sheep", "puppy", "parrot", "sheep"));
        return arr;
    }

    public static ArrayList<Integer> sortedList1() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return arr;
    }

    public static ArrayList<Integer> sortedList2() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return arr;
    }

    public static ArrayList<Integer> sortedList3() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return arr;
    }

    public static ArrayList<Integer> sortedList4() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return arr;
    }

    public static ArrayList<String> sortedList5() {
        ArrayList<String> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return arr;
    }

    public static ArrayList<String> sortedList6() {
        ArrayList<String> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList("anteater", "snowy owl", "crocodile", "puppy",
                "meerkat", "crocodile", "sheep", "puppy", "parrot", "sheep"));
        return arr;
    }

}
