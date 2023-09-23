/*Equipo 
Bryan Alberto Flores Garcia 1866566 ITS
Jesús Manuel Galván Martínez 1879769 ITS
Andrés Alejandro Chávez Vázquez 1956300 ITS
Francisco Javier Chavez Cavazos 1866159 IAS
*/
import java.util.Scanner;
public class sistemafilas{
    public static void main(String[] args) {
        Scanner lec=new Scanner(System.in);
        double p,ls,lq,ws,wq,pn,pl,pws,pwk,n;
        double tasallegada,tasaservicio;
        double e=2.71828182845904523536;
        int t;
        int op;
        System.out.println ("Menu de opciones");
        System.out.println("1. Modelo M/M/1: ");
        System.out.println("2. Modelo M/G/1 (dato requerido: desviacion estandar)");
        System.out.println("3. Modelo M/D/1");
        System.out.println("4. M/E/1 (se requiere el valor de k)");
        System.out.println("Nota: todos los casos requieren tasa media de servicio y tasa media de llegada");
        System.out.print("Elije una opcion: ");
        int opcion=lec.nextInt();
        if(opcion>=1 && opcion<=4){
            System.out.print("Ingresa la tasa de llegada: ");
            tasallegada=lec.nextDouble();
            System.out.print("Ingresa la tasa de servicio: ");
            tasaservicio=lec.nextDouble();
            switch(opcion){
                case 1:
                    p=tasallegada/tasaservicio;
                    if(p<1){
                        ls=tasallegada/(tasallegada-tasaservicio);
                        if(ls<=0)
                        {
                            ls=0;
                        }
                        lq=(Math.pow(tasallegada,2))/(tasaservicio*(tasaservicio-tasallegada));
                        ws=1/(tasaservicio-tasallegada);
                        wq=tasallegada/(tasaservicio*(tasaservicio-tasallegada));
                        System.out.println("Ls="+ls);
                        System.out.println("Lq="+lq);
                        System.out.println("Ws="+ws);
                        System.out.println("Wq="+wq);
                        System.out.println("p="+p);
                        System.out.println("Desea calcular las probabilidades para cierto numero en la fila? (1=si, 2=no)") ;
                        op=lec.nextInt();
                        if(op==1){
                            System.out.println("Ingresa el valor de n: ");
                            n=lec.nextDouble();
                            pn=(1-p)*(Math.pow(p, n));
                            pl=Math.pow(p, n+1);
                            System.out.println("Pn= "+pn);
                            if(ls>n){
                                System.out.println("P(Ls>n)= "+pl);
                            }
                            System.out.print("Desea calcular las probabidades de cierto tiempo especifico (1=si, 2=no): ");
                            op=lec.nextInt();
                            if(op==1)
                            {
                                System.out.println("Ingresa t: ");
                                t=lec.nextInt();
                                if(t>=0)
                                {
                                    if(ws>t){
                                        pws=Math.pow(e,-tasaservicio*(1-p)*t);
                                        System.out.println("P(Ws>t)= "+pws);
                                    }
                                    if(wq>t)
                                    {
                                        pwk=p*(Math.pow(e,-tasaservicio*(1-p)*t));
                                        System.out.print("P(Wq>t)= "+pwk);
                                    }

                                }
                                else{
                                    System.out.println("t no puede ser menor que 0");
                                }
                            }
                        }
                        
                    }
                    else{
                        System.out.println("El factor de utilizacion del sistema no puede ser mayor a 1");
                    }
                break;
                
                case 2:
                    System.out.println("Ingresa el valor de desviacion estandar: ");
                    double des_est=lec.nextDouble();
                    p=tasallegada/tasaservicio;
                    if(p<1)
                    {
                        lq=(((Math.pow(tasallegada, 2)*Math.pow(des_est,2))+Math.pow(p, 2)))/(2*(1-p));
                        ls=lq+p;
                        wq=lq/tasallegada;
                        ws=wq+(1/tasaservicio);
                        double p0=1-p;
                        System.out.println("Ls= "+ls);
                        System.out.println("Lq= "+lq);
                        System.out.println("Ws= "+ws);
                        System.out.println("Wq= "+wq);
                        System.out.println("P0= "+p0);
                        System.out.println("Pw= "+p);
                        System.out.println("p="+p);

                    }else{
                        System.out.println("Se requiere que el factor de utilizacion del sistema sea menor a 1");   
                    }
                break;
                case 3:
                    p=tasallegada/tasaservicio;
                    if(p<1){
                        lq=(Math.pow(p, 2))/(2*(1-p));
                        wq=lq/tasallegada;
                        ws=wq+(1/tasaservicio);
                        ls=tasallegada*ws;
                        System.out.println("Lq= "+lq);
                        System.out.println("Ls= "+ls);
                        System.out.println("Wq= "+wq);
                        System.out.println("Ws= "+ws);
                        System.out.println("p="+p);
                    }else{
                        System.out.println("Se requiere que el factor de utilizacion del sistema sea menor a 1");   
                    }
                break;
                case 4:
                    System.out.println("Ingresa el valor de K: ");
                    double k=lec.nextDouble();
                    p=tasallegada/tasaservicio;
                    if(p<1){
                        lq=((Math.pow(p, 2))*(k+1))/(2*k*(1-p));
                        wq=lq/tasallegada;
                        ws=wq+(1/tasaservicio);
                        ls=tasallegada*ws;
                        System.out.println("Ls= "+ls);
                        System.out.println("Lq= "+lq);
                        System.out.println("Ws= "+ws);
                        System.out.println("Wq= "+lq);
                        System.out.println("p= "+p);
                    }else{
                        System.out.println("Se requiere que el factor de utilizacion del sistema sea menor a 1");   
                    }
            }
        }
        else{
            System.out.println("Opcion no valida");
        }   
    }
}
