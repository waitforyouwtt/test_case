package com.example.demo.design.pattern;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/21 11:11
 * @Email: 15290810931@163.com
 */
public class ContextProduct {

    private StrategyAddProduct strategy;

    public ContextProduct(StrategyAddProduct strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(ProductOnline online){
        return strategy.addProductOnlineYyh(online);
    }
}
