package com.michigang1.backendcourse.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int = 0,

    @Column(unique = true, name = "name")
    val name: String? = "No name provided",

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val records: List<RecordEntity> = emptyList()
)
