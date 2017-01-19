package com.mall.service.impl;

import com.mall.mapper.TShoppingCartMapper;
import com.mall.model.ShoppingCart;
import com.mall.model.TShoppingCart;
import com.mall.model.TShoppingCartExample;
import com.mall.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 16/01/2017.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    TShoppingCartMapper shoppingCartMapper;

    @Override
    public void createShoppingCart(TShoppingCart shoppingCart) {
        shoppingCartMapper.insert(shoppingCart);
    }

    @Override
    public TShoppingCart selectHasAdd(TShoppingCart shoppingCart) {
        TShoppingCartExample example = new TShoppingCartExample();
        TShoppingCartExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(shoppingCart.getUserId());
        criteria.andItemIdEqualTo(shoppingCart.getItemId());
        criteria.andDetailIdEqualTo(shoppingCart.getDetailId());

        List<TShoppingCart> list = shoppingCartMapper.selectByExample(example);

        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public void updateShppingCart(TShoppingCart shoppingCart) {
        shoppingCartMapper.updateByPrimaryKey(shoppingCart);
    }

    @Override
    public void removeShoppingCart(int shoppingCartId) {

        shoppingCartMapper.deleteByPrimaryKey(shoppingCartId);
    }

    @Override
    public List<TShoppingCart> selectShoppingCartByUser(int corpId, int userId) {
        TShoppingCartExample example = new TShoppingCartExample();
        TShoppingCartExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);
        criteria.andUserIdEqualTo(userId);

        return shoppingCartMapper.selectByExample(example);
    }

    @Override
    public void updateShoppingCartQuantily(int shoppingCartId, int quantity) {
        TShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartId);
        shoppingCart.setQuantity(quantity);

        shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
    }

    @Override
    public List<TShoppingCart> selectShoppingCarts(List<Integer> shoppingCartIdList) {
        TShoppingCartExample example = new TShoppingCartExample();
        TShoppingCartExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(shoppingCartIdList);

        return shoppingCartMapper.selectByExample(example);
    }

    @Override
    public void removeShoppingCarts(List<Integer> shoppingCartIdList) {
        TShoppingCartExample example = new TShoppingCartExample();
        TShoppingCartExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(shoppingCartIdList);

        shoppingCartMapper.deleteByExample(example);
    }
}
