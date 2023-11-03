package ui;
import thread.CounterThread;
import java.util.Scanner;
import model.Timer;
import model.Counter;
 
public class InteractiveMain {

    public InteractiveMain() {
    }

    public static void main(String[] args) {
        InteractiveMain m1 = new InteractiveMain();
        m1.execute();
    }

    public void execute(){

        int number = 0;
        Timer timer = new Timer();
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Ingrese un numero mayor a 0 y menor a 100 para los hilos que desea usar");
            number = sc.nextInt();
        }while(number<=0 || number>100);

        CounterThread counterThread[] = new CounterThread[number];
        int amount=100/number;//Aqui lo reduce a entero piso de forma automatica

        for (int i = 0; i < counterThread.length; i++) {
            if(i==counterThread.length-1){
                //Aqui en caso que que 100 no es divisible entre 100, el ultimo hilo se encarga de los restantes
                Counter counter = new Counter(amount*i+1, 100);
                counterThread[i] = new CounterThread(counter, 0);

            }else{
                Counter counter = new Counter(amount*i+1, amount*i+amount);
                counterThread[i] = new CounterThread(counter, 0);
            }
        }
        timer.start();
        for (int i = 0; i < counterThread.length; i++) {
            counterThread[i].start();
        }
        for (int i = 0; i < counterThread.length; i++) {
            try {
                counterThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time: "+timer.stop()+" ms");
        //Lo utilizo solo para que no trabaje más hilos de los necesarios
        //con el sistema inactivo
        for(int i = 0; i < counterThread.length; i++) {
            counterThread[i].interrupt();
        }
    }




}
