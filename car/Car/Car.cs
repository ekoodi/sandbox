using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Car
{
    class Car
    {
        private string mark;
        private float speed;

        //Default Constructur
        public Car ()
        {
            mark = "Ford";
            speed = 80.0F;
        }
        // Constuctor with parameters
        public Car(string Mark, float Speed)
        {
            this.mark = Mark;
            this.speed = Speed;
        }

        //Methods
        public string RetrieveData()
        {
            return mark + " " + speed; 
                //string.Format("Merkki: {0}\nNopeus: {1} km/h", mark, speed);
        }

    }
}
