using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FeuilleDessin1
{
    class Trait
    {
        public Noeud Source { get; set; }
        public Noeud Destination { get; set; }

        public void Dessine(Graphics g)
        {
            g.DrawLine(Pens.Red, Source.Centre, Destination.Centre);
        }
    }
}
