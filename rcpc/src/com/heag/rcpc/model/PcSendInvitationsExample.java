package com.heag.rcpc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heag.rcpc.model.PcAskinfoExample.Criteria;
import com.heag.rcpc.model.PcAskinfoExample.Criterion;
import com.heag.rcpc.model.PcAskinfoExample.GeneratedCriteria;

public class PcSendInvitationsExample {
	 /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public PcSendInvitationsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAtitleIsNull() {
            addCriterion("atitle is null");
            return (Criteria) this;
        }

        public Criteria andAtitleIsNotNull() {
            addCriterion("atitle is not null");
            return (Criteria) this;
        }

        public Criteria andAtitleEqualTo(String value) {
            addCriterion("atitle =", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleNotEqualTo(String value) {
            addCriterion("atitle <>", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleGreaterThan(String value) {
            addCriterion("atitle >", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleGreaterThanOrEqualTo(String value) {
            addCriterion("atitle >=", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleLessThan(String value) {
            addCriterion("atitle <", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleLessThanOrEqualTo(String value) {
            addCriterion("atitle <=", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleLike(String value) {
            addCriterion("atitle like", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleNotLike(String value) {
            addCriterion("atitle not like", value, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleIn(List<String> values) {
            addCriterion("atitle in", values, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleNotIn(List<String> values) {
            addCriterion("atitle not in", values, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleBetween(String value1, String value2) {
            addCriterion("atitle between", value1, value2, "atitle");
            return (Criteria) this;
        }

        public Criteria andAtitleNotBetween(String value1, String value2) {
            addCriterion("atitle not between", value1, value2, "atitle");
            return (Criteria) this;
        }

        public Criteria andAdescribeIsNull() {
            addCriterion("adescribe is null");
            return (Criteria) this;
        }

        public Criteria andAdescribeIsNotNull() {
            addCriterion("adescribe is not null");
            return (Criteria) this;
        }

        public Criteria andAdescribeEqualTo(String value) {
            addCriterion("adescribe =", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeNotEqualTo(String value) {
            addCriterion("adescribe <>", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeGreaterThan(String value) {
            addCriterion("adescribe >", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("adescribe >=", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeLessThan(String value) {
            addCriterion("adescribe <", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeLessThanOrEqualTo(String value) {
            addCriterion("adescribe <=", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeLike(String value) {
            addCriterion("adescribe like", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeNotLike(String value) {
            addCriterion("adescribe not like", value, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeIn(List<String> values) {
            addCriterion("adescribe in", values, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeNotIn(List<String> values) {
            addCriterion("adescribe not in", values, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeBetween(String value1, String value2) {
            addCriterion("adescribe between", value1, value2, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAdescribeNotBetween(String value1, String value2) {
            addCriterion("adescribe not between", value1, value2, "adescribe");
            return (Criteria) this;
        }

        public Criteria andAleadpageIsNull() {
            addCriterion("aleadpage is null");
            return (Criteria) this;
        }

        public Criteria andAleadpageIsNotNull() {
            addCriterion("aleadpage is not null");
            return (Criteria) this;
        }

        public Criteria andAleadpageEqualTo(String value) {
            addCriterion("aleadpage =", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageNotEqualTo(String value) {
            addCriterion("aleadpage <>", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageGreaterThan(String value) {
            addCriterion("aleadpage >", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageGreaterThanOrEqualTo(String value) {
            addCriterion("aleadpage >=", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageLessThan(String value) {
            addCriterion("aleadpage <", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageLessThanOrEqualTo(String value) {
            addCriterion("aleadpage <=", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageLike(String value) {
            addCriterion("aleadpage like", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageNotLike(String value) {
            addCriterion("aleadpage not like", value, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageIn(List<String> values) {
            addCriterion("aleadpage in", values, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageNotIn(List<String> values) {
            addCriterion("aleadpage not in", values, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageBetween(String value1, String value2) {
            addCriterion("aleadpage between", value1, value2, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAleadpageNotBetween(String value1, String value2) {
            addCriterion("aleadpage not between", value1, value2, "aleadpage");
            return (Criteria) this;
        }

        public Criteria andAtypeIsNull() {
            addCriterion("atype is null");
            return (Criteria) this;
        }

        public Criteria andAtypeIsNotNull() {
            addCriterion("atype is not null");
            return (Criteria) this;
        }

        public Criteria andAtypeEqualTo(Byte value) {
            addCriterion("atype =", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotEqualTo(Byte value) {
            addCriterion("atype <>", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeGreaterThan(Byte value) {
            addCriterion("atype >", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("atype >=", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLessThan(Byte value) {
            addCriterion("atype <", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLessThanOrEqualTo(Byte value) {
            addCriterion("atype <=", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeIn(List<Byte> values) {
            addCriterion("atype in", values, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotIn(List<Byte> values) {
            addCriterion("atype not in", values, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeBetween(Byte value1, Byte value2) {
            addCriterion("atype between", value1, value2, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("atype not between", value1, value2, "atype");
            return (Criteria) this;
        }

        public Criteria andAendpageIsNull() {
            addCriterion("aendpage is null");
            return (Criteria) this;
        }

        public Criteria andAendpageIsNotNull() {
            addCriterion("aendpage is not null");
            return (Criteria) this;
        }

        public Criteria andAendpageEqualTo(String value) {
            addCriterion("aendpage =", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageNotEqualTo(String value) {
            addCriterion("aendpage <>", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageGreaterThan(String value) {
            addCriterion("aendpage >", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageGreaterThanOrEqualTo(String value) {
            addCriterion("aendpage >=", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageLessThan(String value) {
            addCriterion("aendpage <", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageLessThanOrEqualTo(String value) {
            addCriterion("aendpage <=", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageLike(String value) {
            addCriterion("aendpage like", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageNotLike(String value) {
            addCriterion("aendpage not like", value, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageIn(List<String> values) {
            addCriterion("aendpage in", values, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageNotIn(List<String> values) {
            addCriterion("aendpage not in", values, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageBetween(String value1, String value2) {
            addCriterion("aendpage between", value1, value2, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAendpageNotBetween(String value1, String value2) {
            addCriterion("aendpage not between", value1, value2, "aendpage");
            return (Criteria) this;
        }

        public Criteria andAlinkIsNull() {
            addCriterion("alink is null");
            return (Criteria) this;
        }

        public Criteria andAlinkIsNotNull() {
            addCriterion("alink is not null");
            return (Criteria) this;
        }

        public Criteria andAlinkEqualTo(String value) {
            addCriterion("alink =", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkNotEqualTo(String value) {
            addCriterion("alink <>", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkGreaterThan(String value) {
            addCriterion("alink >", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkGreaterThanOrEqualTo(String value) {
            addCriterion("alink >=", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkLessThan(String value) {
            addCriterion("alink <", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkLessThanOrEqualTo(String value) {
            addCriterion("alink <=", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkLike(String value) {
            addCriterion("alink like", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkNotLike(String value) {
            addCriterion("alink not like", value, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkIn(List<String> values) {
            addCriterion("alink in", values, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkNotIn(List<String> values) {
            addCriterion("alink not in", values, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkBetween(String value1, String value2) {
            addCriterion("alink between", value1, value2, "alink");
            return (Criteria) this;
        }

        public Criteria andAlinkNotBetween(String value1, String value2) {
            addCriterion("alink not between", value1, value2, "alink");
            return (Criteria) this;
        }

        public Criteria andIsopenIsNull() {
            addCriterion("isopen is null");
            return (Criteria) this;
        }

        public Criteria andIsopenIsNotNull() {
            addCriterion("isopen is not null");
            return (Criteria) this;
        }

        public Criteria andIsopenEqualTo(Byte value) {
            addCriterion("isopen =", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotEqualTo(Byte value) {
            addCriterion("isopen <>", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenGreaterThan(Byte value) {
            addCriterion("isopen >", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenGreaterThanOrEqualTo(Byte value) {
            addCriterion("isopen >=", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenLessThan(Byte value) {
            addCriterion("isopen <", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenLessThanOrEqualTo(Byte value) {
            addCriterion("isopen <=", value, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenIn(List<Byte> values) {
            addCriterion("isopen in", values, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotIn(List<Byte> values) {
            addCriterion("isopen not in", values, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenBetween(Byte value1, Byte value2) {
            addCriterion("isopen between", value1, value2, "isopen");
            return (Criteria) this;
        }

        public Criteria andIsopenNotBetween(Byte value1, Byte value2) {
            addCriterion("isopen not between", value1, value2, "isopen");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Byte value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Byte value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Byte value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Byte value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Byte value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Byte> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Byte> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Byte value1, Byte value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pc_askinfo
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pc_askinfo
     *
     * @mbggenerated
     */
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