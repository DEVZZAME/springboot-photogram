package com.hansol.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository를 상속했기 때문에 어노테이션 없이도 자동으로 IoC에 등록이 됨
public interface UserRepository extends JpaRepository<User, Long> {
}
