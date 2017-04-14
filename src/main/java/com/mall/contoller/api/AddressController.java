package com.mall.contoller.api;

import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.model.TAddress;
import com.mall.service.AddressService;
import com.mall.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Supeng on 14/04/2017.
 */
@Controller
public class AddressController extends BaseCorpController {

    @Autowired
    AddressService addressService;


    /**
     * 2017 创建收货地址
     * @param address
     * @param sessionData
     * @return
     */
    @RequestMapping(value = "address", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createAddress(@RequestBody TAddress address,  @SessionKey SessionData sessionData) {
        if (StringUtils.isBlank(address.getLinkman()) || StringUtils.isBlank(address.getPhone()) || StringUtils.isBlank(address.getAddress())) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        address.setUserId(sessionData.getUserId());
        address.setRemoved(Constants.ZERO);
        addressService.createAddress(address);

        return new ResponseEntity<Object>(address, HttpStatus.OK);
    }

    /**
     * 2018 修改收货地址
     * @param address
     * @param addressId
     * @return
     */
    @RequestMapping(value = "address/{addressId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateAddress(@RequestBody TAddress address, @PathVariable int addressId) {
        address.setId(addressId);
        addressService.updateAddress(address);

        return new ResponseEntity<Object>(address, HttpStatus.OK);
    }

    /**
     * 2019 删除收货地址
     * @param addressId
     * @return
     */
    @RequestMapping(value = "address/{addressId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> removeAddress(@PathVariable int addressId) {
        addressService.removeAddress(addressId);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 2020 加载收货地址
     * @param sessionData
     * @return
     */
    @RequestMapping(value = "address", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAddress(@SessionKey SessionData sessionData) {
        List<TAddress> list = addressService.selectAddressByUser(sessionData.getUserId());
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

}
