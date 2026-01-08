package com.bank.onboarding.commonslib.utils.impl;

import com.bank.onboarding.commonslib.utils.AsyncExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class AsyncExecutorImpl implements AsyncExecutor {
    @Override
    public void execute(List<CompletableFuture<?>> cfs) {
        try {
            CompletableFuture.allOf(cfs.toArray(new CompletableFuture[0])).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
