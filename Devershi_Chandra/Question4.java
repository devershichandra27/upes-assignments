
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Devershi Chandra <devershichandra27@gmail.com>
 */
public class Question4 
{
    public static int hcf(int x, int y)
    {
        if(x==0)
        {
            return y;
        }
            
        return hcf(y%x, x);
    }
    public static int getGCDofArray(ArrayList<Integer> A)
    {
        int prize = A.get(0);   
        
        
            for(int i = 0; i< A.size(); i++)
            {
                prize =  hcf((int) A.get(i), prize);
            }
        return prize;
        
    }
    public static ArrayList <ArrayList <Integer>> subsets(ArrayList<Integer> A)
    {
        int length = A.size();
        ArrayList <ArrayList <Integer>> powerSets = new ArrayList<ArrayList <Integer>>();
        for(int i = 1; i< 1<<length; i++)
        {
            ArrayList <Integer> subset = new ArrayList<Integer>();
            for(int j=0; j<length;j++)
            {
                if((i & (1 << j))>0)
                {
                        subset.add(A.get(j));
                }
            }
            powerSets.add(subset);
        }
        return powerSets;
    }
    
    public static int gcdProduct(ArrayList<Integer> A)
    {
        int product = 1;
        ArrayList <ArrayList <Integer>> powerSets = subsets(A);
        for(int i =0; i<powerSets.size(); i++)
        {
            ArrayList<Integer> subset = (ArrayList<Integer>) powerSets.get(i);
            int gcd = getGCDofArray(subset);
            product *= gcd;
        }
        return product%1000000007;
    }
   
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        ArrayList <Integer> L;
        int i = 0;
        while(i<testcases)
        {
            int N = sc.nextInt();
            L = new ArrayList<Integer>(N);
            int j = 0;
            while(j<N)
            {
                L.add(sc.nextInt());
                j++;
            }
            System.out.println(gcdProduct(L));
            i++;
        }
    }
}
