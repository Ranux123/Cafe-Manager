package org.example.javaspringbootangularmysqlbackend.dao;

import org.example.javaspringbootangularmysqlbackend.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */
public interface UserDao extends JpaRepository<User, Integer>
{
    @Query(name = "User.findByEmailId")
    User findByEmailId( @Param ( "email" ) String email);
}
