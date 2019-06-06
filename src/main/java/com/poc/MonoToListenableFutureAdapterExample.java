package com.poc;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.MonoToListenableFutureAdapter;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

/**
 * MonoToListenableFutureAdapterExample :
 * example of the adapter pattern in the Spring framework
 */
public class MonoToListenableFutureAdapterExample {
    public static void main(String... args) throws InterruptedException, ExecutionException {
        ListenableFuture<String> listenableFuture = new MonoToListenableFutureAdapter(
                Mono.delay(Duration.ofMillis(5000))
                        .map(someLong -> "HELLO WORLD")
        );
        while (true) {
            if (listenableFuture.isDone()) {
                System.out.println("MonoToListenableFutureAdapterExample Result from asynchronous process - " + listenableFuture.get());
                break;
            }
            System.out.println("MonoToListenableFutureAdapterExample Continue doing something else. ");
            Thread.sleep(1000);
        }
    }
}
