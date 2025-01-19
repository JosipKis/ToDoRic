package unizd.inoIT.todo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import unizd.inoIT.todo.model.User;
import unizd.inoIT.todo.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository USER_REPOSITORY;

    public UserService(UserRepository USER_REPOSITORY) {
        this.USER_REPOSITORY = USER_REPOSITORY;
    }

    public List<User> findAll() {
        return USER_REPOSITORY.findAll();
    }

    public User save(User user) {
        return USER_REPOSITORY.save(user);
    }

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = USER_REPOSITORY.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Korisnik nije pronađen: " + userName));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}