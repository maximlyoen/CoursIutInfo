using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace DessinObjets
{
    internal class Outils
    {
        static public int epaisseurDif { get; set; } = 2;

        static public Color couleurNoeud { get; set; } = Color.Black;

        static public Point Origine { get; set; } = new Point(0, 0);

        public static Point DessinVersEcran(Point p)
        {
            return new Point(p.X + Origine.X, p.Y + Origine.Y);
        }

        public static Point EcranVersDessin(Point p)
        {
            return new Point(p.X - Origine.X, p.Y - Origine.Y);
        }
    }
}
