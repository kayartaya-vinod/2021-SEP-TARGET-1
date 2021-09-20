package co.vinod.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class DaemonThreadDemo {

    @SneakyThrows
    static void delay(long duration){
        Thread.sleep(duration);
    }

    static void startThread(){
        Runnable r = ()->{
            while(true){
                log.debug("Now the time is {}", new Date().toString());
                delay(1000);
            }
        };

        Thread t1 = new Thread(r);
        t1.setDaemon(true); // automatically killed when all other non-daemon threads are killed
        t1.start();
    }

    public static void main(String[] args) {

        startThread();

        for(int i=1; i<=100; i++){
            log.debug("Inside main(), value of i is {}", i);
            delay(500);
        }

        log.debug("End of main()");
    }
}
