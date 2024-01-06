package com.michigang1.backendcourse.entity

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class CategoryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Int = 0,

    @Column(unique = true, name = "name")
    val name: String = "No name provided",

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
    val records: List<RecordEntity> = emptyList()
)