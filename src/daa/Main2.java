package daa;

import java.util.Scanner;

public class Main2 {

    public static int data[] = null;
    public static long step;

    public static void sort(int left,int right,int temp[]){
        if(left<right){
            int mid = (left+right)/2;
            sort(left,mid,temp);
            sort(mid+1,right,temp);
            sortMerge(left,mid,right,temp);
        }
    }
    public static void sortMerge(int left,int mid,int right,int temp[]){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid&&j<=right){
            if(data[i]<=data[j]){
                temp[t++] = data[i++];
            }else{
                temp[t++] = data[j++];
                step+=mid-i+1;
            }
        }

        while(i<=mid){
            temp[t++] = data[i++];
        }
        while(j<=right){
            temp[t++] = data[j++];
        }
        t=0;
        while(left<=right){
            data[left++] = temp[t++];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s;
        while((s=sc.nextInt())!=0){
            data = new int[s];
            for(int i=0;i<s;i++){
                data[i] = sc.nextInt();
            }
            step=0L;
            int temp[] = new int[data.length];
            Main2.sort(0,data.length-1,temp);
            System.out.println(step);
        }
    }

}