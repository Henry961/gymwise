package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.UserMembership;
import java.util.List;
import java.util.Optional;

public interface IUserMembershipRepository {
    UserMembership save(UserMembership usermembership);
    Optional<UserMembership> findById(Integer id);
    List<UserMembership> findAll();
    void deleteById(Integer id);
}
