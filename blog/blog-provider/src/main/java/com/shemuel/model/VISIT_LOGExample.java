package com.shemuel.model;

import java.util.ArrayList;
import java.util.List;

public class VISIT_LOGExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VISIT_LOGExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("TIME like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("TIME not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("TIME not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeIsNull() {
            addCriterion("BROWSE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeIsNotNull() {
            addCriterion("BROWSE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeEqualTo(String value) {
            addCriterion("BROWSE_TYPE =", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeNotEqualTo(String value) {
            addCriterion("BROWSE_TYPE <>", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeGreaterThan(String value) {
            addCriterion("BROWSE_TYPE >", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BROWSE_TYPE >=", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeLessThan(String value) {
            addCriterion("BROWSE_TYPE <", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeLessThanOrEqualTo(String value) {
            addCriterion("BROWSE_TYPE <=", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeLike(String value) {
            addCriterion("BROWSE_TYPE like", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeNotLike(String value) {
            addCriterion("BROWSE_TYPE not like", value, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeIn(List<String> values) {
            addCriterion("BROWSE_TYPE in", values, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeNotIn(List<String> values) {
            addCriterion("BROWSE_TYPE not in", values, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeBetween(String value1, String value2) {
            addCriterion("BROWSE_TYPE between", value1, value2, "browseType");
            return (Criteria) this;
        }

        public Criteria andBrowseTypeNotBetween(String value1, String value2) {
            addCriterion("BROWSE_TYPE not between", value1, value2, "browseType");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andComputerNameIsNull() {
            addCriterion("COMPUTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andComputerNameIsNotNull() {
            addCriterion("COMPUTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andComputerNameEqualTo(String value) {
            addCriterion("COMPUTER_NAME =", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameNotEqualTo(String value) {
            addCriterion("COMPUTER_NAME <>", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameGreaterThan(String value) {
            addCriterion("COMPUTER_NAME >", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPUTER_NAME >=", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameLessThan(String value) {
            addCriterion("COMPUTER_NAME <", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameLessThanOrEqualTo(String value) {
            addCriterion("COMPUTER_NAME <=", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameLike(String value) {
            addCriterion("COMPUTER_NAME like", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameNotLike(String value) {
            addCriterion("COMPUTER_NAME not like", value, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameIn(List<String> values) {
            addCriterion("COMPUTER_NAME in", values, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameNotIn(List<String> values) {
            addCriterion("COMPUTER_NAME not in", values, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameBetween(String value1, String value2) {
            addCriterion("COMPUTER_NAME between", value1, value2, "computerName");
            return (Criteria) this;
        }

        public Criteria andComputerNameNotBetween(String value1, String value2) {
            addCriterion("COMPUTER_NAME not between", value1, value2, "computerName");
            return (Criteria) this;
        }

        public Criteria andOperateSystemIsNull() {
            addCriterion("OPERATE_SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andOperateSystemIsNotNull() {
            addCriterion("OPERATE_SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andOperateSystemEqualTo(String value) {
            addCriterion("OPERATE_SYSTEM =", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemNotEqualTo(String value) {
            addCriterion("OPERATE_SYSTEM <>", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemGreaterThan(String value) {
            addCriterion("OPERATE_SYSTEM >", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_SYSTEM >=", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemLessThan(String value) {
            addCriterion("OPERATE_SYSTEM <", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_SYSTEM <=", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemLike(String value) {
            addCriterion("OPERATE_SYSTEM like", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemNotLike(String value) {
            addCriterion("OPERATE_SYSTEM not like", value, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemIn(List<String> values) {
            addCriterion("OPERATE_SYSTEM in", values, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemNotIn(List<String> values) {
            addCriterion("OPERATE_SYSTEM not in", values, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemBetween(String value1, String value2) {
            addCriterion("OPERATE_SYSTEM between", value1, value2, "operateSystem");
            return (Criteria) this;
        }

        public Criteria andOperateSystemNotBetween(String value1, String value2) {
            addCriterion("OPERATE_SYSTEM not between", value1, value2, "operateSystem");
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