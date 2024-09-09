package dev.nirvik.unswplanner

import dev.nirvik.unswplanner.utils.monthNameFromIndex
import org.junit.Assert.assertEquals
import org.junit.Test

import org.junit.Assert.*

class MonthNameFromIndexTest {

    @Test
    fun testValidInputs() {
        assertEquals("Jan", monthNameFromIndex(1))
        assertEquals("Feb", monthNameFromIndex(2))
        assertEquals("Mar", monthNameFromIndex(3))
        assertEquals("Apr", monthNameFromIndex(4))
        assertEquals("May", monthNameFromIndex(5))
        assertEquals("Jun", monthNameFromIndex(6))
        assertEquals("Jul", monthNameFromIndex(7))
        assertEquals("Aug", monthNameFromIndex(8))
        assertEquals("Sep", monthNameFromIndex(9))
        assertEquals("Oct", monthNameFromIndex(10))
        assertEquals("Nov", monthNameFromIndex(11))
        assertEquals("Dec", monthNameFromIndex(12))
    }

    @Test
    fun testEdgeCases() {
        assertEquals("Jan", monthNameFromIndex(1))  // First month
        assertEquals("Dec", monthNameFromIndex(12)) // Last month
    }

    @Test
    fun testInvalidLowInput() {
        val exception = assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            monthNameFromIndex(0)
        }
        assertEquals("Index -1 out of bounds for length 12", exception.message)
    }

    @Test
    fun testInvalidHighInput() {
        val exception = assertThrows(ArrayIndexOutOfBoundsException::class.java){
            monthNameFromIndex(13)
        }
        assertEquals("Index 12 out of bounds for length 12", exception.message)
    }

    @Test
    fun testNegativeInput() {
        val exception = assertThrows (ArrayIndexOutOfBoundsException::class.java) {
            monthNameFromIndex(-1)
        }
        assertEquals("Index -2 out of bounds for length 12", exception.message)
    }
}
