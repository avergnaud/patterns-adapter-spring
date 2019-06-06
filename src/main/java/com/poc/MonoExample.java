package com.poc;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class MonoExample {
    public static void main(String... args) {
        /* MonoExample */
        reactor.core.publisher.Mono.just(1)
                .map(integer -> "foo" + integer)
                .or(reactor.core.publisher.Mono.delay(Duration.ofMillis(100))
                        .map(someLong -> "" + someLong))
                .subscribe(System.out::println);
    }
}
