namespace DessinObjets
{
    partial class ParamètresNoeud
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.choixNombre = new System.Windows.Forms.NumericUpDown();
            this.buttonOK = new System.Windows.Forms.Button();
            this.buttonAnnuler = new System.Windows.Forms.Button();
            this.choixCouleur = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.choixNombre)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(54, 45);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Epaisseur";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(54, 102);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(43, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Couleur";
            // 
            // choixNombre
            // 
            this.choixNombre.Location = new System.Drawing.Point(137, 43);
            this.choixNombre.Name = "choixNombre";
            this.choixNombre.Size = new System.Drawing.Size(120, 20);
            this.choixNombre.TabIndex = 2;
            this.choixNombre.Value = new decimal(new int[] {
            2,
            0,
            0,
            0});
            // 
            // buttonOK
            // 
            this.buttonOK.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonOK.Location = new System.Drawing.Point(297, 40);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(75, 23);
            this.buttonOK.TabIndex = 3;
            this.buttonOK.Text = "OK";
            this.buttonOK.UseVisualStyleBackColor = true;
            // 
            // buttonAnnuler
            // 
            this.buttonAnnuler.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonAnnuler.Location = new System.Drawing.Point(297, 97);
            this.buttonAnnuler.Name = "buttonAnnuler";
            this.buttonAnnuler.Size = new System.Drawing.Size(75, 23);
            this.buttonAnnuler.TabIndex = 4;
            this.buttonAnnuler.Text = "Annuler";
            this.buttonAnnuler.UseVisualStyleBackColor = true;
            // 
            // choixCouleur
            // 
            this.choixCouleur.AutoSize = true;
            this.choixCouleur.BackColor = System.Drawing.Color.Black;
            this.choixCouleur.Location = new System.Drawing.Point(134, 102);
            this.choixCouleur.MinimumSize = new System.Drawing.Size(50, 13);
            this.choixCouleur.Name = "choixCouleur";
            this.choixCouleur.Size = new System.Drawing.Size(50, 13);
            this.choixCouleur.TabIndex = 5;
            this.choixCouleur.Click += new System.EventHandler(this.choixCouleur_Click);
            // 
            // ParamètresNoeud
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(384, 161);
            this.Controls.Add(this.choixCouleur);
            this.Controls.Add(this.buttonAnnuler);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.choixNombre);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "ParamètresNoeud";
            this.Text = "ParamètresNoeud";
            this.Load += new System.EventHandler(this.ParamètresNoeud_Load);
            ((System.ComponentModel.ISupportInitialize)(this.choixNombre)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown choixNombre;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.Button buttonAnnuler;
        private System.Windows.Forms.Label choixCouleur;
    }
}