//------------------------------------------------------------------------------
// <auto-generated>
//     Ce code a été généré à partir d'un modèle.
//
//     Des modifications manuelles apportées à ce fichier peuvent conduire à un comportement inattendu de votre application.
//     Les modifications manuelles apportées à ce fichier sont remplacées si le code est régénéré.
// </auto-generated>
//------------------------------------------------------------------------------

namespace TD1
{
    using System;
    using System.Collections.Generic;
    
    public partial class Oeuvre
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Oeuvre()
        {
            this.Musicien = new HashSet<Musicien>();
        }
    
        public int Code_Oeuvre { get; set; }
        public string Titre_Oeuvre { get; set; }
        public string Sous_Titre { get; set; }
        public string Tonalité { get; set; }
        public Nullable<int> Année { get; set; }
        public string Opus { get; set; }
        public Nullable<int> Numéro_Opus { get; set; }
        public Nullable<int> Code_Type { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Musicien> Musicien { get; set; }
    }
}
