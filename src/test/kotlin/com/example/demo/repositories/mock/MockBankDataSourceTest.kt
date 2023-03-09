package com.example.demo.repositories.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide list of Banks` (){

        //when
        val banks = mockDataSource.getBanks()

        //then
        Assertions.assertThat(banks).isNotEmpty
    }
    @Test
    fun `should provide a data` (){

        //when
        val banks = mockDataSource. getBanks()

        //then
        Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
    }
}