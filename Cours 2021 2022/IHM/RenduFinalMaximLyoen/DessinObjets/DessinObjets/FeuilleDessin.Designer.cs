namespace DessinObjets
{
    partial class FeuilleDessin
    {
        /// <summary>
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur Windows Form

        /// <summary>
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FeuilleDessin));
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.déplacement = new System.Windows.Forms.ToolStripButton();
            this.Agrandir = new System.Windows.Forms.ToolStripButton();
            this.Retrecir = new System.Windows.Forms.ToolStripButton();
            this.butonEffacer = new System.Windows.Forms.ToolStripButton();
            this.buttonCouleur = new System.Windows.Forms.ToolStripButton();
            this.vScrollBarVert = new System.Windows.Forms.VScrollBar();
            this.hScrollBarHori = new System.Windows.Forms.HScrollBar();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.déplacement,
            this.Agrandir,
            this.Retrecir,
            this.butonEffacer,
            this.buttonCouleur});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(800, 25);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // déplacement
            // 
            this.déplacement.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.déplacement.Image = ((System.Drawing.Image)(resources.GetObject("déplacement.Image")));
            this.déplacement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.déplacement.Name = "déplacement";
            this.déplacement.Size = new System.Drawing.Size(45, 22);
            this.déplacement.Text = "Dessin";
            this.déplacement.Click += new System.EventHandler(this.déplacement_Click);
            // 
            // Agrandir
            // 
            this.Agrandir.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Agrandir.Image = ((System.Drawing.Image)(resources.GetObject("Agrandir.Image")));
            this.Agrandir.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.Agrandir.Name = "Agrandir";
            this.Agrandir.Size = new System.Drawing.Size(23, 22);
            this.Agrandir.Text = "+";
            this.Agrandir.Click += new System.EventHandler(this.Agrandir_Click);
            // 
            // Retrecir
            // 
            this.Retrecir.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Retrecir.Image = ((System.Drawing.Image)(resources.GetObject("Retrecir.Image")));
            this.Retrecir.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.Retrecir.Name = "Retrecir";
            this.Retrecir.Size = new System.Drawing.Size(23, 22);
            this.Retrecir.Text = "-";
            this.Retrecir.ToolTipText = "-";
            this.Retrecir.Click += new System.EventHandler(this.Retrecir_Click);
            // 
            // butonEffacer
            // 
            this.butonEffacer.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.butonEffacer.Image = ((System.Drawing.Image)(resources.GetObject("butonEffacer.Image")));
            this.butonEffacer.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.butonEffacer.Name = "butonEffacer";
            this.butonEffacer.Size = new System.Drawing.Size(47, 22);
            this.butonEffacer.Text = "Effacer";
            this.butonEffacer.Click += new System.EventHandler(this.butonEffacer_Click);
            // 
            // buttonCouleur
            // 
            this.buttonCouleur.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.buttonCouleur.Image = ((System.Drawing.Image)(resources.GetObject("buttonCouleur.Image")));
            this.buttonCouleur.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.buttonCouleur.Name = "buttonCouleur";
            this.buttonCouleur.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.buttonCouleur.Size = new System.Drawing.Size(53, 22);
            this.buttonCouleur.Text = "Couleur";
            this.buttonCouleur.Click += new System.EventHandler(this.buttonCouleur_Click);
            // 
            // vScrollBarVert
            // 
            this.vScrollBarVert.LargeChange = 50;
            this.vScrollBarVert.Location = new System.Drawing.Point(780, 25);
            this.vScrollBarVert.Maximum = 800;
            this.vScrollBarVert.Name = "vScrollBarVert";
            this.vScrollBarVert.Size = new System.Drawing.Size(20, 425);
            this.vScrollBarVert.SmallChange = 4;
            this.vScrollBarVert.TabIndex = 1;
            this.vScrollBarVert.Scroll += new System.Windows.Forms.ScrollEventHandler(this.vScrollBarVert_Scroll);
            // 
            // hScrollBarHori
            // 
            this.hScrollBarHori.LargeChange = 50;
            this.hScrollBarHori.Location = new System.Drawing.Point(0, 430);
            this.hScrollBarHori.Maximum = 800;
            this.hScrollBarHori.Name = "hScrollBarHori";
            this.hScrollBarHori.Size = new System.Drawing.Size(780, 20);
            this.hScrollBarHori.SmallChange = 4;
            this.hScrollBarHori.TabIndex = 2;
            this.hScrollBarHori.Scroll += new System.Windows.Forms.ScrollEventHandler(this.hScrollBarHori_Scroll);
            // 
            // FeuilleDessin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.hScrollBarHori);
            this.Controls.Add(this.vScrollBarVert);
            this.Controls.Add(this.toolStrip1);
            this.Name = "FeuilleDessin";
            this.Text = "Dessin";
            this.Load += new System.EventHandler(this.FeuilleDessin_Load);
            this.Paint += new System.Windows.Forms.PaintEventHandler(this.FeuilleDessin_Paint);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.FeuilleDessin_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.FeuilleDessin_MouseMove);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.FeuilleDessin_MouseUp);
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton déplacement;
        private System.Windows.Forms.ToolStripButton Agrandir;
        private System.Windows.Forms.ToolStripButton Retrecir;
        private System.Windows.Forms.ToolStripButton butonEffacer;
        private System.Windows.Forms.ToolStripButton buttonCouleur;
        private System.Windows.Forms.VScrollBar vScrollBarVert;
        private System.Windows.Forms.HScrollBar hScrollBarHori;
    }
}

