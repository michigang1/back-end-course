package com.michigang1.backendcourse.exception

import java.lang.RuntimeException

class NoOneOfTwoParamsProvidedException: IllegalArgumentException(){
override val message: String
        get() = "No one of two params provided"
}