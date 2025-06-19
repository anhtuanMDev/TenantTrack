package com.example.tenanttrack.domain.repository

interface BaseValidateInterface<in Input, out Result> {
    fun execute(input: Input): Result
}