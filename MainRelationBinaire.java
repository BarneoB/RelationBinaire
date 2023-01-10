import java.util.*;
import java.lang.*;
public class MainRelationBinaire{
    public static void main(String[] args){
        RelationBinaire r1, r2, r3, r4, r5, r6, r7, r8;
        r1=new RelationBinaire(2); //RelationBinaire avec nb
        r2=new RelationBinaire(3,0.67); //RelationBinaire(int nb,double p)
        boolean[][] mat={{false,true,true},{false,false,false},{true,true,true}};
        boolean[][] mat2 = {{true,true,true},{false,true,false},{true,true,true}};
        r3=new RelationBinaire(mat); //RelationBinaire(boolean[][] mat)
        r4=new RelationBinaire(4,false); //RelationBinaire(int nb, boolean egal
        r5 = new RelationBinaire(mat2);
        System.out.println("r3= \n" + r3 + "\n");
        System.out.println("r5= \n"+ r5);
        boolean[][] résultat = RelationBinaire.produit(mat,mat2);
        r6 = new RelationBinaire(résultat);
        System.out.println("r6= \n"+ r6);
        boolean[][] résultat2 = RelationBinaire.transposee(RelationBinaire.produit(mat,mat2));
        r7 = new RelationBinaire(résultat2);
        System.out.println("r7= \n" + r7);
        RelationBinaire rvide = new RelationBinaire(0);
        System.out.println(rvide.estVide());
        System.out.println(r2.estVide());
    }
}
