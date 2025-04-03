package com.korit.vocard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korit.vocard.common.entity.UserEntity;

/**
 * interface: 사용자 정보를 데이터베이스에서 조회하는 Repository
 * 
 * description: {@link UserEntity} 엔티티의 데이터베이스 작업을 처리합니다.
 */
public interface UserRepository extends JpaRepository<UserEntity, String>{
  /**
   * description: 이메일 중복 확인
   * 
   * @param email 확인할 이메일
   * @return 이메일이 존재하면 {@code true}, 존재하지 않으면 {@code false}
   */
  boolean existsByEmail(String email);

  /**
   * description: 이메일로 사용자 정보 조회
   * 
   * @param email 조회할 이메일
   * @return 해당 이메일을 가진 사용자 엔티티, 없으면 {@code null}
   */
  UserEntity findByEmail(String email);
}
