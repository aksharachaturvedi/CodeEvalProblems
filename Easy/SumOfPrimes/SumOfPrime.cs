using System.IO;
using System;
using  System.Collections.Generic;

/*
CHALLENGE DESCRIPTION:
Write a program to determine the sum of the first 1000 prime numbers.
INPUT SAMPLE:
There is no input for this program.
OUTPUT SAMPLE:
Your program should print the sum on stdout, i.e.

*/
class Program
{
    static void Main()
    {
      int sum = SumOfPrime(1000);
      Console.Write(sum);
    }
    
    private static int SumOfPrime(int N) {
    List<int> primeNumbers = new List<int>();
    int sum=0;
    for(int i = 2; primeNumbers.Count < N; i++) 
    {
      bool divisible = false;
      foreach(int number in primeNumbers) 
      {
        if(i % number == 0) {
            divisible = true;
            break;
      }
    }
    if(divisible == false) 
    {    
        sum += i;
        primeNumbers.Add(i);
    }
   }
   return sum;
  }
}
