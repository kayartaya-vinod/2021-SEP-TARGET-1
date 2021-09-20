package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo {

    static void print(int i) {
        log.debug("Inside main, value of i is {}", i);
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i=100; i<=110; i++){
                    print(i);
                }
            }
        };
        t1.start();
        // 1. instructs the scheduler to create a new stack
        // 2. scheduler creates a new stack, and puts the t1.run() function as the first function of the stack
        // 3. thread t1 goes to the "runnable" state, and only one thread will be running at any time
        // 4. t1 has to wait for its turn, and when the time comes, the current running thread changes its state
        //    to "runnable", and t1 changes the state from "runnable" to running state.
        // 5. once the run() method of t1 is completely finished, t1's state is changed to "dead"

        for (int i = 1; i <= 10; i++) {
            print(i);
        }


    }

}
