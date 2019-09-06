

# ElepayError

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | エラーコードとメッセージ |  [optional]
**code** | [**CodeEnum**](#CodeEnum) | エラーコード |  [optional]
**message** | **String** | エラーメッセージ |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
NOT_FOUND_ERROR | &quot;not_found_error&quot;
INVALID_REQUEST_ERROR | &quot;invalid_request_error&quot;
CHANNEL_VALIDATION_ERROR | &quot;channel_validation_error&quot;
CHANNEL_ERROR | &quot;channel_error&quot;
PROVIDER_ERROR | &quot;provider_error&quot;
CONNECTION_ERROR | &quot;connection_error&quot;
PROCESS_ERROR | &quot;process_error&quot;
AUTHENTICATION_ERROR | &quot;authentication_error&quot;
FORBIDDEN_ERROR | &quot;forbidden_error&quot;
RATE_LIMIT_ERROR | &quot;rate_limit_error&quot;
API_ERROR | &quot;api_error&quot;
API_CONNECTION_ERROR | &quot;api_connection_error&quot;



## Enum: CodeEnum

Name | Value
---- | -----
NOT_FOUND | &quot;not_found&quot;
NOT_FOUND_CHARGE | &quot;not_found_charge&quot;
AUTH_INVALID_CREDENTIAL | &quot;auth_invalid_credential&quot;
AUTH_INVALID_PROVIDER | &quot;auth_invalid_provider&quot;
INVALID_REQUEST | &quot;invalid_request&quot;
INVALID_ORDER_NO | &quot;invalid_order_no&quot;
INVALID_PAYMENT_METHOD | &quot;invalid_payment_method&quot;
INVALID_AMOUNT | &quot;invalid_amount&quot;
INVALID_TOKEN | &quot;invalid_token&quot;
INVALID_FRONT_URL | &quot;invalid_front_url&quot;
INVALID_CANCEL_URL | &quot;invalid_cancel_url&quot;
INVALID_CONTRACT_NUMBER | &quot;invalid_contract_number&quot;
INVALID_USERNAME | &quot;invalid_username&quot;
INVALID_EMAIL | &quot;invalid_email&quot;
INVALID_PASSWORD | &quot;invalid_password&quot;
INVALID_ORDER_NO_LENGTH | &quot;invalid_order_no_length&quot;
INVALID_STATUS_CHANGE | &quot;invalid_status_change&quot;
INVALID_STATUS_CHANGE_BY_APP | &quot;invalid_status_change_by_app&quot;
INVALID_STATUS_CHANGE_BY_PROVIDER | &quot;invalid_status_change_by_provider&quot;
INVALID_PROVIDER_UNIQUE_ID | &quot;invalid_provider_unique_id&quot;
INVALID_PROVIDER_CAPTURE_ID | &quot;invalid_provider_capture_id&quot;
INVALID_CHANNEL_GROUP | &quot;invalid_channel_group&quot;
INVALID_BUYER_NAME | &quot;invalid_buyer_name&quot;
INVALID_BUYER_PHONE | &quot;invalid_buyer_phone&quot;
INVALID_BUYER_EMAIL | &quot;invalid_buyer_email&quot;
INVALID_BUYER_ZIP | &quot;invalid_buyer_zip&quot;
INVALID_BUYER_ADDRESS1 | &quot;invalid_buyer_address1&quot;
INVALID_BUYER_ADDRESS2 | &quot;invalid_buyer_address2&quot;
INVALID_CODE_URL | &quot;invalid_code_url&quot;
INVALID_SHOP_ID | &quot;invalid_shop_id&quot;
INVALID_SHOP_NAME | &quot;invalid_shop_name&quot;
INVALID_SHOP_NO | &quot;invalid_shop_no&quot;
INVALID_PRODUCT_ID | &quot;invalid_product_id&quot;
INVALID_PRODUCT_NAME | &quot;invalid_product_name&quot;
INVALID_PRODUCT_PRICE | &quot;invalid_product_price&quot;
INVALID_PRODUCT_COUNT | &quot;invalid_product_count&quot;
INVALID_SETTING_TYPE | &quot;invalid_setting_type&quot;
INVALID_SETTING_NAME | &quot;invalid_setting_name&quot;
INVALID_CATEGORY_ID | &quot;invalid_category_id&quot;
INVALID_CATEGORY_NAME | &quot;invalid_category_name&quot;
INVALID_ORDER_AMOUNT | &quot;invalid_order_amount&quot;
INVALID_ORDER_AMOUNT_CHANGE | &quot;invalid_order_amount_change&quot;
INVALID_PRODUCT_INACTIVE | &quot;invalid_product_inactive&quot;
INVALID_NAME | &quot;invalid_name&quot;
INVALID_ROLE | &quot;invalid_role&quot;
INVALID_CAMPAIGN_NAME | &quot;invalid_campaign_name&quot;
INVALID_CAMPAIGN_TIME | &quot;invalid_campaign_time&quot;
INVALID_CAMPAIGN_START_TIME | &quot;invalid_campaign_start_time&quot;
INVALID_CAMPAIGN_EXPIRED_TIME | &quot;invalid_campaign_expired_time&quot;
INVALID_CAMPAIGN_DISCOUNT_TYPE | &quot;invalid_campaign_discount_type&quot;
INVALID_CAMPAIGN_DISCOUNT_VALUE | &quot;invalid_campaign_discount_value&quot;
INVALID_CAMPAIGN_CONDITION_TYPE | &quot;invalid_campaign_condition_type&quot;
INVALID_VALUE | &quot;invalid_value&quot;
INVALID_THEME_NAME | &quot;invalid_theme_name&quot;
INVALID_LABEL_NAME | &quot;invalid_label_name&quot;
INVALID_SKU | &quot;invalid_sku&quot;
INVALID_CHARGE | &quot;invalid_charge&quot;
INVALID_FROM | &quot;invalid_from&quot;
INVALID_TO | &quot;invalid_to&quot;
INVALID_EXPORT_DATA_DATE_RANGE | &quot;invalid_export_data_date_range&quot;
INVALID_SECRET_KEY | &quot;invalid_secret_key&quot;
INVALID_AUTH_CODE | &quot;invalid_auth_code&quot;
INVALID_TERMINAL_ID | &quot;invalid_terminal_id&quot;
INVALID_LANG | &quot;invalid_lang&quot;
INVALID_TITLE | &quot;invalid_title&quot;
INVALID_CONTENT | &quot;invalid_content&quot;
INVALID_TYPE | &quot;invalid_type&quot;
INVALID_LEGAL_REGISTRATION_NO | &quot;invalid_legal_registration_no&quot;
INVALID_COUNTRY | &quot;invalid_country&quot;
INVALID_PUBLISH_DATE | &quot;invalid_publish_date&quot;
INVALID_JSON_FORMAT | &quot;invalid_json_format&quot;
INVALID_TITLE_LENGTH | &quot;invalid_title_length&quot;
INVALID_NAME_LENGTH | &quot;invalid_name_length&quot;
INVALID_REF_TYPE_LENGTH | &quot;invalid_ref_type_length&quot;
INVALID_REF_ID_LENGTH | &quot;invalid_ref_id_length&quot;
INVALID_TYPE_LENGTH | &quot;invalid_type_length&quot;
INVALID_DESC_LENGTH | &quot;invalid_desc_length&quot;
INVALID_KEY_LENGTH | &quot;invalid_key_length&quot;
INVALID_CODE_LENGTH | &quot;invalid_code_length&quot;
INVALID_LEGAL_REGISTRATION_NO_LENGTH | &quot;invalid_legal_registration_no_length&quot;
INVALID_ESTABLISHMENT_DATE_LENGTH | &quot;invalid_establishment_date_length&quot;
INVALID_COUNTRY_LENGTH | &quot;invalid_country_length&quot;
INVALID_BANK_CODE_LENGTH | &quot;invalid_bank_code_length&quot;
INVALID_BRANCH_CODE_LENGTH | &quot;invalid_branch_code_length&quot;
INVALID_BANK_ACCOUNT_NUMBER_LENGTH | &quot;invalid_bank_account_number_length&quot;
INVALID_BIRTHDAY_LENGTH | &quot;invalid_birthday_length&quot;
INVALID_EMAIL_LENGTH | &quot;invalid_email_length&quot;
INVALID_ZIP_LENGTH | &quot;invalid_zip_length&quot;
INVALID_TEL_LENGTH | &quot;invalid_tel_length&quot;
INVALID_FAX_LENGTH | &quot;invalid_fax_length&quot;
INVALID_SORT_ORDER_LENGTH | &quot;invalid_sort_order_length&quot;
INVALID_PARKING_RACK_NO | &quot;invalid_parking_rack_no&quot;
INVALID_PARKING_RACK_STATUS | &quot;invalid_parking_rack_status&quot;
INVALID_PARKING_RACK_STATUS_NOT_USED | &quot;invalid_parking_rack_status_not_used&quot;
INVALID_PARKING_RACK_STATUS_OPENED | &quot;invalid_parking_rack_status_opened&quot;
INVALID_PARKING_RACK_STATUS_LOCKED | &quot;invalid_parking_rack_status_locked&quot;
INVALID_PARKING_RACK_STATUS_CONNECT_FAIL | &quot;invalid_parking_rack_status_connect_fail&quot;
INVALID_PARKING_NO_OR_RACK_NO | &quot;invalid_parking_no_or_rack_no&quot;
INVALID_PARKING_PIN_CODE | &quot;invalid_parking_pin_code&quot;
INCORRECT_CURRENCY | &quot;incorrect_currency&quot;
INCORRECT_CARD_NUMBER | &quot;incorrect_card_number&quot;
INCORRECT_AMOUNT | &quot;incorrect_amount&quot;
INCORRECT_MERCHANT_ID | &quot;incorrect_merchant_id&quot;
INCORRECT_PRODUCT_ID | &quot;incorrect_product_id&quot;
INCORRECT_EXPORT_DATA_DATE_RANGE | &quot;incorrect_export_data_date_range&quot;
INCORRECT_STATUS | &quot;incorrect_status&quot;
PROVIDER_RESPONSE_RESULT_FAILED | &quot;provider_response_result_failed&quot;
NO_SUCH_TOKEN | &quot;no_such_token&quot;
DUPLICATE_ORDER_NO | &quot;duplicate_order_no&quot;
DUPLICATE_SHOP_NO | &quot;duplicate_shop_no&quot;
DUPLICATE_CONTRACT_NUMBER | &quot;duplicate_contract_number&quot;
DUPLICATE_EMAIL | &quot;duplicate_email&quot;
DUPLICATE_LEGAL_REGISTRATION_NO | &quot;duplicate_legal_registration_no&quot;
DUPLICATE_KEY | &quot;duplicate_key&quot;
DUPLICATE_CATEGORY_NAME | &quot;duplicate_category_name&quot;
EXPIRED_CARD | &quot;expired_card&quot;
CARD_DECLINED | &quot;card_declined&quot;
PROCESSING_CARD_ERROR | &quot;processing_card_error&quot;
REQUIRED_KEY | &quot;required_key&quot;
CHARGE_ALREADY_CAPTURED | &quot;charge_already_captured&quot;
CHARGE_ALREADY_REFUNDED | &quot;charge_already_refunded&quot;
REFUSED_REFUND | &quot;refused_refund&quot;
REFUSED_REFUND_CONSTRAINT_DAY | &quot;refused_refund_constraint_day&quot;
REFUSED_REFUND_NON_CAPTURED | &quot;refused_refund_non_captured&quot;
INACTIVE_APPLICATION | &quot;inactive_application&quot;
INACTIVE_PAYMENT_METHOD | &quot;inactive_payment_method&quot;
INACTIVE_PRODUCT | &quot;inactive_product&quot;
EXIST_PAYMENT_METHOD | &quot;exist_payment_method&quot;
CAMPAIGN_ALREADY_STARTED | &quot;campaign_already_started&quot;
OVER_SHOP_LIMIT_COUNT | &quot;over_shop_limit_count&quot;
OVER_PRODUCT_LIMIT_COUNT | &quot;over_product_limit_count&quot;
PROCESS_ERROR | &quot;process_error&quot;
API_CONNECTION_ERROR | &quot;api_connection_error&quot;
PROVIDER_CONFIG_ERROR | &quot;provider_config_error&quot;
API_ERROR | &quot;api_error&quot;
FORBIDDEN | &quot;forbidden&quot;
FORBIDDEN_CLOSE_SELF | &quot;forbidden_close_self&quot;
RECAPTCHA_FAIL | &quot;recaptcha_fail&quot;



