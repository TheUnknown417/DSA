public class MergeSort
{

    public void mergesort(int [] arr , int left, int right) {
        if (left < right)
        {
            int mid = left + (right - left) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid + 1, right);

        merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr , int left , int mid , int right)
    {

        // size determination
        int n1 = mid-left+1;
        int n2 = right-mid;

        // temporary arrays
        int [] L = new int[n1];
        int [] R = new int[n2];

        // copying elements

        for(int x=0; x<n1 ; x++)
        {
            L[x]= arr[left+x];
        }
        for(int x=0; x<n2 ; x++)
        {
            R[x]= arr[mid+1+x];
        }

        // merging the two arrays

        int i = 0 , j=0 , k= left ;

        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copying remaining elements from L[]
        while(i<n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copying remaining elements from R[]
        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array:");
        for (int num : arr)
            System.out.print(num + " ");

        ms.mergesort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        for (int num : arr)
            System.out.print(num + " ");
    }

}
