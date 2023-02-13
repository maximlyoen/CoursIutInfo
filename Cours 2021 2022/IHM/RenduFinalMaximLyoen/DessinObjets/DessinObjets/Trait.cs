using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace DessinObjets
{
    class Trait
    {
        public Noeud Source { get; set; }
        public Noeud Destination { get; set;}
        public void Dessine(Graphics g)
        {
            g.DrawLine(Pens.Black, Source.Centre, Destination.Centre);
        }
    }
}
