package com.adobe.aem.commons.assetshare.util.impl;

import com.adobe.aem.commons.assetshare.content.AssetModel;
import org.apache.commons.lang3.StringUtils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssetExpressionEvaluator {

    public static final String VAR_ASSET_PATH = "${asset.path}";
    public static final String VAR_ASSET_URL = "${asset.url}";
    public static final String VAR_ASSET_NAME = "${asset.name}";
    public static final String VAR_ASSET_NAME_NO_EXTENSION = "${asset.nameNoExtension}";
    public static final String VAR_ASSET_EXTENSION = "${asset.extension}";

    public String evaluateAssetExpression(String expression, AssetModel assetModel) {
        final String assetPath = assetModel.getPath();
        final String assetUrl = assetModel.getUrl();
        final String assetName = assetModel.getName();

        expression = StringUtils.replace(expression, VAR_ASSET_PATH, assetPath);
        expression = StringUtils.replace(expression, VAR_ASSET_URL, assetUrl);
        expression = StringUtils.replace(expression, VAR_ASSET_NAME, assetName);
        expression = StringUtils.replace(expression, VAR_ASSET_NAME_NO_EXTENSION,
                StringUtils.substringBeforeLast(assetModel.getName(), "."));
        expression = StringUtils.replace(expression, VAR_ASSET_EXTENSION,
                StringUtils.substringAfterLast(assetName, "."));

        return expression;
    }

    public String evaluateProperties(String expression, AssetModel assetModel) {
        final Pattern p = Pattern.compile("\\$\\{prop\\@([^}]+)\\}");
        final Matcher m = p.matcher(expression);

        while (m.find()) {
            final String replaceString = m.group(0);
            final String propertyPath = m.group(1);
            final String value = assetModel.getProperties().get(propertyPath, StringUtils.EMPTY);

            expression = expression.replace(replaceString, value);
        }

        return expression;
    }
}
