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
    
    public partial class ParamètresNoeud : Form
    {
        public ParamètresNoeud(Color c, int e)
        {
            InitializeComponent();
            choixCouleur.BackColor = c;
            choixNombre.Value = e;
        }

        public Color Couleur { get { return choixCouleur.BackColor; } }
        public int Epaisseur { get { return (int)choixNombre.Value; } }

        private void choixCouleur_Click(object sender, EventArgs e)
        {
            ColorDialog col = new ColorDialog { Color = choixCouleur.BackColor };
            if (col.ShowDialog() == DialogResult.OK)
            {
                choixCouleur.BackColor = col.Color;
            }
        }

        private void ParamètresNoeud_Load(object sender, EventArgs e)
        {

        }
    }
}
