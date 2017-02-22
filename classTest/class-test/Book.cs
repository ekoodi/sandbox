using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace class_test
{

    static void Main(string[] args)
    {
        Book book = new Book();
      

    }

    class Book
    {
        public string Name;
        public string Publisher;
        public int Genre;

        public Book ()
        {
            Name = "XXX";
            Publisher = "YYY";
            Genre = 1;
        }

    }
}
