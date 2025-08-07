package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.MembershipType;
import java.util.List;
import java.util.Optional;

public interface IMembershipTypeRepository {
    MembershipType save(MembershipType membershiptype);
    Optional<MembershipType> findById(Integer id);
    List<MembershipType> findAll();
    void deleteById(Integer id);
}
