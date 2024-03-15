package org.launchcode.yardparty.data;

import org.launchcode.yardparty.models.AdminUser;
import org.springframework.data.repository.CrudRepository;

public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {
    AdminUser findByUsername(String username);
}
