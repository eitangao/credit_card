package com.xmx.credit_card.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardAmountIsNull() {
            addCriterion("card_amount is null");
            return (Criteria) this;
        }

        public Criteria andCardAmountIsNotNull() {
            addCriterion("card_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCardAmountEqualTo(BigDecimal value) {
            addCriterion("card_amount =", value, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountNotEqualTo(BigDecimal value) {
            addCriterion("card_amount <>", value, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountGreaterThan(BigDecimal value) {
            addCriterion("card_amount >", value, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("card_amount >=", value, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountLessThan(BigDecimal value) {
            addCriterion("card_amount <", value, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("card_amount <=", value, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountIn(List<BigDecimal> values) {
            addCriterion("card_amount in", values, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountNotIn(List<BigDecimal> values) {
            addCriterion("card_amount not in", values, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("card_amount between", value1, value2, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("card_amount not between", value1, value2, "cardAmount");
            return (Criteria) this;
        }

        public Criteria andCardPointIsNull() {
            addCriterion("card_point is null");
            return (Criteria) this;
        }

        public Criteria andCardPointIsNotNull() {
            addCriterion("card_point is not null");
            return (Criteria) this;
        }

        public Criteria andCardPointEqualTo(Integer value) {
            addCriterion("card_point =", value, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointNotEqualTo(Integer value) {
            addCriterion("card_point <>", value, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointGreaterThan(Integer value) {
            addCriterion("card_point >", value, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_point >=", value, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointLessThan(Integer value) {
            addCriterion("card_point <", value, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointLessThanOrEqualTo(Integer value) {
            addCriterion("card_point <=", value, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointIn(List<Integer> values) {
            addCriterion("card_point in", values, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointNotIn(List<Integer> values) {
            addCriterion("card_point not in", values, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointBetween(Integer value1, Integer value2) {
            addCriterion("card_point between", value1, value2, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardPointNotBetween(Integer value1, Integer value2) {
            addCriterion("card_point not between", value1, value2, "cardPoint");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andInqpwdIsNull() {
            addCriterion("inqpwd is null");
            return (Criteria) this;
        }

        public Criteria andInqpwdIsNotNull() {
            addCriterion("inqpwd is not null");
            return (Criteria) this;
        }

        public Criteria andInqpwdEqualTo(String value) {
            addCriterion("inqpwd =", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdNotEqualTo(String value) {
            addCriterion("inqpwd <>", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdGreaterThan(String value) {
            addCriterion("inqpwd >", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdGreaterThanOrEqualTo(String value) {
            addCriterion("inqpwd >=", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdLessThan(String value) {
            addCriterion("inqpwd <", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdLessThanOrEqualTo(String value) {
            addCriterion("inqpwd <=", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdLike(String value) {
            addCriterion("inqpwd like", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdNotLike(String value) {
            addCriterion("inqpwd not like", value, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdIn(List<String> values) {
            addCriterion("inqpwd in", values, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdNotIn(List<String> values) {
            addCriterion("inqpwd not in", values, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdBetween(String value1, String value2) {
            addCriterion("inqpwd between", value1, value2, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andInqpwdNotBetween(String value1, String value2) {
            addCriterion("inqpwd not between", value1, value2, "inqpwd");
            return (Criteria) this;
        }

        public Criteria andAcctIsNull() {
            addCriterion("acct is null");
            return (Criteria) this;
        }

        public Criteria andAcctIsNotNull() {
            addCriterion("acct is not null");
            return (Criteria) this;
        }

        public Criteria andAcctEqualTo(String value) {
            addCriterion("acct =", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotEqualTo(String value) {
            addCriterion("acct <>", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctGreaterThan(String value) {
            addCriterion("acct >", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctGreaterThanOrEqualTo(String value) {
            addCriterion("acct >=", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctLessThan(String value) {
            addCriterion("acct <", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctLessThanOrEqualTo(String value) {
            addCriterion("acct <=", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctLike(String value) {
            addCriterion("acct like", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotLike(String value) {
            addCriterion("acct not like", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctIn(List<String> values) {
            addCriterion("acct in", values, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotIn(List<String> values) {
            addCriterion("acct not in", values, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctBetween(String value1, String value2) {
            addCriterion("acct between", value1, value2, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotBetween(String value1, String value2) {
            addCriterion("acct not between", value1, value2, "acct");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}