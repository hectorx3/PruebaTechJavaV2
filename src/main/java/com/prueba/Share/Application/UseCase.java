package com.prueba.Share.Application;

public interface UseCase<I, O> {
    public O execute(I command);
}
