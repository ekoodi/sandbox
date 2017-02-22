using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IfTask2
{
    class Program
    {
        static void Main(string[] args)
        {
            string message = string.Empty;
            int number = 0;
            bool result = int.TryParse(Console.ReadLine(), out number);

            if(!result)
            {
                message = "Not a number";
            }
            else if(number % 2 == 0)
            {
                message = string.Format("Number {0} is Even", number);
                message = "Number " + number + " is Even";
            }
            else
            {
                message = string.Format("Number {0} is Odd", number);
            }
            Console.WriteLine(message);
            Console.ReadKey();
        }
    }
}
