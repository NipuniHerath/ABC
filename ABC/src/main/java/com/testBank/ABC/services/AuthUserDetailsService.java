/*
 * A service to manage user authentication
 */

package com.testBank.ABC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testBank.ABC.models.AuthUserDetails;
import com.testBank.ABC.models.User;
import com.testBank.ABC.respositories.UserRepoEmail;
import com.testBank.ABC.respositories.UserRespository;

//annotate to specify this class is to be used as a service
@Service
public class AuthUserDetailsService implements UserDetailsService {

	//instantiation of the userRepo object in order to verify user details
    @Autowired
    UserRepoEmail userRepository;

	//functional method that are used by the controller
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserEmail(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(AuthUserDetails::new).get();
    }
}

