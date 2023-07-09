package com.example.pokecards.model.usecase

interface SuspendingUseCase<out Output>{
    suspend fun execute(): Output
}