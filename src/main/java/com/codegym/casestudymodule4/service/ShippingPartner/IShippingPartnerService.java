package com.codegym.casestudymodule4.service.ShippingPartner;

import com.codegym.casestudymodule4.model.ShippingPartner;
import com.codegym.casestudymodule4.service.GenerateService;

public interface IShippingPartnerService extends GenerateService<ShippingPartner> {
    public void lockShippingPartner(Long id);
    public void unlockShippingPartner(Long id);

}
