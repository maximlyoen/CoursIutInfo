using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Maximlyoen
{
    class Trait
    {
        public Noeud Source { get; set; }

        public Noeud Destination { get; set; }

        public Color Couleur { get; set; } = Color.Black;

        public void Dessine(Graphics g)
        {
            g.DrawLine(new Pen(Couleur), Source.Centre, Destination.Centre);
        }
    }
}
