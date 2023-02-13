using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FeuilleDessin1
{
    public partial class FeuilleDessin : Form
    {
        List<Noeud> noeuds;
        List<Trait> traits;
        Noeud selection;
        bool enMouvement;
        bool enDessinTrait;
        Point finTrait;
        Color defaultColor;
        public FeuilleDessin()
        {
            InitializeComponent();
            noeuds = new List<Noeud>();
            traits = new List<Trait>();
            selection = null;
            enMouvement = false;
            enDessinTrait = false;
            finTrait = new Point(0,0);
        }

        private void FeuilleDessin_MouseDown(object sender, MouseEventArgs e)
        {
            selection = Selection(e.Location);
            if (selection != null)
            {
                defaultColor = selection.Couleur;
                selection.Couleur = Color.Red;
            }
            if (toggleDeplacement.Checked) 
            {

                enMouvement = selection != null;
            }
            else
            {
                if (selection == null)
                {
                    Noeud n = new Noeud { Position = e.Location };
                    noeuds.Add(n);
                } else
                {
                    enDessinTrait = true;
                    finTrait = e.Location;
                    
                }
                
            }
            Refresh();
        }

        private void FeuilleDessin_MouseMove(object sender, MouseEventArgs e)
        {
            if (enMouvement)
            {
                selection.Deplace(e.Location);
                Refresh();
            } else if (enDessinTrait) {
                finTrait = e.Location;
                Refresh();
            }
        }

        private void FeuilleDessin_MouseUp(object sender, MouseEventArgs e)
        {
            
            if (enDessinTrait && selection != null && Selection(e.Location) == null)
            {
                Noeud n = new Noeud { Position = e.Location };
                noeuds.Add(n);
                traits.Add(new Trait { Source = selection, Destination = n });

            } else if (enDessinTrait && selection != null && Selection(e.Location) != selection)
            {
                traits.Add(new Trait
                {
                    Source = selection,
                    Destination = Selection(e.Location)
                }) ;
            }
            if (selection != null)
            {
                selection.Couleur = defaultColor;
            }
            enMouvement = false;
            selection = null;
            enDessinTrait = false;
            Refresh();

        }

        private void FeuilleDessin_Paint(object sender, PaintEventArgs e)
        {
            noeuds.ForEach(n => n.Dessine(e.Graphics));
            traits.ForEach(t => t.Dessine(e.Graphics));
            if (enDessinTrait)
            {
                Pen p = new Pen(Color.FromArgb(128,255,0,0), 1);
                p.DashStyle = DashStyle.Dot;
                e.Graphics.DrawLine(p, selection.Centre, finTrait);
                Rectangle r = new Rectangle(finTrait.X - 5, finTrait.Y - 5, 10,10);
                e.Graphics.DrawRectangle(p, r);
            }
        }

        private Noeud Selection(Point p)
        {
            return noeuds.FirstOrDefault(c => c.Contient(p));
        }

        private void FeuilleDessin_Load(object sender, EventArgs e)
        {

        }
    }
}
