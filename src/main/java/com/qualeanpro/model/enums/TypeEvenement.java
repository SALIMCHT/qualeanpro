package com.qualeanpro.model.enums;

public enum TypeEvenement {
	  UTILISATEUR_INSCRIT, // si un utilisateur fait l'inscription dans la platforme 
	  APPRENANT_INSCRIT_FORMATION, // si un utilisateur fait l'inscription dans une formation 
	  FORMATION_CREER, // si le formateur est créer une formation est pas encore validé par l'administrateur
	  FORMATION_PUBLIE, // si le formateur est publié une formation est validé avec l'administrateur
	  FORMATION_TERMINER, // si l'etudiant est terminer une formation spécifique
	  CERTIFICAT_GENERE, // si un apprenant est terminer la formation & passé Quiz avec succés
	  CERTIFICAT_PARTAGER, // si un apprenant publié certificat dans linkedin
	  CERTIFICAT_TELECHARGER, // si un apprenant telecharger certificat format PDF
	  PAIEMENT_EFFECTUE, // Si un utilisateur fait le paiement d'une formation 
	  PAIEMENT_ECHOUE, // si administrateur n'est pas validé le paiement d"un apprenant
	  PAIEMENT_REUSSIE, // si administrateur est validé le paiement d"un apprenant
	  SESSION_CONNEXION, // si un apprenant entréer à la platforme
	  SESSION_DECONNEXION, // si un apprenant sortie de la platforme
	  
	  
}
