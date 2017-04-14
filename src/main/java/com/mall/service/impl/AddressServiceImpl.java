package com.mall.service.impl;

import com.mall.mapper.TAddressMapper;
import com.mall.model.TAddress;
import com.mall.model.TAddressExample;
import com.mall.service.AddressService;
import com.mall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/04/2017.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    TAddressMapper addressMapper;

    @Override
    public void createAddress(TAddress address) {
        addressMapper.insert(address);
    }

    @Override
    public void updateAddress(TAddress address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void removeAddress(int addressId) {
        TAddress address = new TAddress();
        address.setId(addressId);
        address.setRemoved(Constants.ONE);

        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public List<TAddress> selectAddressByUser(int userId) {
        TAddressExample example = new TAddressExample();
        TAddressExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andRemovedEqualTo(Constants.ZERO);

        example.setOrderByClause(" id desc ");

        return addressMapper.selectByExample(example);
    }

    @Override
    public List<TAddress> selectAddress(List<Integer> addressIdList) {
        TAddressExample example = new TAddressExample();
        TAddressExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(addressIdList);

        return addressMapper.selectByExample(example);
    }

    @Override
    public Map<Integer, TAddress> selectAddressForMap(List<Integer> addressIdList) {
        Map<Integer, TAddress> map = new HashMap<>();

        List<TAddress> list = selectAddress(addressIdList);

        for (TAddress address : list) {
            map.put(address.getId(), address);
        }

        return map;
    }

    @Override
    public TAddress selectAddress(int addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
