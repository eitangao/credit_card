package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.dao.ShoppingCartMapper;
import com.xmx.credit_card.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
}
