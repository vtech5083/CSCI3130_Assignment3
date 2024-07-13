package com.adobe.aem.commons.assetshare.util;


import com.adobe.aem.commons.assetshare.content.AssetModel;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface DynamicMediaExpressionEvaluator {
    String VAR_DM_NAME = "${dm.name}";
    String VAR_DM_ID = "${dm.id}";
    String VAR_DM_FILE = "${dm.file}";
    String VAR_DM_FILE_AVS = "${dm.file.avs}";
    String VAR_DM_FILE_NO_COMPANY = "${dm.file.nocompany}";
    String VAR_DM_FOLDER = "${dm.folder}";
    String VAR_DM_DOMAIN = "${dm.domain}";
    String VAR_DM_API_SERVER = "${dm.apiserver}";
    String VAR_DM_COMPANY_ID = "${dm.company.id}";
    String VAR_DM_COMPANY_NAME = "${dm.company.name}";

    String evaluateDynamicMediaExpression(String expression, AssetModel assetModel);
}
