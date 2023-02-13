using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Maximlyoen
{
    class Noeud
    {
        public Point Position { get; set; }

        public Size Taille { get; set; } = new Size(10, 10);

        public Color Couleur { get; set; } = Color.Black;

        public int Epaisseur { get; set; } = 1;

        public String Texte { get; set; } = "xx";

        public Point Centre
        {
            get
            {
                return new Point(Position.X + Taille.Width / 2, Position.Y + Taille.Height / 2);
            }
        }

        public bool Contient(Point p)
        {
            Rectangle r = new Rectangle(Position, Taille);
            return r.Contains(p);
        }

        public void Déplace(Point p)
        {
            Position = p;
        }

        public void Dessine(Graphics g)
        {
            Rectangle r = new Rectangle(Position, Taille);
            Pen pen = new Pen(Couleur, Epaisseur);
            g.DrawRectangle(pen, r);
            g.DrawString(Texte, new Font("Arial", 16), new SolidBrush(Couleur), Centre);
        }
    }
}
