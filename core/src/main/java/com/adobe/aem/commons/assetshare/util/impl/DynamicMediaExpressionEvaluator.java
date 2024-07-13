package com.adobe.aem.commons.assetshare.util.impl;

import com.adobe.aem.commons.assetshare.content.AssetModel;
import org.apache.commons.lang3.StringUtils;

import static com.day.cq.dam.scene7.api.constants.Scene7Constants.*;

public class DynamicMediaExpressionEvaluator {
    public static final String VAR_DM_NAME = "${dm.name}";
    public static final String VAR_DM_ID = "${dm.id}";
    public static final String VAR_DM_FILE = "${dm.file}";
    public static final String VAR_DM_FILE_AVS = "${dm.fileAvs}";
    public static final String VAR_DM_FILE_NO_COMPANY = "${dm.fileNoCompany}";
    public static final String VAR_DM_FOLDER = "${dm.folder}";
    public static final String VAR_DM_DOMAIN = "${dm.domain}";
    public static final String VAR_DM_API_SERVER = "${dm.apiServer}";
    public static final String VAR_DM_COMPANY_ID = "${dm.companyId}";
    public static final String VAR_DM_COMPANY_NAME = "${dm.companyName}";

    public String evaluateDynamicMediaExpression(String expression, AssetModel assetModel) {
        final String dmName = assetModel.getProperties().get(PN_S7_NAME, String.class);
        final String dmId = assetModel.getProperties().get(PN_S7_ASSET_ID, String.class);
        final String dmFile = assetModel.getProperties().get(PN_S7_FILE, String.class);
        final String dmFileAvs = assetModel.getProperties().get(PN_S7_FILE_AVS, String.class);
        final String dmFolder = assetModel.getProperties().get(PN_S7_FOLDER, String.class);
        final String dmDomain = assetModel.getProperties().get(PN_S7_DOMAIN, String.class);
        final String dmApiServer = assetModel.getProperties().get(PN_S7_API_SERVER, String.class);
        final String dmCompanyId = assetModel.getProperties().get(PN_S7_COMPANY_ID, String.class);

        expression = StringUtils.replace(expression, VAR_DM_NAME, dmName);
        expression = StringUtils.replace(expression, VAR_DM_ID, dmId);
        expression = StringUtils.replace(expression, VAR_DM_FILE, dmFile);
        expression = StringUtils.replace(expression, VAR_DM_FILE_AVS, dmFileAvs);
        expression = StringUtils.replace(expression, VAR_DM_FILE_NO_COMPANY,
                StringUtils.substringAfterLast(dmFile, "/"));
        expression = StringUtils.replace(expression, VAR_DM_FOLDER, dmFolder);
        expression = StringUtils.replace(expression, VAR_DM_DOMAIN, dmDomain);
        expression = StringUtils.replace(expression, VAR_DM_API_SERVER, dmApiServer);
        expression = StringUtils.replace(expression, VAR_DM_COMPANY_ID, dmCompanyId);
        expression = StringUtils.replace(expression, VAR_DM_COMPANY_NAME,
                StringUtils.substringBeforeLast(dmFile, "/"));

        return expression;
    }
}
