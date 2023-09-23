/*Equipo 
Bryan Alberto Flores Garcia 1866566 ITS
Jesús Manuel Galván Martínez 1879769 ITS
Andrés Alejandro Chávez Vázquez 1956300 ITS
Francisco Javier Chavez Cavazos 1866159 IAS
*/
import java.util.Scanner;
public class cadenas_markov{
    public static void main(String[] args) {
        Scanner lec=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estados: ");
        int n=lec.nextInt();
        System.out.println("Nota: la probabilidad debe de ser de 0 a 1");
        float suma=0;
        int i;
        float[][] matriz = new float[n][n];
        for (i=0;i<n;i++){
            for(int j=0;j<n;j++){
                do{
                    System.out.println("Ingrese probabilidad del estado "+ i +" al estado "+j);
                    matriz[i][j]=lec.nextFloat();
                    if(matriz[i][j]<0 || matriz[i][j]>1){
                        System.out.println("Error, la probabilidad entre estados debe de ser de 0 a 1");
                    }
                }while(matriz[i][j]<0 || matriz[i][j]>1);
                suma=suma+matriz[i][j];
            }
            if(suma!=1){
                i=n;
            }
            else{
                suma=0;
            }
        }
        if(i==n+1){
            System.out.println("Error, la suma de las filas no puede ser diferente a 1: ");
        }
        else{
            float[]estado_inicial = new float[n];
            for(int a=0;a<n;a++)
            {   
                System.out.print("Ingresa el valor del estado inicial "+a+": ");
                estado_inicial[a]=lec.nextFloat();
            }
            System.out.println("\nMatriz de probabilidad (transision)");
            for (i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print("\t"+matriz[i][j]);                
                }
                System.out.print("\n");
            }
            System.out.println("\nEstados iniciales");
            for(int a=0;a<n;a++)
            {   
                System.out.print("\t"+estado_inicial[a]);
            }
            float[]nuevo_estado = new float[n];
            float[][]nueva_matriz = new float[n][n];
            suma=0;
            float multiplicacion;
            for(i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int a=0;a<n;a++){
                        if(a==i){
                            multiplicacion=matriz[j][a]*estado_inicial[j];
                            suma=suma+multiplicacion;
                        }
                    }
                }
                nuevo_estado[i]=suma;
                suma=0;
            }
            System.out.println("\n\n\nNuevos estado");
            for(i=0;i<n;i++){
                System.out.print("\t"+nuevo_estado[i]);
            }
            for (int a=0;a<n;a++){
                for(i=0;i<n;i++)
                {
                    suma=0;
                    for(int j=0;j<n;j++)
                    {
                        multiplicacion=matriz[i][j]*matriz[j][a];
                        suma=suma+multiplicacion;
                    }
                    nueva_matriz[i][a]=suma;
                }
            }
            
            System.out.println("\n\nNueva matriz de probabilidad");
            for(i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print("\t"+nueva_matriz[i][j]);
                }
                System.out.print("\n");
            }
        }

    }
}
