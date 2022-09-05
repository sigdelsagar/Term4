
/**
 * Student Marks calcualator, here you can ask user to input unit name and assign marks for 25 different user and 
 * calcualte highest,lowest marks
 * mean of the marks and standard deviation of marks
 * @author (Sagar Sigdel)
 * @version (03/09/2022)
 */
import java.util.Scanner;

public class StudentMarks
{
    public static void main(String[] args){
         Scanner obj = new Scanner(System.in);
         System.out.println("Enter Unit name: ");
         String unitName = obj.nextLine();
         float[] marks = new float[25];
         
         for (int i=1;i<=marks.length;i++){
            //Loop for 25 student's marks
            while (true){
                //Keep Re-entering until valid marks
                System.out.println("Enter Marks for Student "+i);
                float eachMark = obj.nextInt();
                if (eachMark < 0 || eachMark > 100){
                    System.out.println("Invalid Marks. Should be between 0 and 100!");
                }
                else{
                    //break loop after valid marks
                    marks[i-1] = eachMark;
                    break;
                }
            } 
        }
        
        System.out.println("UnitName is: "+ unitName);
        System.out.println("Marks obtained are :-");
        for (int i=0;i<marks.length;i++){
            System.out.print(marks[i]+",");
        }
        System.out.println();  
        //Refactored highest and lowest using single method
        float highestlowest[] = highestLowest(marks);
        System.out.println("The highest Mark is "+highestlowest[0]+" Lowest Mark is "+highestlowest[1]);
        float mean = calculateMean(marks);
        System.out.println("The Mean is "+mean);
        System.out.println("The Standard Deviation is "+calculateSD(marks,mean));
        
        
    }
    
    public static float[] highestLowest(float[] marks){
        //Using single method to calcualte highest and lowest marks
        float high = 0,low=100;
        float highLow[]={0,0};
        for (int i=0;i<marks.length;i++){
            if (marks[i]>high){
                //substitute with highest value
                high=marks[i];
            }
            if (marks [i] < low){
                //substitute with lowest value
                low=marks[i];
            }
        }
        highLow[0]=high;
        highLow[1]=low;
        return highLow;
    }
    public static float calculateMean(float[] marks){
        float sum=0;
        for (int i=0;i<marks.length;i++){
            sum += marks[i];
        }
        return sum/(float)marks.length;
    }
    
    public static double calculateSD(float[] marks, float mean){
        double sumOfSq = 0.0;
        double[] meanDiffsq = new double[marks.length];
        //array contains mean difference square (Xi-mean)^2
        for (int i=0;i<marks.length;i++){
            meanDiffsq[i] = Math.pow(marks[i] - mean,2);
            sumOfSq += meanDiffsq[i];
        }
        return Math.sqrt(sumOfSq/(marks.length));
    }
}
