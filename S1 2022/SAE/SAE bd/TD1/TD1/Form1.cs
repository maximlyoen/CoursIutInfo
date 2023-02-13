using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TD1
{
    public partial class Form1 : Form
    {

        List<Musicien> musiciens = new List<Musicien>();
        MusiqueSQLEntities musiqueSQL;

        public Form1()
        {

            InitializeComponent();
            musiqueSQL = new MusiqueSQLEntities();


            var lesmusiciens = (from m in musiqueSQL.Musicien
                               where m.Oeuvre.Count > 0
                               orderby m.Nom_Musicien
                               select m).ToList();

            foreach (Musicien m in lesmusiciens)
            {
                listBox1.Items.Add(m.Nom_Musicien);
                musiciens.Add(m);   
            }
            

            
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            listBox2.Items.Clear(); 
            foreach(Oeuvre o in musiciens[listBox1.SelectedIndex].Oeuvre)
            {
                listBox2.Items.Add(o.Titre_Oeuvre);
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            musiqueSQL = new MusiqueSQLEntities();
            var lesmusiciens = (from m in musiqueSQL.Musicien
                                where m.Oeuvre.Count > 0
                                orderby m.Nom_Musicien
                                select m).ToList();

            listBox1.Items.Clear();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
