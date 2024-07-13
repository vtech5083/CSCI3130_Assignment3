package com.adobe.aem.commons.assetshare.util.impl;

import com.adobe.aem.commons.assetshare.content.AssetModel;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class AssetsRenditionsExpressionEvaluator {
    public static final String VAR_ASSET_COUNT = "${asset.count}";
    public static final String VAR_RENDITION_COUNT = "${rendition.count}";
    public static final String VAR_FILE_COUNT = "${file.count}";

    public String evaluateAssetsRenditionsExpressions(String expression, Collection<AssetModel> assetModels, Collection<String> renditionNames) {
        expression = StringUtils.replace(expression, VAR_ASSET_COUNT, String.valueOf(assetModels.size()));
        expression = StringUtils.replace(expression, VAR_RENDITION_COUNT, String.valueOf(renditionNames.size()));
        expression = StringUtils.replace(expression, VAR_FILE_COUNT, String.valueOf(assetModels.size() * renditionNames.size()));

        return expression;
    }
}
