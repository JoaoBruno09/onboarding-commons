package com.bank.onboarding.commonslib.utils;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncExecutor {
    void execute(List<CompletableFuture<?>> cfs);
}
