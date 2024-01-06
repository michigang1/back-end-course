package com.michigang1.backendcourse.entity;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository : JpaRepository<UserEntity, Int>, JpaSpecificationExecutor<UserEntity> {

}