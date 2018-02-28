package com.mengyunzhi.specs;

import com.mengyunzhi.entity.DeviceSet;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;

/**
 * Created by chuhang on 18-2-28
 */
public class DeviceSetSpecs {
    private final static Logger logger = Logger.getLogger(DeviceSetSpecs.class.getName());

    /**
     * 新建一个方法，这个方法的返回值类型为：org.springframework.data.jpa.domain.Specification <DeviceSet>
     * 这个方法接收一个参数，由于只对这个参数进行读取，不进行写入，所以设置为:final，即该变量不可变。
     */
    public static Specification<DeviceSet> base(final Map<String, Object> map) {
        /**
         * 直接返回了一个继承了 Specification 接口的对象，由于 Specification 接口中声明了
         * Predicate toPredicate(Root<T> var1, CriteriaQuery<?> var2, CriteriaBuilder var3);
         * 方法。所以在这里，我们需要有下面的这个函数：
         * public Predicate toPredicate(Root<DeviceSet> root, CriteriaQuery<?> query,
         CriteriaBuilder criteriaBuilder)
         * 其实这我们先建立一个类，继承Specification接口，然后实现它的方法。然后我们在这里直接return new XXXX<>()意思是一样的。
         */
        return new Specification<DeviceSet>() {
            private Predicate predicate = null;
            private CriteriaBuilder criteriaBuilder;

            // 设置and谓语.注意，这里只能设置and关系的谓语，如果谓语为OR，则需要手动设置
            private void andPredicate(Predicate predicate) {
                if (null != predicate) {
                    if (null == this.predicate) {
                        this.predicate = predicate;
                    } else {
                        this.predicate = this.criteriaBuilder.and(this.predicate, predicate);
                    }
                }
            }

            /*
             * @param root: 代表的查询的实体类
             * @param query：可以从中得到Root对象，即告知JPA Criteria查询要查询哪一个实体类，
             * 还可以来添加查询条件，还可以结合EntityManager对象得到最终查询的TypedQuery 对象
             * @Param cb:criteriaBuilder对象，用于创建Criteria相关的对象工程，当然可以从中获取到predicate类型
             * @return:代表一个查询条件
             * 参考地址(入门)：http://blog.csdn.net/luckyzhoustar/article/details/49362951
             * 参考地址(本示例代码参考教程)：https://my.oschina.net/u/2434456/blog/596938
             * 官方文档：
             * https://docs.spring.io/spring-data/jpa/docs/1.11.6.RELEASE/api/org/springframework/data/jpa/domain/Specification.html
             * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#specifications
             */
            public Predicate toPredicate(Root<DeviceSet> root, CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                /**
                 * predicate 译为：谓语。 比如：器具名称为XXX， 则"为"是predicate；器具名称包含XXX，则“包含”是predicate
                 * criteria 译为：标准、准则。用以创建标准、准则的对象，我们称为：criteriaBuilder
                 * like是标准的一种：除此以外的，我们常用的还有equal, notEqual, gt, ge, lt, le, between, isNull, isEmpty, isNotEmpty, isMember, isNotMember, size 等
                 * 这些标准是jpa 2.0 的 criteria 规定的。我们可以在这找到他们的身影：http://www.objectdb.com/java/jpa/query/criteria#Criteria_Query_Expressions_
                 * root前面讲了，代表正在查询的实体。get指获取实体的字段名. as是指做为什么类型. 所以：root.get("name").as(String.class) = 找到实体中的name字段，并做为字符串来处理。
                 * like和SQL中的like相同，用于模糊查找.like(要查找的字段，查找的规则)
                 * 所以String.valueOf(jsonObject.get("name")) + "%"是这样一个规则：以传入的name开始的，比如查找name = zhangsan, 则实体中name值为：zhangsan, zhangsan1, zhangsan12 都符合这条规则
                 * 使用String.valueOf(jsonObject.get("name"))是针对jsonObject的返回值做的强制转换处理.
                 */
                logger.info("设置私有变量");
                this.criteriaBuilder = criteriaBuilder;

                if (map.get("name") != null) {
                    logger.info("查询名称");
                    Predicate namePredicate = criteriaBuilder.like(root.get("name").as(String.class), String.valueOf(map.get("name")) + "%");
                    this.andPredicate(namePredicate);
                }

                if (map.get("code") != null) {
                    logger.info("查询代码");
                    Predicate codePredicate = criteriaBuilder.like(root.get("code").as(String.class), String.valueOf(map.get("code")) + "%");
                    this.andPredicate(codePredicate);
                }

                /**
                 * 将前面得到的谓语，添加到 查询准则 中。其实除了能添加where外，还可以添加orderBy, groupBy等信息。
                 * 官方文档：http://docs.oracle.com/javaee/6/api/javax/persistence/criteria/CriteriaQuery.html
                 */
                if (null != this.predicate) {
                    query.where(criteriaBuilder.and(this.predicate));
                }

                /**
                 * 获取最后的谓语信息。由于，我们在query中，仅仅添加了.where(谓语信息),所以以下代码相当于return predicate;
                 *  但当我们并不仅仅设置where信息时，就不一样了
                 */
                return query.getRestriction();
            }
        };
    }
}