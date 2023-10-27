package com.rustam.testgif.domain.mappers

interface Mapper<T, R> {

    fun map(source: T): R

    fun map(source: Collection<T>) = source.map { map(it) }
}