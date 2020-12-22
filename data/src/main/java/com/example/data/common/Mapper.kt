package com.example.data.common

interface Mapper<Entity, Domain> {

    fun to(domain: Domain): Entity

    fun from(entity: Entity): Domain
}