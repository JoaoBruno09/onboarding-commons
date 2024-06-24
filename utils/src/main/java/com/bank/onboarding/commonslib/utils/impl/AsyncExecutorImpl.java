package com.bank.onboarding.commonslib.utils.impl;

import com.bank.onboarding.commonslib.utils.AsyncExecutor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExecutorImpl implements AsyncExecutor {
    @Override
    public void execute(List<CompletableFuture<?>> cfs) {
        try {
            CompletableFuture.allOf((CompletableFuture<?>) cfs).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
