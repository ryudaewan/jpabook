package jpabook.jpashop.domain;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class OrderSpec {

    public static Specification<Order> memberNameLike(final String memberName) {
        return new Specification<Order>() {
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                if (false == StringUtils.hasLength(memberName)) return null;

                Join<Order, Member> m = root.join("member", JoinType.INNER); //회원과 조인
                return builder.like(m.<String>get("name"), "%" + memberName + "%");
            }
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return new Specification<Order>() {
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                if (orderStatus == null) return null;

                return builder.equal(root.get("status"), orderStatus);
            }
        };
    }
}