package program;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//My class name
public class Program {
private static DecimalFormat df2 = new DecimalFormat("#.##");

//Method to calculate Presentvalue
public static double calculatePv(double futureValue, double annualInterestRate,
double numberOfYears) {

annualInterestRate = annualInterestRate/100;
double calculatePv;
calculatePv = futureValue/Math.pow((1+annualInterestRate), numberOfYears);
return calculatePv;
}
//Method to calculate Delta
public static List<Double> calculateDelta(List<Double> pvList, List<Double> rate) {
List<Double> delta = new LinkedList<>();
for(int i=0;i<pvList.size()-1;i++) 
{
double change = ((pvList.get(i)-pvList.get(i+1))/
(rate.get(i)-rate.get(i+1)));
delta.add(change);
}
return delta;
}

//Main method
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
List<Double> pvList = new LinkedList<>();
List<Double> rateList = new LinkedList<>();
System.out.println("Enter the number of Investments");
int n = sc.nextInt();
for(int i=0;i<n;i++) {
System.out.println("Enter the Future Value amount");
double fv = sc.nextDouble();
System.out.println("Enter Annual Interest Rate");
double rate = sc.nextDouble();
System.out.println("Enter the Number of Years");
double years = sc.nextDouble();
double pv = calculatePv(fv,rate,years);
String formattedPv = df2.format(pv);
System.out.println("The Calculated Present Value is $"+formattedPv+"\n");
pvList.add(Double.parseDouble(formattedPv));
rateList.add(rate);
}
List<Double> deltaList = new LinkedList<>();
deltaList = calculateDelta(pvList,rateList);
for(double delta: deltaList) {
System.out.println("The Calculated Delta Change is " +df2.format(delta));
}
}
}