import java.util.*;
import java.lang.*;
public class MainRelationBinaire{
    public static void main(String[] args){
        RelationBinaire r1, r2, r3, r4, r5, r6, r7, r8;
        r1=new RelationBinaire(2); //RelationBinaire avec nb
        r2=new RelationBinaire(3,0.67); //RelationBinaire(int nb,double p)
        boolean[][] mat={{false,true,true},{false,false,false},{true,true,true}};
        r3=new RelationBinaire(mat); //RelationBinaire(boolean[][] mat)
        r4=new RelationBinaire(4,false); //RelationBinaire(int nb, boolean egal)
        for (int i=0; i<r3.tabSucc.length ; i++ ){
            System.out.println(r3.tabSucc[i]);
            for (int j=0;j<r3.tabSucc.length ; j++) {
                System.out.println(r3.matAdj[i][j]);
            }
        }
        System.out.println("\n");
        System.out.println("r1 = ");
        System.out.println(r1);
    }
}
