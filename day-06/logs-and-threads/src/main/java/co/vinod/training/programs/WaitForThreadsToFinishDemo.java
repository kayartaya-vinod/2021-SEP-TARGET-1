package co.vinod.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitForThreadsToFinishDemo {

    static void print(String msg, int limit) {
        for(int i=1; i<=limit; i++){
            log.debug("msg = {}, i = {}", msg, i);
        }
    }


    @SneakyThrows // converts checked exceptions into unchecked exceptions
    public static void main(String[] args) {
        Thread t1, t2;

        t1 = new Thread(()->print("Hello", 10));
        t2 = new Thread(()->print("Welcome", 20));

        t1.start();
        t2.start();

        print("Vinod", 3);

        t1.join(); // waits for t1 to finish executing it's run() method

        t2.join(); // waits for t2 to finish executing it's run() method

        // use this concept if you have some clean up activities to be done on some common
        // resources (such as Db connections) used by t1 and t2

        log.debug("End of main()");
    }
}
