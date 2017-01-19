package com.mall.service.impl;

import com.mall.mapper.TAddressMapper;
import com.mall.model.TAddress;
import com.mall.model.TAddressExample;
import com.mall.service.AddressService;
import com.mall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Supeng on 18/01/2017.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    TAddressMapper addressMapper;

    @Override
    public List<TAddress> selectActiveAddress(int userId) {
        TAddressExample example = new TAddressExample();
        TAddressExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(Constants.ZERO);

        return addressMapper.selectByExample(example);
    }

    @Override
    public void createAddress(TAddress address) {
        addressMapper.insert(address);
    }

    @Override
    public void removeAddress(int addressId) {
        TAddress address = new TAddress();
        address.setStatus(Constants.ONE);
        address.setId(addressId);

        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    @Transactional
    public void updateAddress(TAddress address) {
        // 如果当前记录设置为默认，其他地址设置为不默认

        if (address.getDefaulted() == Constants.ONE ) {
            TAddress tempAddress = new TAddress();
            tempAddress.setDefaulted(Constants.ZERO);

            TAddressExample example = new TAddressExample();
            TAddressExample.Criteria criteria = example.createCriteria();

            criteria.andUserIdEqualTo(address.getUserId());

            addressMapper.updateByExampleSelective(tempAddress, example);
        }

        addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public TAddress selectAddress(int addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
