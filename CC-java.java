class Compte {
    private double solde;
    private double tauxInteret;

    public Compte(double solde, double tauxInteret) {
        this.solde = solde;
        this.tauxInteret = tauxInteret;
    }

    public double calculerNouveauSolde() {
        double interets = solde * tauxInteret;
        return solde + interets;
    }

    public double getSolde() {
        return solde;
    }
}

class Client {
    private String nom;
    private String ville;
    private Compte comptePrive;
    private Compte compteEpargne;

    public Client(String nom, String ville, double soldePrive, double soldeEpargne,
     double tauxInteretPrive, double tauxInteretEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.comptePrive = new Compte(soldePrive, tauxInteretPrive);
        this.compteEpargne = new Compte(soldeEpargne, tauxInteretEpargne);
    }

    public void afficherInformations() {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("Compte privé: " + comptePrive.getSolde() + " francs");
        System.out.println("Compte d'épargne: " + compteEpargne.getSolde() + " francs");
    }

    public void mettreAJourSoldes() {
        double nouveauSoldePrive = comptePrive.calculerNouveauSolde();
        double nouveauSoldeEpargne = compteEpargne.calculerNouveauSolde();
        comptePrive.solde = nouveauSoldePrive;
        compteEpargne.solde = nouveauSoldeEpargne;
    }
}

public class Banque {
    public static void main(String[] args) {
        Client client1 = new Client("Pedro", "Geneve", 1000.0, 2000.0, 0.01, 0.02);
        Client client2 = new Client("Alexandra", "Lausanne", 3000.0, 4000.0, 0.01, 0.02);

        client1.afficherInformations();
        client2.afficherInformations();

        client1.mettreAJourSoldes();
        client2.mettreAJourSoldes();

        client1.afficherInformations();
        client2.afficherInformations();
    }
}