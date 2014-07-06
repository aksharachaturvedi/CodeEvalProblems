//

using System;
using System.IO;
using System.Collections.Generic;

class FirstNonRepeatedCharacter
{
    static void Main(string[] args)
    {
          if(args.Length > 0)
        {
            using (StreamReader reader = File.OpenText(args[0]))
            {  
                string line;
                while ((line = reader.ReadLine()) != null)
                {
                     Console.WriteLine(NonRepeatChar(line));
                }
            }
        }
    }
   
   public static char NonRepeatChar(string line)
   {
       if(line.Length < 1) return ' ';
       if(line.Length ==1) return line[0];
       Dictionary<char, int> dt = new Dictionary<char, int>();
       foreach(char c in line)
       {
           if(dt.ContainsKey(c)) 
           {
            dt[c]+=1;
           }
           else {
               dt.Add(c, 1);
           }
       }
       foreach(char ch in line)
       {
           int value = dt[ch];
           if(value ==1) return ch;
       }
       return ' ';
   }
}