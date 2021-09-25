package com.bratin.weatherapp

import org.junit.Before
import org.mockito.MockitoAnnotations

open class BaseTest {

    @Before
    open fun setup(){
        MockitoAnnotations.openMocks(this)
    }
}