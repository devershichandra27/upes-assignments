
/**
 *
 * @author Devershi Chandra <devershichandra27@gmail.com>
 */
public class Question2
{
    public static int minimumTravelTime(int[] travelTime, int[] readyTime, int[] cancelTime)
    {
        int currentTime = 0; //this will the minimum time taken
        for(int i=0; i< readyTime.length-1;i++)
        {
            if(currentTime <= readyTime[i]) //cab will reach before passenger
            {
                int waitingTime = readyTime[i] - currentTime;
                currentTime += waitingTime + travelTime[i];
            }
            else if(currentTime>readyTime[i]&& currentTime<cancelTime[i])
                currentTime += travelTime[i];
            else
                return -1;
        }
        //this will be the case for n-1th occurence. i.e. for the last inde
        if(currentTime <= cancelTime[readyTime.length-1])
        {
            currentTime = cancelTime[readyTime.length-1];
        }
        else
            return -1;
        return currentTime;
    }
    public static void main(String args[])
    {
        //will be added once the sample input output of the question is displayed.
        /*at the time of writing, the I/O format wasn't available */
    }
}
