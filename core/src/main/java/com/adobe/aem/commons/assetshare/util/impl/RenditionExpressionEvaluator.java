package com.adobe.aem.commons.assetshare.util.impl;

import com.adobe.aem.commons.assetshare.content.renditions.AssetRendition;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.commons.mime.MimeTypeService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

public class RenditionExpressionEvaluator {
    public static final String VAR_RENDITION_NAME = "${rendition.name}";
    public static final String VAR_RENDITION_EXTENSION = "${rendition.extension}";

    @Reference
    private MimeTypeService mimeTypeService;

    public String evaluateRenditionExpression(String expression, String renditionName) {
        expression = StringUtils.replace(expression, VAR_RENDITION_NAME, renditionName);
        return expression;
    }

    public String evaluateRenditionExpression(String expression, AssetRendition assetRendition) {
        String mimeType = assetRendition.getMimeType();
        String renditionExtension = mimeTypeService.getExtension(mimeType);

        expression = StringUtils.replace(expression, VAR_RENDITION_EXTENSION, renditionExtension);
        return expression;
    }
}
