package com.michigang1.backendcourse.exception

class ResourceByParamNotFound: IllegalArgumentException() {
    override val message: String
        get() = "No resource found by provided param"
}