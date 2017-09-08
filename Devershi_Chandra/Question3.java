
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Devershi Chandra <devershichandra27@gmail.com>
 */
public class Question3 
{
    public static ArrayList<Integer> ancientAlgorithm(ArrayList<Integer> L, int A, int B, int C, String S)
    {
        int N = L.size();
        for(int i = 0; i< N; i++)
        {
            switch (S.charAt(i)) {
                case 'R':
                    Collections.reverse(L);
                    break;
                case 'A':
                    for(int j = 0; j<N; j++)
                    {
                        int temp = L.get(j);
                        L.set(j, temp+A);
                    }   break;
                case 'M':
                    for(int j = 0; j<N; j++)
                    {
                        int temp = L.get(j);
                        L.set(j, temp*B);
                    }   break;
                default:
                    break;
            }
            for(int j = 0; j< N; j++)
        {
            int temp = L.get(j);
            L.set(j, temp%C);
        }
        }
        
        return L;
    }
    
    public static void main(String args[])
    {
        java.util.Scanner sc = new java.util.Scanner( System.in);
        ArrayList<Integer> L, output;
        int A, B, C, N; String S;
        int testCases = sc.nextInt();
        int i = 0;
        while(i< testCases)
        {
            N = Integer.parseInt(sc.next());
            L = new ArrayList <Integer>(N);
            int k=0;
            while(k<N)
            {
                L.add(sc.nextInt());
                k++;
            }
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();
            S = sc.next();
            output = Question3.ancientAlgorithm(L, A, B, C, S);
            for(int j=0; j< output.size(); j++)
                System.out.print(output.get(j)+ " ");
            System.out.println();
            i++;
        }
        
    }
}