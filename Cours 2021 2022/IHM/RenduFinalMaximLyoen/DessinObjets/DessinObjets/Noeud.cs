using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace DessinObjets
{
    class Noeud
    {
        public Point Position { get; set; }
        public Size Taille { get; set; }
        public Color Couleur { get; set; }
        public int Epaisseur { get; set; } = 2;
        public String Text  { get; set; } = "salut";
        public void Dessine(Graphics g)
        {
            Rectangle r = new Rectangle(Position, Taille);
            Pen p = new Pen(Couleur, Epaisseur);
            g.DrawRectangle(p, r);
            Point textPose = Position;
            Outils.DessinVersEcran(textPose);
            textPose.Offset(new Point(0, 15));
            g.DrawString(Text, new Font("Times New Roman", 15, FontStyle.Bold), Brushes.Black ,textPose);
        }

        public bool  Contient(Point p)
        {
            Rectangle r = new Rectangle(Position, Taille);
            return r.Contains(p);
        }

        public Point Centre
        {
            get { return new Point(Position.X + Taille.Width / 2, Position.Y + Taille.Height / 2); }
        }

        public void Déplace(Point p)
        {
            Position = p;
        }
    }
}
