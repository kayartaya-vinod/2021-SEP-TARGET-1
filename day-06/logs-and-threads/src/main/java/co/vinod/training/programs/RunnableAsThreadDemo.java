package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableAsThreadDemo {

    public static void main(String[] args) {



        Thread t1 = new Thread(() -> {
            for(int num=1; num<=100; num++){
                log.debug("Inside thread {} value of num is {}", Thread.currentThread().getName(), num);
            }
        });

        t1.start();

        for(int i=1; i<=10; i++){
            log.debug("Inside thread {} value of i is {}", Thread.currentThread().getName(), i);
        }
        log.debug("End of main method()");
    }
}