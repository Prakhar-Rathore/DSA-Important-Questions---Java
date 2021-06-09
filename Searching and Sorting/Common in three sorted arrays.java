// Given three arrays sorted in non-decreasing order, 
// print all common elements in these arrays.

public ArrayList<Integer> find(int[] arr1, int[] arr2, int[] arr3) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;

        int prev1 = Integer.MIN_VALUE;
        int prev2 = Integer.MIN_VALUE;
        int prev3 = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n1 && j < n2 && k < n3) {
            while(i < n1 && arr1[i] == prev1) {
                i++;
            }
            while (j < n2 && arr2[j] == prev2) {
                j++;
            }
            while (k < n3 && arr3[k] == prev3) {
                k++;
            }
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                list.add(arr1[i]);
                prev1 = arr1[i];
                prev2 = arr2[j];
                prev3 = arr3[k];
                i++;
                j++;
                k++;
            }
            else if (arr1[i] < arr2[j]) {
                prev1 = arr1[i];
                i++;
            }
            else if (arr2[j] < arr3[k]) {
                prev2 = arr2[j];
                j++;
            }
            else {
                prev3 = arr3[k];
                k++;
            }
        }
        return list;
    }
