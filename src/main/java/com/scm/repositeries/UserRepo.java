package com.scm.repositeries;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scm.Entities.*;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    
    User findByEmail(String email);

}
