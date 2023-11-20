package uk.jinhy.umcstudy.controller.user;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
