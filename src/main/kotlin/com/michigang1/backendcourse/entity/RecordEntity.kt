package com.michigang1.backendcourse.entity

import jakarta.persistence.*

@Entity
@Table(name = "records")
data class RecordEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE], optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    val category: CategoryEntity,

    @Column(name = "date_time_at_creation", nullable = false)
    val dateTimeAtCreation: String,

    @Column(name = "general_expenses", nullable = false)
    val generalExpenses: Double

){
   constructor() : this(id = 0, user = UserEntity(), category = CategoryEntity(), dateTimeAtCreation = "", generalExpenses = 0.0)
}