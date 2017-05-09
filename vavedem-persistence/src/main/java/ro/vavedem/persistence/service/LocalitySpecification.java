package ro.vavedem.persistence.service;

import org.hibernate.criterion.CriteriaQuery;
import ro.vavedem.persistence.entities.Localitate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LocalitySpecification {

    public static Specification<Localitate> isCity() {
        return new Specification<Localitate>() {
            @Override
            public Predicate toPredicate(Root<Localitate> root, CriteriaQuery query, CriteriaBuilder cb) {
                return cb.equal(root.get("tip"), 1);
            }
        };
    }
}
