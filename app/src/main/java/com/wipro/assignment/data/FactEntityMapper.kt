package com.wipro.assignment.data

import com.wipro.assignment.database.entitiy.Fact
import com.wipro.assignment.rest.model.Facts

/**
 * The mapper class, responsible to map model {@link Facts.Row} to entity {@link Fact}
 */
class FactEntityMapper {
    companion object {
        /**
         * Maps to entity {@link Fact}
         * @param item The {@link Facts.Row}
         */
        private fun toEntity(item: Facts.Row): Fact {
            val fact = Fact()
            fact.description = item?.description
            fact.imageHref = item?.imageHref
            fact.title = item?.title
            return fact
        }

        /**
         * Maps to entities.
         * @param fact The list of {@link Facts.Row}
         * @return The list of entity {@link Fact}
         */
        fun toEntities(fact: Facts): List<Fact> {
            val entities = ArrayList<Fact>()
            for (row in fact.rows) {
                val factEntity = FactEntityMapper.toEntity(row)
                factEntity.country = fact.title
                entities.add(factEntity)
            }
            return entities
        }
    }
}