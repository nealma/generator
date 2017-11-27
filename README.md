MyBatis Generator (MBG)
=======================

	在原基础上进行了简化, 个人觉得清爽多啦。

### 配置文件[mybatis-generator-config.xm]

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!-- 配置文件路径 -->

    <context id="MySQLTables" targetRuntime="MyBatis3">

        <!-- 生成的Java文件的编码 -->
        <property name="javaFileEncoding" value="UTF-8"/>

        <!-- 覆盖-->
        <property name="mergeable" value="false"></property>

        <!-- Model 实现 Serializable 增加 serialVersionUID -->
        <!--<plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>-->

        <!-- 为了防止生成的代码中有很多注释，比较难看，加入下面的配置控制 -->
        <!--关闭注释 -->
        <commentGenerator>
            <property name="suppressAllComments" value="true" />
            <property name="suppressDate" value="false"/>
        </commentGenerator>

        <!--数据库连接信息 -->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/rtshop?useSSL=false"
                        userId="root"
                        password="******">
        </jdbcConnection>

        <!--生成的model 包路径 -->
        <javaModelGenerator targetPackage="com.ruitaowang.core.domain" targetProject="/your-project-path/src/main/java">
            <property name="enableSubPackages" value="true"/>
            <!-- 从数据库返回的值被清理前后的空格  -->
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!--生成xml mapper文件 路径 -->
        <sqlMapGenerator  targetPackage="mybatis.mappers" targetProject="src/main/resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- 生成的Dao接口 的包路径 ANNOTATEDMAPPER 带注解， XMLMAPPER 不带注解-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.project.module.dao" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!--对应数据库表名-->
        <!--<table tableName="address"-->
               <!--domainObjectName="Address"-->
               <!--mapperName="AddressMapper"-->
               <!--sqlProviderName="AddressMapper"-->
               <!--enableCountByExample="false"-->
               <!--enableUpdateByExample="false"-->
               <!--enableDeleteByExample="false"-->
               <!--enableSelectByExample="false"-->
               <!--selectByExampleQueryId="false">-->
            <!--<property name="useActualColumnNames" value="false"/>-->
            <!--<property name="rootClass" value="com.xxx.core.domain.Page"/>-->
            <!--<generatedKey column="address_id" sqlStatement="JDBC" identity="true"/>-->
        <!--</table>-->

        <table tableName="test"></table>

    </context>
</generatorConfiguration>
```

### domain

```
省略...
```

### mapper

```
public interface AddressMapper {
    int insert(Address address);

    int deleteByPK(Long addressId);

    int updateByPK(Address address);

    Address selectByPK(Long addressId);

    long count(Address address);

    List<Address> select(Address address);
}
```

### mapper.xml

```
省略...
```