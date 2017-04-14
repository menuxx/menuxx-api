package com.mall.service;

import com.mall.model.TAddress;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/04/2017.
 */
public interface AddressService {

    void createAddress(TAddress address);

    void updateAddress(TAddress address);

    void removeAddress(int addressId);

    List<TAddress> selectAddressByUser(int userId);

    List<TAddress> selectAddress(List<Integer> addressIdList);

    Map<Integer, TAddress> selectAddressForMap(List<Integer> addressIdList);

    TAddress selectAddress(int addressId);
}
