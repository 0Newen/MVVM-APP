package com.example.mvvmapp.data.model

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AcronymTest {

    private lateinit var acronym: Acronym

    @Before
    fun createAcronym() {
        acronym = Acronym.getEmptyAcronym()
    }

    @Test
    fun getSf() {
        assertEquals("TEST", acronym.sf)
    }

    @Test
    fun getLsfs() {
        assertEquals(listOf(AcronymLfs.getEmptyAcronymLf())[0].lf,acronym.lsfs[0].lf)
    }

}