package com.mall.service;

import com.mall.model.TAddress;

import java.util.List;

/**
 * Created by Supeng on 18/01/2017.
 */
public interface AddressService {

    void createAddress(TAddress address);

    void removeAddress(int addressId);

    void updateAddress(TAddress address);

    List<TAddress> selectActiveAddress(int userId);
}
