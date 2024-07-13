package com.adobe.aem.commons.assetshare.util;


import com.adobe.aem.commons.assetshare.content.AssetModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Collection;

@ProviderType
public interface RenditionExpressionEvaluator {
    String VAR_ASSET_COUNT = "${asset.count}";
    String VAR_ASSET_PATH = "${asset.path}";
    String VAR_ASSET_URL = "${asset.url}";
    String VAR_ASSET_NAME = "${asset.name}";
    String VAR_ASSET_NAME_NO_EXTENSION = "${asset.name.noextension}";
    String VAR_ASSET_EXTENSION = "${asset.extension}";

    String evaluateAssetExpression(String expression, AssetModel assetModel);
    String evaluateAssetsExpression(String expression, Collection<AssetModel> assetModels);
    String evaluateProperties(String expression, AssetModel assetModel);
}
