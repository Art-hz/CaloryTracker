package com.plcoding.core.domain.use_case

class FilterOutDigits {
    //un caso de uso es una clase que hace una cosa en especifico y contiene logica de negocio
    operator fun invoke(text: String): String {

        return text.filter { it.isDigit() }
    }
}