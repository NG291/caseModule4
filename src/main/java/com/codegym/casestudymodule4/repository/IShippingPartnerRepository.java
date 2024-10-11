package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.ShippingPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShippingPartnerRepository extends JpaRepository<ShippingPartner,Long> {
}
