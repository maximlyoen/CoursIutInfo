using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace dessin
{
    public partial class Listemoi : Form
    {
        public Listemoi()
        {
            InitializeComponent();
            List<String> mois = new List<String>()("Janvier", "Février");
            mois.Add("Mars");
            foreach (string s in mois)
            {
                Listemoi.Items.add(s);
            }
        }
    }
}
