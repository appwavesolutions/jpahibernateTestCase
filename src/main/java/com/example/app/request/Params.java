package com.example.app.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
	@JsonSubTypes.Type(value = CreateAccountParams.class, name = "CREATE_ACCOUNT"),
	@JsonSubTypes.Type(value = PlaceOrderParams.class, name = "PLACE_ORDER"),
	@JsonSubTypes.Type(value = SendEmailParams.class, name = "SEND_EMAIL")
})
public abstract class Params {
}
