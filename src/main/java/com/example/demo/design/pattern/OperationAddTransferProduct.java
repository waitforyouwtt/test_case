package com.example.demo.design.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/21 11:08
 * @Email: 15290810931@163.com
 */
@Slf4j
public class OperationAddTransferProduct implements StrategyAddProduct {
    @Override
    public int addProductOnlineYyh(ProductOnline online) {
        log.info("添加转标品");
        return 1;
    }
}