public class RelationBinaire {
    public boolean[][] matAdj;  // matrice d'adjacence de R
    public EE[] tabSucc;    // tableau des ensembles de successeurs
    private int n;           // n > 0, E = {0,1,2, ..., n-1}
    private int m;           // cardinal de R

    //.........................................................................
    // CONSTRUCTEURS
    //.........................................................................
    //________________________________________________________
    //Réalisé par Lucas
    public RelationBinaire(int nb) {
        this.n = nb;
        this.matAdj = new boolean[nb][nb];
        this.m = 0;
        this.tabSucc = new EE[nb];
        for (int i = 0; i < nb; i++) {
            this.tabSucc[i] = new EE(nb);
        }
    }

    //________________________________________________________
    //Réalisé par Lucas
    public RelationBinaire(int nb, double p) {
        this.n = nb;
        this.matAdj = new boolean[nb][nb];
        this.m = 0;
        this.tabSucc = new EE[nb];
        for (int i = 0; i < nb; i++) {
            this.tabSucc[i] = new EE(nb);
        }
        double r;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                r = Math.random();
                if (r <= p) {
                    this.matAdj[i][j] = true;
                    this.tabSucc[i].ajoutPratique(j);
                }
            }
        }
    }

    //________________________________________________________
    //Réalisé par Lucas
    public RelationBinaire(int nb, boolean egal) {
        this.n = nb;
        this.matAdj = new boolean[nb][nb];
        this.m = 0;
        this.tabSucc = new EE[nb];
        for (int i = 0; i < nb; i++) {
            this.tabSucc[i] = new EE(nb);
        }
        if (egal) {
            for (int i = 0; i < nb; i++) {
                this.matAdj[i][i] = true;
                this.tabSucc[i].ajoutPratique(i);
            }
        } else {
            for (int i = 0; i < nb; i++) {
                for (int j = 0; j < nb; j++) {
                    if (i <= j) {
                        this.matAdj[i][j] = true;
                        this.tabSucc[i].ajoutPratique(j);
                    }
                }
            }
        }
    }

    //________________________________________________________
    //Réalisé par Lucas
    public RelationBinaire(boolean[][] mat) {
        int nb = mat.length;
        this.n = nb;
        this.matAdj = new boolean[nb][nb];
        this.m = 0;
        this.tabSucc = new EE[nb];
        for (int i = 0; i < nb; i++) {
            this.tabSucc[i] = new EE(nb);
        }
        for (int i = 0; i < nb; i++) {
            for (int j = 0; j < nb; j++) {
                if (mat[i][j]) {
                    this.matAdj[i][j] = true;
                    this.tabSucc[i].ajoutPratique(j);
                }
            }
        }
    }

    //________________________________________________________
    //Réalisé par Bryan
    public RelationBinaire(EE[] tab) {
        this(tab.length);
        int compteur = this.n;
        for (int i = 0; i < compteur; i++) {
            for (int j = 0; j < compteur; j++) {
                if (tab[i].contient(j)) {
                    this.matAdj[i][j] = true;
                    this.tabSucc[i].ajoutPratique(j);
                    this.m++;
                }
            }
        }
    }
    //________________________________________________________
    //Réalisé par Bryan
    public RelationBinaire(RelationBinaire r) {
        this.n = r.n;
        int compteur = this.n;
        this.m = r.m;
        this.matAdj = r.matAdj;
        for (int i = 0; i < compteur; i++) {
            for (int j = 0; j < compteur; j++) {
                this.tabSucc = r.tabSucc;
            }
        }
    }
    //______________________________________________
    //.........................................................................
    // Méthodes
    //.........................................................................

    //________________________________________________________
    public static boolean[][] opBool(boolean[][] m1, boolean[][] m2, int numConnecteur) {
        boolean[][] MatB = new boolean[m1.length][m1.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                if (numConnecteur == 1) {
                    if (m1[i][j] || m2[i][j]){
                        MatB[i][j] = true;
                    }
                    else{
                        MatB[i][j] = false;
                    }
                } else if (numConnecteur == 2) {
                    if (m1[i][j] && m2[i][j]) {
                        MatB[i][j] = true;
                    }
                    else{
                        MatB[i][j] = false;
                    }
                } else if (numConnecteur == 3) {
                    if (m1[i][j]){
                        MatB[i][j] = true;
                    }
                    else{
                        MatB[i][j] = false;
                    }
                } else if (numConnecteur == 4) {
                    if (!m1[i][j] || m2[i][j]){
                        MatB[i][j] = true;
                    }
                    else{
                        MatB[i][j] = false;
                    }
                } else {
                    if (m1[i][j] == m2[i][j]){
                        MatB[i][j] = true;
                    }
                    else{
                        MatB[i][j] = false;
                    }
                }

            }

        }
        return MatB;
    }
    //________________________________________________________

    //.........................................................................
    // A) Logique et calcul matriciel
    //.........................................................................

    /**
     * pré-requis : m1 et m2 sont des matrices carrées de même dimension
     * résultat : le produit matriciel de m1 et m2
     */
   public static boolean[][] produit(boolean[][] m1, boolean[][] m2) {
       boolean[][] résultat = new boolean[m1.length][m1.length];
       for(int i = 0; i >= m1.length; i ++){
           for(int j = 0; j >= m1.length; j++){
               if (m1[i][j] == true && m2[i][j] == true){
                   résultat[i][j] = true;
               }
           }
       }
    }
    //________________________________________________________

    /**
     * pré-requis : m est une matrice carrée
     * résultat : la matrice transposée de m
     */
    public static boolean[][] transposee(boolean[][] m) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
        //inverse lignes et les colonnes
    }

    //______________________________________________

    public static void main(String[] args) {

        int nb;
        double p;
        do {
            Ut.afficher("\nDonner le cardinal de E (>0) : ");
            nb = Ut.saisirEntier();
        }
        while (nb <= 0);
    }

    //______________________________________________


    // B) Théorie des ensembles
    //--------------------------

    //Réalisé par Lucas
    public String toString() {
        int nb = this.n;
        String res = "";
        for (int i = 0; i < nb; i++) {
            res += "{";
            for (int j = 0; j < nb; j++) {
                if (this.matAdj[i][j]) {
                    if (j == 0) {
                        res += "1";
                    } else {
                        res += ",1";
                    }
                } else {
                    if (j == 0) {
                        res += "0";
                    } else {
                        res += ",0";
                    }
                }
            }
            res += "}\n";
        }
        res += "\n{";
        boolean premier = true;
        for (int i = 0; i < nb; i++) {
            for (int j = 0; j < nb; j++) {
                if (this.tabSucc[i].contient(j)) {
                    if (premier) res += "(";
                    else {
                        res += ",(";
                    }
                    res += i + "," + j + ")";
                    premier = false;
                }
            }
        }
        res += "}";
        return res;
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est vide
     */
    public boolean estVide() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est pleinee (contient tous les couples d'éléments de E)
     */
    public boolean estPleine() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi (x,y) appartient à this
     */
    public boolean appartient(int x, int y) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : ajoute (x,y) à this s'il n'y est pas déjà
     */
    public void ajouteCouple(int x, int y) {

    }

    //______________________________________________

    /**
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : enlève (x,y) de this s'il y est
     */
    public void enleveCouple(int x, int y) {

    }
    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : une nouvelle relation binaire obtenue à partir de this en ajoutant
     * les couples de la forme  (x,x) qui n'y sont pas déjà
     */
    public RelationBinaire avecBoucles() {

        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : une nouvelle relation binaire obtenue à partir de this en enlèvant
     * les couples de la forme  (x,x) qui y sont
     * //DERNIERE MODIF
     */
    public RelationBinaire sansBoucles() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : l'union de this et r
     */
    public RelationBinaire union(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : l'intersection de this et r
     */
    public RelationBinaire intersection(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : la relation complémentaire de this
     */
    public RelationBinaire complementaire() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : la différence de this et r
     */
    public RelationBinaire difference(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");

    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est incluse dans r
     */
    public boolean estIncluse(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________


    // C) Théorie des graphes orientés
    //---------------------------------

    /**
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est égale à r
     */
    public boolean estEgale(RelationBinaire r) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : 0 <= x < this.n
     * résultat : l'ensemble des successeurs de x dans this, "indépendant"
     * (c'est-à-dire dans une autre zône mémoire) de l'attribut this.tabSucc
     */
    public EE succ(int x) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________


    // D) Relation binaire
    //---------------------

    /**
     * pré-requis : 0 <= x < this.n
     * résultat : l'ensemble des prédécesseurs de x dans this
     */
    public EE pred(int x) {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est réflexive
     */
    public boolean estReflexive() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est antiréflexive
     */
    public boolean estAntireflexive() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est symétrique
     */
    public boolean estSymetrique() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est antisymétrique
     */
    public boolean estAntisymetrique() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est transitive
     */
    public boolean estTransitive() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est une relation d'ordre
     */
    public boolean estRelOrdre() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : la relation binaire assiciée au diagramme de Hasse de this
     */
    public RelationBinaire hasse() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : la fermeture transitive de this
     */
    public RelationBinaire ferTrans() {
        throw new RuntimeException("La fonction n'est pas encore implémentée !");
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * action : affiche this sous 2 formes (matrice et ensemble de couples), puis affiche ses propriétés
     * (réflexive, ..., relation d'ordre) et les relations binaires suivantes obtenues à partir de this :
     * Hasse, fermeture transitive de Hasse et fermeture transitive de Hasse avec boucles (sous 2 formes aussi)
     */
    public void afficheDivers() {

    }
} // fin RelationBinaire
