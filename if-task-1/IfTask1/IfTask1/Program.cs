using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IfTask1
{
    class Program
    {
        static void Main(string[] args)
        {
            int number=0;
            string message = string.Empty;
            Console.Write("This program check is typed number negative/positive or zero. Type number: ");
            bool result = int.TryParse(Console.ReadLine(), out number);
            if (!result)
            {
                message = "Input is NOT a number";
            }
            else if (number == 0)
            {
                message = string.Format("You type number zero {0}.", number);
            }
            else if(number < 0)
            {
                message = string.Format("You typed number {0} and it is negative", number);
            }
            else
            {
                message = string.Format("You typed number {0} and it is positive", number);
            }
            Console.WriteLine(message);
            Console.ReadKey();

             

        }
    }
}
