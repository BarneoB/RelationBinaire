public class RelationBinaire {
    public boolean[][] matAdj;  // matrice d'adjacence de R
    public EE[] tabSucc;    // tableau des ensembles de successeurs
    private int n;           // n > 0, E = {0,1,2, ..., n-1}
    private int m;           // cardinal de R

    //.........................................................................
    // CONSTRUCTEURS
    //.........................................................................
    //________________________________________________________
    public RelationBinaire(int nb){
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
    }

    //________________________________________________________
    public RelationBinaire(int nb,double p){
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
        double r;
        for (int i=0;i<this.n;i++) {
            for (int j=0;j<this.n;j++){
                r=Math.random();
                if (r<=p){
                    this.matAdj[i][j]=true;
                    this.tabSucc[i].ajoutPratique(j);
                    this.m++;
                }
            }
        }
    }

    //________________________________________________________
    public RelationBinaire(int nb, boolean egal){
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
        if(egal){
            for (int i=0;i<nb ;i++ ) {
                this.matAdj[i][i]=true;
                this.tabSucc[i].ajoutPratique(i);
                this.m++;
            }
        }
        else{
            for (int i=0;i<nb ;i++ ) {
                for (int j=0;j<nb ;j++ ) {
                    if(i<=j){
                        this.matAdj[i][j]=true;
                        this.tabSucc[i].ajoutPratique(j);
                        this.m++;
                    }
                }
            }
        }
    }

    //________________________________________________________
    public RelationBinaire(boolean[][] mat){
        int nb=mat.length;
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
        for (int i=0;i<nb ;i++ ) {
            for (int j=0;j<nb ;j++ ) {
                if(mat[i][j]){
                    this.matAdj[i][j]=true;
                    this.tabSucc[i].ajoutPratique(j);
                    this.m++;
                }
            }
        }
    }

    //________________________________________________________
    public RelationBinaire(EE[] tab){
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
    public RelationBinaire(RelationBinaire r){
        this.n = r.n;
        this.m = r.m;
        int nb=this.n;
        this.matAdj=new boolean[nb][nb] ;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(r.tabSucc[i]);
        }
        for (int i=0;i<nb;i++){
            for (int j=0;j<nb;j++){
                this.matAdj[i][j]=r.matAdj[i][j];
            }
        }

    }
    //______________________________________________
    //.........................................................................
    // Méthodes
    //.........................................................................
    public String toString(){
        int nb=this.n;
        String res="";
        for (int i=0;i<nb ;i++ ) {
            res+="{";
            for (int j=0;j<nb ;j++ ) {
                if(this.matAdj[i][j]){
                    if(j==0){
                        res+="1";
                    }
                    else{
                        res+=",1";
                    }
                }
                else{
                    if(j==0){
                        res+="0";
                    }
                    else{
                        res+=",0";
                    }
                }
            }
            res+="}\n";
        }
        res+="\n{";
        boolean premier=true;
        for (int i=0;i<nb ;i++ ) {
            for (int j=0;j<nb ;j++ ){
                if(this.tabSucc[i].contient(j)){
                    if(premier)res+="(";
                    else{
                        res+=",(";
                    }
                    res+=i+","+j+")";
                    premier=false;
                }
            }
        }
        res+="}";
        return res;
    }
    //________________________________________________________

    //.........................................................................
    // A) Logique et calcul matriciel
    //.........................................................................

    //________________________________________________________
    public static boolean[][] opBool(boolean[][] m1, boolean[][] m2, int numConnecteur){
        boolean [][] MatB=new boolean[m1.length][m1.length];
        for (int i=0;i<m1.length ;i++ ) {
            for (int j=0;j<m1.length ;j++ ) {
                if(numConnecteur==1){
                    if(m1[i][j] || m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else if(numConnecteur==2){
                    if(m1[i][j] && m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else if(numConnecteur==3){
                    if(!m1[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else if(numConnecteur==4){
                    if(!m1[i][j] || m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else {
                    if(m1[i][j]==m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }

            }

        }
        return MatB;
    }
    //________________________________________________________
   public static boolean[][] produit(boolean[][] m1, boolean[][] m2) {
        boolean[][] résultat = new boolean[m1.length][m1.length];
        boolean valeur=false;
        for (int i=0;i<m1.length ;i++ ) {
            for (int j=0;j<m1.length;j++ ) {
                valeur=false;
                for (int x=0;x<m1[0].length ; x++) {
                    valeur=valeur || (m1[i][x] && m2[x][j]);
                }
                résultat[i][j]=valeur;
            }
        }
        return résultat;
    }
    //________________________________________________________
    public static boolean[][] transposee(boolean[][] m) {
        boolean[][] résultat = new boolean[m.length][m.length];
        for(int i = 0; i <= m.length-1; i ++){
            for(int j = 0; j <= m.length-1; j++){
                résultat[j][i] = m[i][j];
            }
        }
        return résultat;
    }
    //______________________________________________
    //.........................................................................
    // B) Théories des Ensembles
    //.........................................................................
    //______________________________________________
    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est vide
     */
    public boolean estVide() {
        if (this.m==0) return true;
        return false;
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est pleinee (contient tous les couples d'éléments de E)
     */
    public boolean estPleine(){
        if(this.m==this.n*this.n) return true;
        return false;
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi (x,y) appartient à this
     */
    public boolean appartient(int x, int y) {
        return this.matAdj[x][y];
    }

    //______________________________________________

    /**
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : ajoute (x,y) à this s'il n'y est pas déjà
     */
    public void ajouteCouple(int x, int y) {
        if(!this.matAdj[x][y]){
            this.matAdj[x][y] = true;
            this.tabSucc[x].ajoutElt(y);
            this.m++;
        }
    }

    //______________________________________________

    /**
     * pré-requis : 0 <= x < this.n et 0 <= y < this.n
     * résultat : enlève (x,y) de this s'il y est
     */
    public void enleveCouple(int x, int y) {
        if(this.matAdj[x][y]){
            this.matAdj[x][y] = false;
            this.tabSucc[x].retraitElt(y);
            this.m--;
        }
    }
    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : une nouvelle relation binaire obtenue à partir de this en ajoutant
     * les couples de la forme  (x,x) qui n'y sont pas déjà
     */
    public RelationBinaire avecBoucles(){
        RelationBinaire Boucles = new RelationBinaire(this);
        for (int i=0;i<this.n ;i++ ) {
            if(!this.matAdj[i][i]){
                Boucles.ajouteCouple(i,i);
            }
        }
        return Boucles;
    }
    public RelationBinaire avecBouclesBis(){
        return new RelationBinaire(opBool(new RelationBinaire(this.n,true).matAdj,this.matAdj,1));
    }
    //______________________________________________


    /** pré-requis : aucun
     résultat : une nouvelle relation binaire obtenue à partir de this en enlèvant
     les couples de la forme  (x,x) qui y sont
     //DERNIERE MODIF
     */
    public RelationBinaire sansBoucles(){
        RelationBinaire Boucles = new RelationBinaire(this);
        for (int i=0;i<this.n ;i++ ) {
            if(this.matAdj[i][i]){
                Boucles.enleveCouple(i,i);
            }
        }
        return Boucles;
    }
    public RelationBinaire sansBouclesBis(){
        return new RelationBinaire(opBool(opBool(this.matAdj,new RelationBinaire(this.n,true).matAdj, 4),this.matAdj,3));
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : l'union de this et r
     */
    public RelationBinaire union(RelationBinaire r){
        return new RelationBinaire(opBool(this.matAdj,r.matAdj,1));
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : l'intersection de this et r
     */
    public RelationBinaire intersection(RelationBinaire r) {
       return new RelationBinaire(opBool(this.matAdj,r.matAdj, 2));
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : la relation complémentaire de this
     */
    public RelationBinaire complementaire(){
        return new RelationBinaire(opBool(this.matAdj,new RelationBinaire(this.n).matAdj,3));
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : la différence de this et r
     */
    public RelationBinaire difference(RelationBinaire r){
        boolean[][] mat1 = new boolean[this.n][this.n];
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                if (this.matAdj[i][j] && !r.matAdj[i][j]) {
                    mat1[i][j] = true;
                }
            }
        }
        return new RelationBinaire(mat1);
    }
    public RelationBinaire differenceBis(RelationBinaire r){
        return this.intersection(r).complementaire().intersection(this);
    }

    //______________________________________________

    /**
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est incluse dans r
     */
    public boolean estIncluse(RelationBinaire r) {
        return new RelationBinaire(opBool(this.matAdj,r.matAdj, 4)).estPleine();
    }

    //______________________________________________


    // C) Théorie des graphes orientés
    //---------------------------------

    /**
     * pré-requis : this.n = r.n
     * résultat : vrai ssi this est égale à r
     */
    public boolean estEgale(RelationBinaire r) {
        return new RelationBinaire(opBool(this.matAdj,r.matAdj, 5)).estPleine();
    }

    //______________________________________________

    /**
     * pré-requis : 0 <= x < this.n
     * résultat : l'ensemble des successeurs de x dans this, "indépendant"
     * (c'est-à-dire dans une autre zône mémoire) de l'attribut this.tabSucc
     */
    public EE succ(int x){
        return new EE(this.tabSucc[x]);
    }

    //______________________________________________


    /** pré-requis : 0 <= x < this.n
     résultat : l'ensemble des prédécesseurs de x dans this
     */
    public EE pred(int x){
        EE newE=new EE(this.n);
        for (int i=0;i<this.n ;i++ ) {
            if(this.tabSucc[i].contient(x))newE.ajoutElt(i);
        }
        return newE;
    }
    public EE predBis(int x){
        return new RelationBinaire(transposee(this.matAdj)).succ(x);
    }

    //______________________________________________


    // D) Relation binaire
    //---------------------
    
    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est réflexive
     */
    public boolean estReflexive() {
        boolean Reflexive=true;
        int i = 0;
        while (i< this.n && Reflexive){
            if (!matAdj[i][i]){
                Reflexive = false;
            }
            i++;
        }
        return Reflexive;
    }
    public boolean estReflexiveBis(){
        return this.estEgale(this.avecBoucles());
    }
    //______________________________________________


    /** pré-requis : aucun
     résultat : vrai ssi this est antiréflexive
     */
    public boolean estAntireflexive() {
        boolean AReflexive=true;
        int i = 0;
        while (i< this.n && AReflexive){
            if (matAdj[i][i]){
                AReflexive = false;
            }
            i++;
        }
        return AReflexive;
    }
    public boolean estAntireflexiveBis(){
        return this.estEgale(this.sansBoucles());
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est symétrique
     */
    public boolean estSymetrique() {
        boolean Symetrique = true;
        int i = 0;
        int j = 0;
        while (i< this.n && Symetrique){
            while(j< this.n && Symetrique){
                if (this.matAdj[i][j] != this.matAdj[j][i]){
                    Symetrique = false;
                }
                j++;
            }
            i++;
        }
        return Symetrique;
    }
   public boolean estSymetriqueBis() {
        return new RelationBinaire(transposee(this.matAdj)).estEgale(this);
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est antisymétrique
     */
    public boolean estAntisymetrique() {
        boolean ASymetrique = true;
        int i = 0;
        int j = 0;
        while (i< this.n && ASymetrique){
            while(j< this.n && ASymetrique){
                if (this.matAdj[i][j] && this.matAdj[j][i]){
                    ASymetrique = false;
                }
                j++;
            }
            i++;
        }
        return ASymetrique;
    }
    public boolean estAntisymetriqueBis() {
        return new RelationBinaire(opBool(this.matAdj,transposee(this.sansBoucles().matAdj), 2)).estVide();
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est transitive
     */
    public boolean estTransitive() {
        boolean trans=true;
        int i=0;
        EE s;
        while(i<this.n && trans){
            s=this.succ(i);
            int x=0;
            while(x<this.n && trans) {
                if(s.contient(x)){
                    if(!tabSucc[x].estInclus(s)){
                        trans=false;
                    }
                }
                x++;
            }
            i++;
        }
        return trans;
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi this est une relation d'ordre
     */
    public boolean estRelOrdre() {
        return this.estTransitive() && this.estAntisymetrique() && this.estReflexive();
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
        RelationBinaire trans=new RelationBinaire(this);
        EE s;
        EE s2;
        for (int i=0;i<trans.n ;i++ ) {
            for (int x=0;x<trans.n ;x++ ) {
                s=trans.succ(i);
                if(s.contient(x)){
                    s2=trans.succ(x);
                    for (int j=0;j<trans.n ;j++ ) {
                        if(s2.contient(j) && !s.contient(j)){
                            s.ajoutElt(j);
                            trans.tabSucc[i].ajoutElt(j);
                            trans.m++;
                            trans.matAdj[i][j]=true;
                        }
                    }
                }
            }
        }
        return trans;
        
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
} // fin RelationBinaire
