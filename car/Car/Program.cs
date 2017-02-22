using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Car
{
    class Program
    {
        static void Main(string[] args)
        {
            Car myCar = new Car();
            Car myCar2 = new Car("VW", 90);
            myCar2.Speed = 100;
            string mrk = myCar.Mark;

            Console.WriteLine(myCar.RetrieveData());
            Console.WriteLine(myCar2.RetrieveData());
        }
    }
}
