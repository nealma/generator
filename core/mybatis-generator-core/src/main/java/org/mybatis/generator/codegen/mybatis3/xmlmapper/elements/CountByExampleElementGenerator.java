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
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class CountByExampleElementGenerator extends AbstractXmlElementGenerator {

    public CountByExampleElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer4 = new XmlElement("select"); //$NON-NLS-1$

        String fqjt4 = introspectedTable.getBaseRecordType();

        answer4.addAttribute(new Attribute(
                "id", introspectedTable.getCountByExampleStatementId())); //$NON-NLS-1$
        answer4.addAttribute(new Attribute("parameterType", fqjt4)); //$NON-NLS-1$
        answer4.addAttribute(new Attribute("resultType", "java.lang.Long")); //$NON-NLS-1$ //$NON-NLS-2$

        context.getCommentGenerator().addComment(answer4);

        StringBuilder sb4 = new StringBuilder();
        sb4.append("select count(1) from "); //$NON-NLS-1$
        sb4.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
        answer4.addElement(new TextElement(sb4.toString()));
        answer4.addElement(getIncludeElement());

        if (context.getPlugins().sqlMapCountByExampleElementGenerated(
                answer4, introspectedTable)) {
            parentElement.addElement(answer4);
        }
    }
}
