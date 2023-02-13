using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DessinObjets
{
    public partial class FeuilleDessin : Form
    {
        List<Noeud> noeuds;

        List<Trait> traits;

        bool enMouvement;

        bool enDessinTrait;

        Point posSourisMouv;

        Noeud sélection;

        /*Rectangle rectangle;*/
        public FeuilleDessin()
        {
            InitializeComponent();
            DoubleBuffered = true;
            noeuds = new List<Noeud>();
            traits = new List<Trait>();
            Outils.couleurNoeud = Color.Black;
            enMouvement = false;
            Outils.epaisseurDif = 0;
            enDessinTrait = false;
            sélection = new Noeud();
        }

        private void FeuilleDessin_Paint(object sender, PaintEventArgs e)
        {
            foreach(Noeud n in noeuds)
            {
                n.Dessine(e.Graphics);
            }
            foreach(Trait p in traits)
            {
                p.Dessine(e.Graphics);
            }
            if (enDessinTrait)
            {
                e.Graphics.DrawLine(Pens.Red, sélection.Centre , posSourisMouv);
            }
        }

        private void FeuilleDessin_MouseDown(object sender, MouseEventArgs e)
        {
            sélection = Sélection(Outils.EcranVersDessin(e.Location));
            if (déplacement.Checked)
            {
                enMouvement = sélection != null;
            }
            else
            {
                if (e.Button == MouseButtons.Left)
                {
                    if (sélection == null)
                    {
                        Noeud noeud = new Noeud
                        {
                            Position = Outils.DessinVersEcran(new Point(e.Location.X, e.Location.Y)),
                            Taille = new Size(20, 20),
                            Epaisseur = Outils.epaisseurDif,
                            Couleur = Outils.couleurNoeud
                        };
                        noeuds.Add(noeud);
                        Refresh();
                    }
                    else
                    {
                        enDessinTrait = true;
                        sélection = Sélection(e.Location);
                        Refresh();
                    }
                }
                else
                {
                    if (sélection != null)
                    {
                        ParamètresNoeud param = new ParamètresNoeud(sélection.Couleur, sélection.Epaisseur);
                        if (param.ShowDialog() == System.Windows.Forms.DialogResult.OK)
                        {
                            sélection.Couleur = param.Couleur;
                            sélection.Epaisseur = param.Epaisseur;
                            Refresh();
                        }
                    }
                }
            }
        }

        
        private Noeud Sélection(Point p)
        {
            Noeud res = null;
            int i = 0;
            while(res == null && i < noeuds.Count)
            {
                if(noeuds[i].Contient(p))
                {
                    res = noeuds[i];
                }
                i++;
            }
            return res;
        }

        private void FeuilleDessin_MouseMove(object sender, MouseEventArgs e)
        {
            if(enMouvement)
            {
                sélection.Déplace(e.Location);
                Refresh();
            }
            posSourisMouv = e.Location;
            Refresh();
        }

        private void FeuilleDessin_MouseUp(object sender, MouseEventArgs e)
        {
            enMouvement =false;

            if(enDessinTrait)
            {
                Noeud fin = Sélection(Outils.EcranVersDessin(e.Location));
                if(fin != null && !fin.Equals(sélection))
                {
                    Trait trait = new Trait
                    {
                        Source = sélection,
                        Destination = fin
                    };
                    traits.Add(trait);
                }
                enDessinTrait = false;
                Refresh();
            }
        }

        private void déplacement_Click(object sender, EventArgs e)
        {
            déplacement.Checked = !déplacement.Checked;
            if (déplacement.Checked == true)
            {
                déplacement.Text = "Mouvement";
            }
            else
            {
                déplacement.Text = "Déplacement";
            }
        }

        private void FeuilleDessin_Load(object sender, EventArgs e)
        {

        }

        private void Agrandir_Click(object sender, EventArgs e)
        {
            Outils.epaisseurDif = Outils.epaisseurDif + 1;
        }

        private void Retrecir_Click(object sender, EventArgs e)
        {
            Outils.epaisseurDif = Outils.epaisseurDif - 1;
        }

        private void butonEffacer_Click(object sender, EventArgs e)
        {
            noeuds.Clear();
            traits.Clear();
            Refresh();
        }

        private void buttonCouleur_Click(object sender, EventArgs e)
        {
            ColorDialog col = new ColorDialog { Color = Outils.couleurNoeud };
            if(col.ShowDialog() == DialogResult.OK)
            {
                Outils.couleurNoeud = col.Color;
            }
        }

        private void vScrollBarVert_Scroll(object sender, ScrollEventArgs e)
        {
            Outils.Origine = new Point(Outils.Origine.X, -e.NewValue);
            Refresh();
        }

        private void hScrollBarHori_Scroll(object sender, ScrollEventArgs e)
        {
            Outils.Origine = new Point(-e.NewValue , Outils.Origine.Y);
            Refresh();
        }
    }
}
