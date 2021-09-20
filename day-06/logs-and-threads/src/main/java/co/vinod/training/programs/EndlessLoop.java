package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class EndlessLoop {
    static void print(String msg){
        log.debug(msg);
    }
    public static void main(String[] args) {
        for(;;){
            print("Loop going on forever - current time is " + new Date());
        }
    }
}
