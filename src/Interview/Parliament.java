package Interview;

import java.util.Scanner;

/**
 * @date: 11/04/2017 8:50 PM
 * @author: qinjiangbo@github.io
 */
public class Parliament {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int[] u=new int[]{
                1,2,5,9,14,20,27,35,44,54,65,77,90,104,119,135,152,170,189,209,230,252,275,299,324,
                350,377,405,434,464,495,527,560,594,629,665,702,740,779,819,860,902,945,989,1034,1111
        };
        int a=in.nextInt();
        int b=0;
        int k=22;
        int m=0;
        int h=45;
        while(!(a< u[k+1]&&a>=u[k]))
        {
            if(a>=u[k+1])
            {
                m=k;
                k=(k+h)/2;
            }
            else if(a< u[k])
            {
                h=k;
                k=(m+k)/2;
            }
        }
        b=a-u[k];
        int e=b/k;
        b=k-b%k;
        int sum = 1;
        for(int i=2+e;i< k+e+2;i++)
        {
            if(b>0)
                sum = sum * i;
            else sum = sum * (i+1);
            if(i!=k+e+1);
            b--;
        }
        System.out.println(sum);
    }
}
