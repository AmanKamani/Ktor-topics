package com.learning.data

data class User(
    val id: Int,
    val name: String,
    val isAdmin: Boolean = false,
)

val users = listOf(
    User(1, "Abc"),
    User(2, "Def"),
    User(3, "ghi"),
    User(4, "AAA", true),
    User(5, "jkl"),
    User(6, "ZZZ", true),
)