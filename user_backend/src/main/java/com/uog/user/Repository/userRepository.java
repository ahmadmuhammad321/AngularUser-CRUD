package com.uog.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uog.user.Model.User;

public interface userRepository extends JpaRepository< User, Long> {

}
