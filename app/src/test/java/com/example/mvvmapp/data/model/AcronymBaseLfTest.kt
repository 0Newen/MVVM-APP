package com.example.mvvmapp.data.model

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class AcronymBaseLfTest {

    private lateinit var acronym: Acronym

    @Before
    fun createAcronym() {
        acronym = Acronym.getEmptyAcronym()
    }

    @Test
    fun getLf() {
        assertEquals("INI",acronym.lsfs[0].lf)
    }

    @Test
    fun getFreq() {
        assertEquals(-1,acronym.lsfs[0].freq)
    }

    @Test
    fun getSince() {
        assertEquals(-1,acronym.lsfs[0].freq)
    }
}