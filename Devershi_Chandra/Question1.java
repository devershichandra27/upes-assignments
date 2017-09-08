
/**
 *
 * @author Devershi Chandra <devershichandra27@gmail.com>
 */

public class Question1 
{
    public static int distanceBetween(int[] p1, int[] p2)
    {
        /*Method to calculate the distance between the points*/
        int distance = Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
        return distance;
    }
    
    public static int routeDecider(int[] A, int[] B, int[] C, int[] X, int[] Y)
    {
        /*This function takes into account the location of initial point A, the final destination point B, the point at which two requests came C,
       and the location of two requests Y and Z*/
        int prize= 0;
        int originalDistance = distanceBetween( A,B); //this will be the original distance between the two points
        int distanceTillPointC = distanceBetween(A, C);
        int distancefromCtoRider = distanceBetween(C,X);
        int distancefromRiderToDestination = distanceBetween(X,B);
        int firstDistance = distanceTillPointC + distancefromCtoRider + distancefromRiderToDestination;
        distancefromCtoRider = distanceBetween(C,Y);
        distancefromRiderToDestination = distanceBetween(Y,B);
        int secondDistance = distanceTillPointC + distancefromCtoRider + distancefromRiderToDestination;
        
        //now check the constraints
        if(firstDistance/originalDistance < 2 || secondDistance/originalDistance < 2)
        {
            if(firstDistance/originalDistance>2)
                return secondDistance;
            return firstDistance <= secondDistance ? 1 : 2;
        }
        return -1;
    }
    
    public static void main(String args[])
    {
        int[] A = {0, 0}; //the departure point
        int[] B = {3, 3};// the destination point
        
        int[] C = {3, 1}; // the point at which two requests come from X and 
        int[] X = {5,0}; //the location of X
        int[] Y = {2,2}; //location of Y
        System.out.println(routeDecider(A, B, C, X, Y));
        
        
    }
}
