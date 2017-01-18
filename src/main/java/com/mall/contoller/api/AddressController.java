package com.mall.contoller.api;

import com.mall.model.TAddress;
import com.mall.service.AddressService;
import com.mall.utils.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Supeng on 18/01/2017.
 */

@Controller
public class AddressController extends BaseAPIController {

    @Autowired
    AddressService addressService;

    /**
     * 4002 加载收货地址
     * @return
     */
    @RequestMapping(value = "address", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectAddressByUser() {
        //TODO 获取用户UserID
        int userId = 1;

        List<TAddress> addressList = addressService.selectActiveAddress(userId);
        return new ResponseEntity<Object>(addressList, HttpStatus.OK);
    }

    /**
     * 4003 创建收获地址
     * @param address
     * @return
     */
    @RequestMapping(value = "address", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createAddress(@RequestBody TAddress address) {
        //TODO 获取用户UserID
        int userId = 1;

        address.setUserId(userId);

        if (StringUtils.isBlank(address.getConsignee())) {
            return new ResponseEntity<Object>("请输入收货人", HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(address.getPhone())) {
            return new ResponseEntity<Object>("请输入手机号", HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(address.getRegion())) {
            return new ResponseEntity<Object>("请输入所在地区", HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(address.getAddress())) {
            return new ResponseEntity<Object>("请输入详细地址", HttpStatus.BAD_REQUEST);
        }

        if (address.getStatus() == null) {
            address.setStatus(Constants.ZERO);
        }

        addressService.createAddress(address);
        return new ResponseEntity<Object>(address, HttpStatus.OK);
    }

    /**
     * 4004 删除收货地址
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
     * 4005 修改收货地址
     * @param address
     * @return
     */
    @RequestMapping(value = "address/{addressId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateAddress(@PathVariable int addressId, @RequestBody TAddress address) {
        //TODO 获取用户UserID
        int userId = 1;

        address.setUserId(userId);
        address.setId(addressId);

        addressService.updateAddress(address);
        return new ResponseEntity<Object>(address, HttpStatus.OK);
    }
}
