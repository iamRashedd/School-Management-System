package ecom.service;




import ecom.domain.Authority;
import ecom.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class AuthorityService {

    private Logger logger = Logger.getLogger(StudentService.class.getName());

    private AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public List<Authority> list() {
        return authorityRepository.list();
    }

    public Authority get(Long id) {
        return authorityRepository.get(id);
    }
    public Authority getByUser(Long userId) {
        return authorityRepository.getByUser(userId);
    }

    public boolean create(Authority authority) {
        return authorityRepository.create(authority);
    }


    public boolean update(Authority authority) {
        return authorityRepository.update(authority);
    }

    public boolean delete(Long id) {
        return authorityRepository.delete(get(id));
    }
    public boolean deleteByUser(Long userId) {
        return authorityRepository.deleteByUser(userId);
    }
}
