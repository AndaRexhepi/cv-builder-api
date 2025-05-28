package org.example.cvbuilderapp.security;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    public final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with email " + email + " not found");
        }

        return new AppUserDetails(user);
    }
}
