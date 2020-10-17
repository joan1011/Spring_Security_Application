package com.anand.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.anand.demo.security.ApplicationUserRole.*;
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
         List<ApplicationUser> applicationUsers = Lists.newArrayList(
                 new ApplicationUser("anand",
                         passwordEncoder.encode("anand"),
                         STUDENT.getGrantedAuthorities(),
                         true,
                         true,
                         true,
                         true
                 ),
                 new ApplicationUser("Tom",
                         passwordEncoder.encode("anand"),
                         ADMIN.getGrantedAuthorities(),
                         true,
                         true,
                         true,
                         true
                 ),
        new ApplicationUser("curran",
                passwordEncoder.encode("anand"),
                ADMINTRAINEE.getGrantedAuthorities(),
                true,
                true,
                true,
                true
        )

        );
         return applicationUsers;
    }
}
