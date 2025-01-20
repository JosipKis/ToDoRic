package unizd.inoIT.todo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import unizd.inoIT.todo.model.User;
import unizd.inoIT.todo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> myUserOptional = USER_REPOSITORY.findByUserName(username);
        if (myUserOptional.isPresent()) {
            User myUser = myUserOptional.get();
            return User.builder()
                    .userName(myUser.getUserName()) //dodano extend UserDetails u User da se otkloni error ođe
                    .password(myUser.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}