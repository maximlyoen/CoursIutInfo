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
    
    public partial class Musicien
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Musicien()
        {
            this.Oeuvre = new HashSet<Oeuvre>();
        }
    
        public int Code_Musicien { get; set; }
        public string Nom_Musicien { get; set; }
        public string Prénom_Musicien { get; set; }
        public Nullable<int> Année_Naissance { get; set; }
        public Nullable<int> Année_Mort { get; set; }
        public Nullable<int> Code_Pays { get; set; }
        public byte[] Photo { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Oeuvre> Oeuvre { get; set; }
    }
}
