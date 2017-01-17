package com.mall.wrapper;

import com.mall.model.ShoppingCart;

import java.util.List;

/**
 * Created by Supeng on 16/01/2017.
 */
public interface ShoppingCartWrapper {

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCart> getShoppingCart(int corpId, int userId);
}
