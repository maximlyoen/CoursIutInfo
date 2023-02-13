using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Maximlyoen
{
    public partial class Form1 : Form
    {
        private readonly List<Noeud> noeuds = new List<Noeud>();
        private Noeud sélection;
        private bool enMouvement;
        private readonly List<Trait> traits = new List<Trait>();
        private bool enDessinTrait;
        private Point Curseur;
        private Noeud noeudTrait;
        private int EpaisseurParDéfaut { get; set; } = 1;
        private Color CouleurParDéfaut;

        public Form1()
        {
            InitializeComponent();
            DoubleBuffered = true;
        }

        private Noeud Sélection(Point p)
        {
            return noeuds.FirstOrDefault(c => c.Contient(p));
        }

        private void FeuilleDessin_Paint(object sender, PaintEventArgs e)
        {
            for (int i = 0; i < noeuds.Count; i++)
            {
                Noeud noeud = noeuds[i];
                noeud.Dessine(e.Graphics);
            }
            traits.ForEach(t => t.Dessine(e.Graphics));
            if (enDessinTrait)
            {
                noeudTrait = new Noeud { Position = new Point(Curseur.X - 5, Curseur.Y - 5), Taille = new Size(10, 10) };
                Trait traitFin = new Trait { Source = sélection, Destination = noeudTrait, Couleur = ColorLabel.BackColor };
                noeudTrait.Dessine(e.Graphics);
                traitFin.Dessine(e.Graphics);
            }
        }

        private void FeuilleDessin_MouseDown(object sender, MouseEventArgs e)
        {
            sélection = Sélection(e.Location);
            if (déplacement.Checked)
            {
                enMouvement = sélection != null;
            }
            else
            {
                if (sélection == null)
                {
                    Noeud noeud = new Noeud
                    {
                        Position = e.Location,
                        Taille = new Size(10, 10),
                        Epaisseur = EpaisseurParDéfaut,
                        Couleur = CouleurParDéfaut
                    };
                    noeuds.Add(noeud);
                }
                else enDessinTrait = true;
            }
            Refresh();
        }

        private void FeuilleDessin_MouseMove(object sender, MouseEventArgs e)
        {
            if (enMouvement)
            {
                sélection.Déplace(e.Location);
                Refresh();
            }
            else if (enDessinTrait)
            {
                Curseur = e.Location;
                Refresh();
            }
        }

        private void FeuilleDessin_MouseUp(object sender, MouseEventArgs e)
        {
            enMouvement = false;
            if (enDessinTrait)
            {
                Noeud fin = Sélection(e.Location);
                if (fin != null && !fin.Equals(sélection))
                {
                    bool surNoeud = Sélection(e.Location) != null;
                    if (surNoeud)
                    {
                        traits.Add(new Trait { Source = sélection, Destination = fin });
                    }
                }
                else
                {
                    Noeud noeudFin = new Noeud { Position = e.Location, Epaisseur = 1 };
                    noeuds.Add(noeudFin);
                    traits.Add(new Trait { Source = sélection, Destination = noeudFin });
                }
                enDessinTrait = false;
            }
            Refresh();
        }

        private void agrandir_Click(object sender, EventArgs e)
        {
            EpaisseurParDéfaut++;
        }

        private void réduire_Click(object sender, EventArgs e)
        {
            EpaisseurParDéfaut--;
        }

        private void Color_Click(object sender, EventArgs e)
        {
            ColorLabel.BackColor = CouleurParDéfaut;
            ColorDialog col = new ColorDialog { Color = CouleurParDéfaut };
            if (col.ShowDialog() == DialogResult.OK)
            {
                CouleurParDéfaut = col.Color;
            }
        }
    }
}