package com.domain.usecases.base

interface BaseUseCase<PARAMS, RESULT> {

    suspend fun invoke(params: PARAMS): RESULT
}