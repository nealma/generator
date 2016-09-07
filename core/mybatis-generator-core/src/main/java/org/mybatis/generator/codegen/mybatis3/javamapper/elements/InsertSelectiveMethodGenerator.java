/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class InsertSelectiveMethodGenerator extends
        AbstractJavaMapperMethodGenerator {

    public InsertSelectiveMethodGenerator() {
        super();
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
//        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
//        Method method = new Method();
//
//        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
//        method.setVisibility(JavaVisibility.PUBLIC);
//        method.setName(introspectedTable.getInsertSelectiveStatementId());
//
//        FullyQualifiedJavaType parameterType = introspectedTable.getRules()
//                .calculateAllFieldsClass();
//
//        importedTypes.add(parameterType);
//        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$
//
//        context.getCommentGenerator().addGeneralMethodComment(method,
//                introspectedTable);
//
//        addMapperAnnotations(interfaze, method);
//
//        if (context.getPlugins().clientInsertSelectiveMethodGenerated(
//                method, interfaze, introspectedTable)) {
//            interfaze.addImportedTypes(importedTypes);
//            interfaze.addMethod(method);
//        }

        Set<FullyQualifiedJavaType> importedTypes1 = new TreeSet<FullyQualifiedJavaType>();
        importedTypes1.add(FullyQualifiedJavaType.getNewListInstance());

        Method method1 = new Method();
        method1.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType1 = FullyQualifiedJavaType
                .getNewListInstance();
        FullyQualifiedJavaType listType1;
        if (introspectedTable.getRules().generateBaseRecordClass()) {
            listType1 = new FullyQualifiedJavaType(introspectedTable
                    .getBaseRecordType());
        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
            listType1 = new FullyQualifiedJavaType(introspectedTable
                    .getPrimaryKeyType());
        } else {
            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
        }

        importedTypes1.add(listType1);
        returnType1.addTypeArgument(listType1);
        method1.setReturnType(returnType1);

        method1.setName("select");

        StringBuilder stringBuilder1 = new StringBuilder(listType1.getShortName());
        stringBuilder1.setCharAt(0, Character.toLowerCase(stringBuilder1.charAt(0)));
        method1.addParameter(new Parameter(listType1, stringBuilder1.toString())); //$NON-NLS-1$

        if (context.getPlugins().clientInsertSelectiveMethodGenerated(
                method1, interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes1);
            interfaze.addMethod(method1);
        }
    }
    public void addMapperAnnotations(Interface interfaze, Method method) {
    }
}
