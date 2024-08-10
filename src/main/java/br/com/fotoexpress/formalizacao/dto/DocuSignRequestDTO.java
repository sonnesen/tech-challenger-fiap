package br.com.fotoexpress.formalizacao.dto;

public record DocuSignRequestDTO(
        String envelopeId
) {
}


//        {
//        "status": "completed",
//        "documentsUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/documents",
//        "recipientsUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/recipients",
//        "attachmentsUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/attachments",
//        "envelopeUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87",
//        "emailSubject": "Please sign this document set",
//        "envelopeId": "bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87",
//        "signingLocation": "online",
//        "customFieldsUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/custom_fields",
//        "notificationUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/notification",
//        "enableWetSign": "true",
//        "allowMarkup": "false",
//        "allowReassign": "true",
//        "createdDateTime": "2020-08-13T22:01:19.9600000Z",
//        "lastModifiedDateTime": "2020-08-13T22:01:19.9600000Z",
//        "deliveredDateTime": "2020-08-13T22:03:05.8370000Z",
//        "initialSentDateTime": "2020-08-13T22:01:21.1300000Z",
//        "sentDateTime": "2020-08-13T22:03:05.8370000Z",
//        "completedDateTime": "2020-08-13T22:03:05.8370000Z",
//        "statusChangedDateTime": "2020-08-13T22:03:05.8370000Z",
//        "documentsCombinedUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/documents/combined",
//        "certificateUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/documents/certificate",
//        "templatesUri": "/envelopes/bc4799a2-xxxx-xxxx-xxxx-20d1921aeb87/templates",
//        "expireEnabled": "true",
//        "expireDateTime": "2020-12-11T22:01:21.1300000Z",
//        "expireAfter": "114",
//        "sender":
//        {
//        "userName": "Admin One",
//        "userId": "c1c4ca80-xxxx-xxxx-xxxx-32a3a9b13925",
//        "accountId": "a56df5fc-xxxx-xxxx-xxxx-f64dc8ab421e",
//        "email": "admin1@anyemail.com"
//        },
//        "purgeState": "unpurged",
//        "envelopeIdStamping": "true",
//        "is21CFRPart11": "false",
//        "signerCanSignOnMobile": "true",
//        "autoNavigation": "true",
//        "isSignatureProviderEnvelope": "false",
//        "hasFormDataChanged": "false",
//        "allowComments": "true",
//        "hasComments": "false",
//        "allowViewHistory": "true",
//        "envelopeMetadata":
//        {
//        "allowAdvancedCorrect": "true",
//        "enableSignWithNotary": "true",
//        "allowCorrect": "true"
//        },
//        "anySigner": null,
//        "envelopeLocation": "current_site",
//        "isDynamicEnvelope": "false"
//        }