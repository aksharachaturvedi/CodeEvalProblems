using System.IO;
using System.Collections.Generic;
using System;

class ValidParentheses
{
    static void Main(string[] args)
    {
       if(args.Length > 0) {
        using (StreamReader reader = File.OpenText(args[0]))
        {  
            string line;
            while ((line = reader.ReadLine()) != null)
            {
                 Console.WriteLine(IsPatenthesis(line));
            }
        }
      }
    }
    
    private static char Complement(int brace) {
        if(brace == '(') return ')'; 
        if(brace == '{') return '}';
        if(brace == '[') return ']';
        return '0';
      }
    //some line with text
    private static bool IsPatenthesis(string line)
    {
        if(line.Length % 2 != 0 || string.IsNullOrEmpty(line)) return false;
            
        Stack<char> st = new Stack<char>();
        foreach(char parens in line)
        {
            if(parens =='{' || parens == '(' || parens == '[')
            {
                st.Push(parens);
            }
            else if( parens =='}' || parens == ')' || parens == ']')
            {
                if (st.Count < 1) return false;
                char c = Complement(st.Peek());
               
                if(c == '0') return false;
                if(c != parens) return false;
                else st.Pop();
            }
            else  return false;
        }
       return st.Count == 0; 
    }
}