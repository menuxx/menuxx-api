package com.mall.service;

import com.mall.model.TShoppingCart;

import java.util.List;

/**
 * Created by Supeng on 16/01/2017.
 */
public interface ShoppingCartService {

    void createShoppingCart(TShoppingCart shoppingCart);

    TShoppingCart selectHasAdd(TShoppingCart shoppingCart);

    void updateShppingCart(TShoppingCart shoppingCart);

    void removeShoppingCart(int shoppingCartId);

    List<TShoppingCart> selectShoppingCartByUser(int corpId, int userId);

    void updateShoppingCartQuantily(int shoppingCartId, int quantity);

    List<TShoppingCart> selectShoppingCarts(List<Integer> shoppingCartIdList);

    void removeShoppingCarts(List<Integer> shoppingCartIdList);
}
