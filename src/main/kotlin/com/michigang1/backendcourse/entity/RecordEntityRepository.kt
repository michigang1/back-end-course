package com.michigang1.backendcourse.entity;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface RecordEntityRepository : JpaRepository<RecordEntity, Int>, JpaSpecificationExecutor<RecordEntity> {
}