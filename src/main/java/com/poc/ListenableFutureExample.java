package com.poc;

import com.poc.com.poc.listenableFuture.SomeBean;
import com.poc.com.poc.listenableFuture.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ListenableFutureExample {

    public static void main(String... args)
            throws InterruptedException, ExecutionException {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        SomeBean someBean = ctx.getBean(SomeBean.class);

        System.out.println("Invoking an asynchronous method. "
                + Thread.currentThread().getName());
        Future<String> future = someBean.asyncMethodWithReturnType();

        while (true) {
            if (future.isDone()) {
                System.out.println("Result from asynchronous process - " + future.get());
                break;
            }
            System.out.println("Continue doing something else. ");
            Thread.sleep(1000);
        }
    }


}
