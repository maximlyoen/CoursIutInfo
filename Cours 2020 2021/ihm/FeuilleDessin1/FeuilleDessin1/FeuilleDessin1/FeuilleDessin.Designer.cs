
namespace FeuilleDessin1
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
            this.toggleDeplacement = new System.Windows.Forms.ToolStripButton();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toggleDeplacement});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(800, 25);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // toggleDeplacement
            // 
            this.toggleDeplacement.CheckOnClick = true;
            this.toggleDeplacement.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toggleDeplacement.Image = ((System.Drawing.Image)(resources.GetObject("toggleDeplacement.Image")));
            this.toggleDeplacement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toggleDeplacement.Name = "toggleDeplacement";
            this.toggleDeplacement.Size = new System.Drawing.Size(23, 22);
            this.toggleDeplacement.Text = "toggleDeplacement";
            // 
            // FeuilleDessin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.toolStrip1);
            this.Name = "FeuilleDessin";
            this.Text = "Feuille Dessin";
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
        private System.Windows.Forms.ToolStripButton toggleDeplacement;
    }
}

