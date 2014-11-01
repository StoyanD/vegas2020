package com.coiniverse.api;

/**
 * Created by stoyan on 9/16/14.
 */
public interface DatabaseInterface<T extends AbstractModel> {


    public void updateApiModel(T mealApi);
}
