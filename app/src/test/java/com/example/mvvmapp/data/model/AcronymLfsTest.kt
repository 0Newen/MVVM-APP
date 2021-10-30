package com.example.mvvmapp.data.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AcronymLfsTest {

    private lateinit var acronym: Acronym
    private lateinit var vars: List<AcronymBaseLf>

    @Before
    fun createAcronym() {
        acronym = Acronym.getEmptyAcronym()
        vars = acronym.lsfs[0].vars
    }

    @Test
    fun getLf() {
        assertEquals("INI", acronym.lsfs[0].lf)
    }

    @Test
    fun getFreq() {
        assertEquals(-1, acronym.lsfs[0].freq)
    }

    @Test
    fun getSince() {
        assertEquals(-1, acronym.lsfs[0].freq)
    }

    @Test
    fun getVars() {
        assertEquals(AcronymBaseLf.getEmptyAcronymLf().toJSON(), vars[0].toJSON())
    }
}