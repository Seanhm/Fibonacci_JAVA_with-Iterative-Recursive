package fibonacci;

//import java.util.*;
//import javax.imageio.ImageIO;
//import java.awt.*;
import java.io.*;

class Fibonacci {
  public static void main(String[] args) throws FileNotFoundException {
    int i=30;//Set the number of fib(i)
    float[] data=new float[i];//Define the return result data[] for the recursive algorithm
    float[] data2=new float[i];//Define the return result data[] for the iterative algorithm

//Draw the data of recursive
System.out.println("----------------------------------------------------");
System.out.println("THE RECURSIVE ALGORITHM: ");
System.out.println("----------------------------------------------------");
    for(int n=0;n<=i-1;n++){
    long startTime=System.currentTimeMillis();//Record the start time of the recursive
    fib(n);//Start the algorithm
    long endTime=System.currentTimeMillis();//Record the end time of the recursive
    System.out.println("No."+(n+1)+" Value:"+fib(n));//List the data
    float excTime=(float)(endTime-startTime)/1000;//Calculate the time
    data[n]=excTime;//Record the time to data[]
    System.out.println("Running time:"+excTime+"s");//Output the time
    }
    
    //Output the data file of the recursive
    File file = new File("/Users/seanhm/Downloads/test.txt");//Define the location of the txt. file
    PrintStream ps = new PrintStream(new FileOutputStream(file));
    for(int n=0;n<data.length;n++) {
    String str = String.valueOf(data[n]+"\n");//Transform the float to string and divide the data using "\n"
	ps.append(str);//Write the file
    }
    ps.close();//Close the flow
    
      
//Draw the data of iterative; similar to above
System.out.println("----------------------------------------------------");
System.out.println("THE ITERATIVE ALGORITHM:");
System.out.println("----------------------------------------------------");
   for(int n=0;n<=i-1;n++){
    long startTime2=System.nanoTime();//Because the iterative is fast, using the nanosecond to record the time
    fib2(n);
    long endTime2=System.nanoTime();
    System.out.println("No."+(n+1)+" Value:"+fib2(n));
    float excTime2=(float)(endTime2-startTime2);
    data2[n]=excTime2/1000000;//Transform the nanosecond to second and record it to data2[]
    System.out.println("Running time:"+excTime2+"ns");
    }
   
 //Output the data file of the iterative
   File file2 = new File("/Users/seanhm/Downloads/test2.txt");//Define the location of the txt. file
   PrintStream os = new PrintStream(new FileOutputStream(file2));
   for(int n=0;n<data.length;n++) {
   String str = String.valueOf(data2[n]+"\n");
	os.append(str);
   }
   os.close();
  }
  
 //Define two algorithms
  //Recursive algorithm fib()
  public static long fib(int n){
      if(n<=1){
        return n;}else{
          return fib(n-1)+fib(n-2);
        }
    }
  //Iterative algorithm fib2()
  public static long fib2(int n){
    int i;
    long[] f = new long[n+1];
    f[0]=0;
    if(n>0){
      f[1]=1;
      }
      for(i=2;i<=n;i++){
        f[i]=f[i-1]+f[i-2];
      }
    return f[n];
  }
}