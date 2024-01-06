package com.michigang1.backendcourse.entity;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface CategoryEntityRepository : JpaRepository<CategoryEntity, Int>, JpaSpecificationExecutor<CategoryEntity> {
}