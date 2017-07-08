package ro.vavedem.persistence.service;

import ro.vavedem.persistence.entities.Localitate;

public class LocalitySpecification {

    public static Specification<Localitate> isCity() {
        return  null;
//        return new Specification<Localitate>() {
//            @Override
//            public Predicate toPredicate(Root<Localitate> root, CriteriaQuery query, CriteriaBuilder cb) {
//                return cb.equal(root.get("tip"), 1);
//            }
//        };
    }
}
