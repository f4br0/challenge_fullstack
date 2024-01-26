package com.reto.domain;

public interface UseCase<I, O> {
    O execute(I request);
}
