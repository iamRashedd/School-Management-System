package ecom.service;

import ecom.domain.Authority;
import ecom.domain.User;
import ecom.dto.UserDto;
import ecom.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {

    private Logger logger = Logger.getLogger(UserService.class.getName());

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    private AuthorityService authorityService;

    public UserService(UserRepository userRepository,  PasswordEncoder passwordEncoder, AuthorityService authorityService) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    public List<User> list() {
        return userRepository.list();
    }

    public User get(Long id) {
        return userRepository.get(id);
    }
    public User get(String username) {
        return userRepository.get(username);
    }


    public boolean create(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }

    public boolean update(User user) {
        return userRepository.update(user);
    }
    public boolean update(UserDto userDto) {
        User user = this.get(userDto.getId());
        user.setName(userDto.getName());
        user.setEnabled(userDto.isEnabled());
        return userRepository.update(user);
    }

    public boolean authorize(Long userId) {
        User user = get(userId);
        user.setEnabled(true);
        Authority authority = new Authority();
        authority.setName("ROLE_"+user.getUserType());
        authority.setUser(user);
        authorityService.create(authority);

        return userRepository.update(user);
    }
    public boolean unauthorize(Long userId) {
        User user = get(userId);
        authorityService.deleteByUser(userId);
        return userRepository.update(user);
    }

    public boolean delete(Long id) {
        return userRepository.delete(get(id));
    }
}
